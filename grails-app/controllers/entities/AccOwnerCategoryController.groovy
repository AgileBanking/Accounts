package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class AccOwnerCategoryController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        getByCodeName:'GET',
        shortList:'GET',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond AccOwnerCategory.list(params), model:[accOwnerCategoryInstanceCount: AccOwnerCategory.count()]
        } 
        else {
            respond AccOwnerCategory.findAllByRecStatus(params.recStatus, params), model:[accOwnerCategoryInstanceCount: AccOwnerCategory.count()] 
        } 
    }
    
    def show(AccOwnerCategory accOwnerCategoryInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && accOwnerCategoryInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond accOwnerCategoryInstance
    }

    def create() {
        respond new AccOwnerCategory(params)
    }

    @Transactional
    def save(AccOwnerCategory accOwnerCategoryInstance) {
        if (accOwnerCategoryInstance == null) {
            notFound()
            return
        }

        if (accOwnerCategoryInstance.hasErrors()) {
            respond accOwnerCategoryInstance.errors, view:'create'
            return
        }

        accOwnerCategoryInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accOwnerCategoryInstance.label', default: 'AccOwnerCategory'), accOwnerCategoryInstance.id])
                redirect accOwnerCategoryInstance
            }
            '*' { respond accOwnerCategoryInstance, [status: CREATED] }
        }
    }

    def edit(AccOwnerCategory accOwnerCategoryInstance) {
        respond accOwnerCategoryInstance
    }

    @Transactional
    def update(AccOwnerCategory accOwnerCategoryInstance) {
        if (accOwnerCategoryInstance == null) {
            notFound()
            return
        }

        if (accOwnerCategoryInstance.hasErrors()) {
            respond accOwnerCategoryInstance.errors, view:'edit'
            return
        }

        accOwnerCategoryInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AccOwnerCategory.label', default: 'AccOwnerCategory'), accOwnerCategoryInstance.id])
                redirect accOwnerCategoryInstance
            }
            '*'{ respond accOwnerCategoryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AccOwnerCategory accOwnerCategoryInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/accOwnerCategory/delete/2
        if (accOwnerCategoryInstance == null) {
            notFound()
            return
        }
        accOwnerCategoryInstance.recStatus="Deleted"
        accOwnerCategoryInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AccOwnerCategory.label', default: 'AccOwnerCategory'), accOwnerCategoryInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond accOwnerCategoryInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(AccOwnerCategory accOwnerCategoryInstance) { 
        // example: http://localhost:9991/Commons/accOwnerCategory/undelete/2
        if (accOwnerCategoryInstance == null) {
            notFound()
            return
        }
        accOwnerCategoryInstance.recStatus="Active"
        accOwnerCategoryInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'AccOwnerCategory.label', default: 'AccOwnerCategory'), accOwnerCategoryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond accOwnerCategoryInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accOwnerCategoryInstance.label', default: 'AccOwnerCategory'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /accOwnerCategory/getByCode.xml?code=bn
    def getByCodeName(String codeName) {
        // example: <server:port>/Commons/accOwnerCategory/getBygetByCodeName?codeName=brn
        if (!codeName) {
            request.withFormat {
                '*'{ render status: 400}
            }
            return           
        }
        def accOwnerCategoryInstance = AccOwnerCategory.findByCode(codeName.toUpperCase()) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (accOwnerCategoryInstance==null || accOwnerCategoryInstance != params.recStatus) {
            request.withFormat {
                '*'{ render status: NOT_FOUND}
            }
            return
        }          
        withFormat{       
                html {render accOwnerCategoryInstance as JSON}
                xml  {render accOwnerCategoryInstance as XML}
                '*'  {render accOwnerCategoryInstance as JSON}
        }     
    }
         
    def shortList() {
        // example: <server:port>/Commons/accOwnerCategory/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def accOwnerCategoryInstance 
        if (params.recStatus == "All" ) { 
            accOwnerCategoryInstance = AccOwnerCategory.list(params)
        } 
        else {
            accOwnerCategoryInstance = AccOwnerCategory.findAllByRecStatus(params.recStatus, params)
        }        
        if (accOwnerCategoryInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        accOwnerCategoryInstance.each {
           result[it.codeName] = [ownerType:"$it.ownerType", originOrgUnit:"$it.originOrgUnit", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from AccOwnerCategory
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("AccOwnerCategory")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def accOwnerCategoryInstance
        try {
            accOwnerCategoryInstance =  AccOwnerCategory.executeQuery(query)
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
            json {render accOwnerCategoryInstance as JSON}
            xml  {render accOwnerCategoryInstance as XML}
            '*'  {render accOwnerCategoryInstance as JSON}
        }
    }        

}
