package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class CategoryTypeController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        getByCode:'GET',
        shortList:'GET',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond CategoryType.list(params), model:[categoryTypeInstanceCount: CategoryType.count()]
        } 
        else {
            respond CategoryType.findAllByRecStatus(params.recStatus, params), model:[categoryTypeInstanceCount: CategoryType.count()] 
        } 
    }
    
    def show(CategoryType categoryTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && categoryTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond categoryTypeInstance
    }

    def create() {
        respond new CategoryType(params)
    }

    @Transactional
    def save(CategoryType categoryTypeInstance) {
        if (categoryTypeInstance == null) {
            notFound()
            return
        }

        if (categoryTypeInstance.hasErrors()) {
            respond categoryTypeInstance.errors, view:'create'
            return
        }

        categoryTypeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'categoryTypeInstance.label', default: 'CategoryType'), categoryTypeInstance.id])
                redirect categoryTypeInstance
            }
            '*' { respond categoryTypeInstance, [status: CREATED] }
        }
    }

    def edit(CategoryType categoryTypeInstance) {
        respond categoryTypeInstance
    }

    @Transactional
    def update(CategoryType categoryTypeInstance) {
        if (categoryTypeInstance == null) {
            notFound()
            return
        }

        if (categoryTypeInstance.hasErrors()) {
            respond categoryTypeInstance.errors, view:'edit'
            return
        }

        categoryTypeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CategoryType.label', default: 'CategoryType'), categoryTypeInstance.id])
                redirect categoryTypeInstance
            }
            '*'{ respond categoryTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CategoryType categoryTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/categoryType/delete/2
        if (categoryTypeInstance == null) {
            notFound()
            return
        }
        categoryTypeInstance.recStatus="Deleted"
        categoryTypeInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CategoryType.label', default: 'CategoryType'), categoryTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond categoryTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(CategoryType categoryTypeInstance) { 
        // example: http://localhost:9991/Commons/categoryType/undelete/2
        if (categoryTypeInstance == null) {
            notFound()
            return
        }
        categoryTypeInstance.recStatus="Active"
        categoryTypeInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'CategoryType.label', default: 'CategoryType'), categoryTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond categoryTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'categoryTypeInstance.label', default: 'CategoryType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /categoryType/getByCode.xml?code=bn
    def getByCode(String code) {
        // example: <server:port>/Commons/categoryType/getByCode?code=brn
        //          <server:port>/Commons/categoryType/getByCode/brn
        if (!code) {
            request.withFormat {
                '*'{ render status: 400}
            }
            return           
        }
        def categoryTypeInstance = CategoryType.findByCode(code.toLowerCase()) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (categoryTypeInstance==null || categoryTypeInstance != params.recStatus) {
            request.withFormat {
                '*'{ render status: NOT_FOUND}
            }
            return
        }          
        withFormat{       
                html {render categoryTypeInstance as JSON}
                xml  {render categoryTypeInstance as XML}
                '*'  {render categoryTypeInstance as JSON}
        }     
    }
         
    def shortList() {
        // example: <server:port>/Commons/categoryType/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def categoryTypeInstance 
        if (params.recStatus == "All" ) { 
            categoryTypeInstance = CategoryType.list(params)
        } 
        else {
            categoryTypeInstance = CategoryType.findAllByRecStatus(params.recStatus, params)
        }        
        if (categoryTypeInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        categoryTypeInstance.each {
           result[it.code] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from CategoryType
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("CategoryType")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def categoryTypeInstance
        try {
            categoryTypeInstance =  CategoryType.executeQuery(query)
        } catch (Exception e){
//            println "EMPTY RESULT"
            response.status = 404 // Not Found
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
//        render "$query"
        JSON.use('deep')
        XML.use('deep') 
//        println "GOOD RESULT"
        withFormat{
            json {render categoryTypeInstance as JSON}
            xml  {render categoryTypeInstance as XML}
            '*'  {render categoryTypeInstance as JSON}
        }
    }        

}
