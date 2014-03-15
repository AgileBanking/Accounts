package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class AccOwnershipController {

    static allowedMethods = [
        show:'GET',
        edit:['GET', 'POST'],
        save:['PUT','POST'],
        update:['POST','PUT'], 
        delete:'POST',
        undelete:'POST',
        shortList:'GET',
        customQuery:'GET'
    ]

    def index(Integer max) { 
        params.max = Math.min(max ?: 10, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize() 
        if (params.recStatus == "All" ) { 
            respond AccOwnership.list(params), model:[accOwnershipInstanceCount: AccOwnership.count()]
        } 
        else {
            respond AccOwnership.findAllByRecStatus(params.recStatus, params), model:[accOwnershipInstanceCount: AccOwnership.count()] 
        } 
    }
    
    def show(AccOwnership accOwnershipInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && accOwnershipInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond accOwnershipInstance
    }

    def create() {
        respond new AccOwnership(params)
    }

    @Transactional
    def save(AccOwnership accOwnershipInstance) {
        if (accOwnershipInstance == null) {
            notFound()
            return
        }

        if (accOwnershipInstance.hasErrors()) {
            respond accOwnershipInstance.errors, view:'create'
            return
        }

        accOwnershipInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accOwnershipInstance.label', default: 'AccOwnership'), accOwnershipInstance.id])
                redirect accOwnershipInstance
            }
            '*' { respond accOwnershipInstance, [status: CREATED] }
        }
    }

    def edit(AccOwnership accOwnershipInstance) {
        respond accOwnershipInstance
    }

    @Transactional
    def update(AccOwnership accOwnershipInstance) {
        if (accOwnershipInstance == null) {
            notFound()
            return
        }

        if (accOwnershipInstance.hasErrors()) {
            respond accOwnershipInstance.errors, view:'edit'
            return
        }

        accOwnershipInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AccOwnership.label', default: 'AccOwnership'), accOwnershipInstance.id])
                redirect accOwnershipInstance
            }
            '*'{ respond accOwnershipInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AccOwnership accOwnershipInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/accOwnership/delete/2
        if (accOwnershipInstance == null) {
            notFound()
            return
        }
        accOwnershipInstance.recStatus="Deleted"
        accOwnershipInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AccOwnership.label', default: 'AccOwnership'), accOwnershipInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond accOwnershipInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(AccOwnership accOwnershipInstance) { 
        // example: http://localhost:9991/Commons/accOwnership/undelete/2
        if (accOwnershipInstance == null) {
            notFound()
            return
        }
        accOwnershipInstance.recStatus="Active"
        accOwnershipInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'AccOwnership.label', default: 'AccOwnership'), accOwnershipInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond accOwnershipInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accOwnershipInstance.label', default: 'AccOwnership'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    } 
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from AccOwnership
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("AccOwnership")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def accOwnershipInstance
        try {
            accOwnershipInstance =  AccOwnership.executeQuery(query)
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
            json {render accOwnershipInstance as JSON}
            xml  {render accOwnershipInstance as XML}
            '*'  {render accOwnershipInstance as JSON}
        }
    }        

}
