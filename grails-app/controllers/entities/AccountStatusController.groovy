package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class AccountStatusController {

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
            respond AccountStatus.list(params), model:[accountStatusInstanceCount: AccountStatus.count()]
        } 
        else {
            respond AccountStatus.findAllByRecStatus(params.recStatus, params), model:[accountStatusInstanceCount: AccountStatus.count()] 
        } 
    }
    
    def show(AccountStatus accountStatusInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && accountStatusInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond accountStatusInstance
    }

    def create() {
        respond new AccountStatus(params)
    }

    @Transactional
    def save(AccountStatus accountStatusInstance) {
        if (accountStatusInstance == null) {
            notFound()
            return
        }

        if (accountStatusInstance.hasErrors()) {
            respond accountStatusInstance.errors, view:'create'
            return
        }

        accountStatusInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accountStatusInstance.label', default: 'AccountStatus'), accountStatusInstance.id])
                redirect accountStatusInstance
            }
            '*' { respond accountStatusInstance, [status: CREATED] }
        }
    }

    def edit(AccountStatus accountStatusInstance) {
        respond accountStatusInstance
    }

    @Transactional
    def update(AccountStatus accountStatusInstance) {
        if (accountStatusInstance == null) {
            notFound()
            return
        }

        if (accountStatusInstance.hasErrors()) {
            respond accountStatusInstance.errors, view:'edit'
            return
        }

        accountStatusInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AccountStatus.label', default: 'AccountStatus'), accountStatusInstance.id])
                redirect accountStatusInstance
            }
            '*'{ respond accountStatusInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AccountStatus accountStatusInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/accountStatus/delete/2
        if (accountStatusInstance == null) {
            notFound()
            return
        }
        accountStatusInstance.recStatus="Deleted"
        accountStatusInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AccountStatus.label', default: 'AccountStatus'), accountStatusInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond accountStatusInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(AccountStatus accountStatusInstance) { 
        // example: http://localhost:9991/Commons/accountStatus/undelete/2
        if (accountStatusInstance == null) {
            notFound()
            return
        }
        accountStatusInstance.recStatus="Active"
        accountStatusInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'AccountStatus.label', default: 'AccountStatus'), accountStatusInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond accountStatusInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accountStatusInstance.label', default: 'AccountStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /accountStatus/getByCode.xml?code=bn
         
    def shortList() {
        // example: <server:port>/Commons/accountStatus/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def accountStatusInstance 
        if (params.recStatus == "All" ) { 
            accountStatusInstance = AccountStatus.list(params)
        } 
        else {
            accountStatusInstance = AccountStatus.findAllByRecStatus(params.recStatus, params)
        }        
        if (accountStatusInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        accountStatusInstance.each {
           result["$it.title/$it.titleInt"] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from AccountStatus
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("AccountStatus")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def accountStatusInstance
        try {
            accountStatusInstance =  AccountStatus.executeQuery(query)
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
            json {render accountStatusInstance as JSON}
            xml  {render accountStatusInstance as XML}
            '*'  {render accountStatusInstance as JSON}
        }
    }        

}
