package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class StatementFrequencyController {

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
            respond StatementFrequency.list(params), model:[statementFrequencyInstanceCount: StatementFrequency.count()]
        } 
        else {
            respond StatementFrequency.findAllByRecStatus(params.recStatus, params), model:[statementFrequencyInstanceCount: StatementFrequency.count()] 
        } 
    }
    
    def show(StatementFrequency statementFrequencyInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && statementFrequencyInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond statementFrequencyInstance
    }

    def create() {
        respond new StatementFrequency(params)
    }

    @Transactional
    def save(StatementFrequency statementFrequencyInstance) {
        if (statementFrequencyInstance == null) {
            notFound()
            return
        }

        if (statementFrequencyInstance.hasErrors()) {
            respond statementFrequencyInstance.errors, view:'create'
            return
        }

        statementFrequencyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'statementFrequencyInstance.label', default: 'StatementFrequency'), statementFrequencyInstance.id])
                redirect statementFrequencyInstance
            }
            '*' { respond statementFrequencyInstance, [status: CREATED] }
        }
    }

    def edit(StatementFrequency statementFrequencyInstance) {
        respond statementFrequencyInstance
    }

    @Transactional
    def update(StatementFrequency statementFrequencyInstance) {
        if (statementFrequencyInstance == null) {
            notFound()
            return
        }

        if (statementFrequencyInstance.hasErrors()) {
            respond statementFrequencyInstance.errors, view:'edit'
            return
        }

        statementFrequencyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'StatementFrequency.label', default: 'StatementFrequency'), statementFrequencyInstance.id])
                redirect statementFrequencyInstance
            }
            '*'{ respond statementFrequencyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(StatementFrequency statementFrequencyInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/statementFrequency/delete/2
        if (statementFrequencyInstance == null) {
            notFound()
            return
        }
        statementFrequencyInstance.recStatus="Deleted"
        statementFrequencyInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'StatementFrequency.label', default: 'StatementFrequency'), statementFrequencyInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond statementFrequencyInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(StatementFrequency statementFrequencyInstance) { 
        // example: http://localhost:9991/Commons/statementFrequency/undelete/2
        if (statementFrequencyInstance == null) {
            notFound()
            return
        }
        statementFrequencyInstance.recStatus="Active"
        statementFrequencyInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'StatementFrequency.label', default: 'StatementFrequency'), statementFrequencyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond statementFrequencyInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'statementFrequencyInstance.label', default: 'StatementFrequency'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /statementFrequency/getByCode.xml?code=bn
    def getByCode(String code) {
        // example: <server:port>/Commons/statementFrequency/getByCode?code=brn
        //          <server:port>/Commons/statementFrequency/getByCode/brn
        if (!code) {
            request.withFormat {
                '*'{ render status: 400}
            }
            return           
        }
        def statementFrequencyInstance = StatementFrequency.findByCode(code.toLowerCase()) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (statementFrequencyInstance==null || statementFrequencyInstance != params.recStatus) {
            request.withFormat {
                '*'{ render status: NOT_FOUND}
            }
            return
        }          
        withFormat{       
                html {render statementFrequencyInstance as JSON}
                xml  {render statementFrequencyInstance as XML}
                '*'  {render statementFrequencyInstance as JSON}
        }     
    }
         
    def shortList() {
        // example: <server:port>/Commons/statementFrequency/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def statementFrequencyInstance 
        if (params.recStatus == "All" ) { 
            statementFrequencyInstance = StatementFrequency.list(params)
        } 
        else {
            statementFrequencyInstance = StatementFrequency.findAllByRecStatus(params.recStatus, params)
        }        
        if (statementFrequencyInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        statementFrequencyInstance.each {
           result[it.code] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from StatementFrequency
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("StatementFrequency")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def statementFrequencyInstance
        try {
            statementFrequencyInstance =  StatementFrequency.executeQuery(query)
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
            json {render statementFrequencyInstance as JSON}
            xml  {render statementFrequencyInstance as XML}
            '*'  {render statementFrequencyInstance as JSON}
        }
    }        

}
