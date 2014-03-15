package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class StatementDeliveryController {

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
            respond StatementDelivery.list(params), model:[statementDeliveryInstanceCount: StatementDelivery.count()]
        } 
        else {
            respond StatementDelivery.findAllByRecStatus(params.recStatus, params), model:[statementDeliveryInstanceCount: StatementDelivery.count()] 
        } 
    }
    
    def show(StatementDelivery statementDeliveryInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && statementDeliveryInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond statementDeliveryInstance
    }

    def create() {
        respond new StatementDelivery(params)
    }

    @Transactional
    def save(StatementDelivery statementDeliveryInstance) {
        if (statementDeliveryInstance == null) {
            notFound()
            return
        }

        if (statementDeliveryInstance.hasErrors()) {
            respond statementDeliveryInstance.errors, view:'create'
            return
        }

        statementDeliveryInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'statementDeliveryInstance.label', default: 'StatementDelivery'), statementDeliveryInstance.id])
                redirect statementDeliveryInstance
            }
            '*' { respond statementDeliveryInstance, [status: CREATED] }
        }
    }

    def edit(StatementDelivery statementDeliveryInstance) {
        respond statementDeliveryInstance
    }

    @Transactional
    def update(StatementDelivery statementDeliveryInstance) {
        if (statementDeliveryInstance == null) {
            notFound()
            return
        }

        if (statementDeliveryInstance.hasErrors()) {
            respond statementDeliveryInstance.errors, view:'edit'
            return
        }

        statementDeliveryInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'StatementDelivery.label', default: 'StatementDelivery'), statementDeliveryInstance.id])
                redirect statementDeliveryInstance
            }
            '*'{ respond statementDeliveryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(StatementDelivery statementDeliveryInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/statementDelivery/delete/2
        if (statementDeliveryInstance == null) {
            notFound()
            return
        }
        statementDeliveryInstance.recStatus="Deleted"
        statementDeliveryInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'StatementDelivery.label', default: 'StatementDelivery'), statementDeliveryInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond statementDeliveryInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(StatementDelivery statementDeliveryInstance) { 
        // example: http://localhost:9991/Commons/statementDelivery/undelete/2
        if (statementDeliveryInstance == null) {
            notFound()
            return
        }
        statementDeliveryInstance.recStatus="Active"
        statementDeliveryInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'StatementDelivery.label', default: 'StatementDelivery'), statementDeliveryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond statementDeliveryInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'statementDeliveryInstance.label', default: 'StatementDelivery'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /statementDelivery/getByCode.xml?code=bn
    def getByCode(String code) {
        // example: <server:port>/Commons/statementDelivery/getByCode?code=brn
        //          <server:port>/Commons/statementDelivery/getByCode/brn
        if (!code) {
            request.withFormat {
                '*'{ render status: 400}
            }
            return           
        }
        def statementDeliveryInstance = StatementDelivery.findByCode(code.toLowerCase()) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (statementDeliveryInstance==null || statementDeliveryInstance != params.recStatus) {
            request.withFormat {
                '*'{ render status: NOT_FOUND}
            }
            return
        }          
        withFormat{       
                html {render statementDeliveryInstance as JSON}
                xml  {render statementDeliveryInstance as XML}
                '*'  {render statementDeliveryInstance as JSON}
        }     
    }
         
    def shortList() {
        // example: <server:port>/Commons/statementDelivery/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def statementDeliveryInstance 
        if (params.recStatus == "All" ) { 
            statementDeliveryInstance = StatementDelivery.list(params)
        } 
        else {
            statementDeliveryInstance = StatementDelivery.findAllByRecStatus(params.recStatus, params)
        }        
        if (statementDeliveryInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        statementDeliveryInstance.each {
           result[it.code] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from StatementDelivery
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("StatementDelivery")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def statementDeliveryInstance
        try {
            statementDeliveryInstance =  StatementDelivery.executeQuery(query)
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
            json {render statementDeliveryInstance as JSON}
            xml  {render statementDeliveryInstance as XML}
            '*'  {render statementDeliveryInstance as JSON}
        }
    }        

}
