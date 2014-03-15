package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class AccOwnerController {

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
            respond AccOwner.list(params), model:[accOwnerInstanceCount: AccOwner.count()]
        } 
        else {
            respond AccOwner.findAllByRecStatus(params.recStatus, params), model:[accOwnerInstanceCount: AccOwner.count()] 
        } 
    }
    
    def show(AccOwner accOwnerInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && accOwnerInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond accOwnerInstance
    }

    def create() {
        respond new AccOwner(params)
    }

    @Transactional
    def save(AccOwner accOwnerInstance) {
        if (accOwnerInstance == null) {
            notFound()
            return
        }

        if (accOwnerInstance.hasErrors()) {
            respond accOwnerInstance.errors, view:'create'
            return
        }

        accOwnerInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accOwnerInstance.label', default: 'AccOwner'), accOwnerInstance.id])
                redirect accOwnerInstance
            }
            '*' { respond accOwnerInstance, [status: CREATED] }
        }
    }

    def edit(AccOwner accOwnerInstance) {
        respond accOwnerInstance
    }

    @Transactional
    def update(AccOwner accOwnerInstance) {
        if (accOwnerInstance == null) {
            notFound()
            return
        }

        if (accOwnerInstance.hasErrors()) {
            respond accOwnerInstance.errors, view:'edit'
            return
        }

        accOwnerInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AccOwner.label', default: 'AccOwner'), accOwnerInstance.id])
                redirect accOwnerInstance
            }
            '*'{ respond accOwnerInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AccOwner accOwnerInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/accOwner/delete/2
        if (accOwnerInstance == null) {
            notFound()
            return
        }
        accOwnerInstance.recStatus="Deleted"
        accOwnerInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AccOwner.label', default: 'AccOwner'), accOwnerInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond accOwnerInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(AccOwner accOwnerInstance) { 
        // example: http://localhost:9991/Commons/accOwner/undelete/2
        if (accOwnerInstance == null) {
            notFound()
            return
        }
        accOwnerInstance.recStatus="Active"
        accOwnerInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'AccOwner.label', default: 'AccOwner'), accOwnerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond accOwnerInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accOwnerInstance.label', default: 'AccOwner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /accOwner/getByCodeName.xml?codeName=cn
    def getByCodeName(String codeName) {
        // example: <server:port>/Commons/accOwner/getByCodeName?code=brn
        //          <server:port>/Commons/accOwner/getByCodeName/brn
        if (!codeName) {
            request.withFormat {
                '*'{ render status: 400}
            }
            return           
        }
        def accOwnerInstance = AccOwner.findByCodeName(codeName.toLowerCase()) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (accOwnerInstance==null || accOwnerInstance != params.recStatus) {
            request.withFormat {
                '*'{ render status: NOT_FOUND}
            }
            return
        }          
        withFormat{       
                html {render accOwnerInstance as JSON}
                xml  {render accOwnerInstance as XML}
                '*'  {render accOwnerInstance as JSON}
        }     
    }
         
    def shortList() {
        // example: <server:port>/Commons/accOwner/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def accOwnerInstance 
        if (params.recStatus == "All" ) { 
            accOwnerInstance = AccOwner.list(params)
        } 
        else {
            accOwnerInstance = AccOwner.findAllByRecStatus(params.recStatus, params)
        }        
        if (accOwnerInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        accOwnerInstance.each {
           result[it.codeName] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from AccOwner
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("AccOwner")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def accOwnerInstance
        try {
            accOwnerInstance =  AccOwner.executeQuery(query)
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
            json {render accOwnerInstance as JSON}
            xml  {render accOwnerInstance as XML}
            '*'  {render accOwnerInstance as JSON}
        }
    }        

}
