package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class AccountTypeController {

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
            respond AccountType.list(params), model:[accountTypeInstanceCount: AccountType.count()]
        } 
        else {
            respond AccountType.findAllByRecStatus(params.recStatus, params), model:[accountTypeInstanceCount: AccountType.count()] 
        } 
    }
    
    def show(AccountType accountTypeInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && accountTypeInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond accountTypeInstance
    }

    def create() {
        respond new AccountType(params)
    }

    @Transactional
    def save(AccountType accountTypeInstance) {
        if (accountTypeInstance == null) {
            notFound()
            return
        }

        if (accountTypeInstance.hasErrors()) {
            respond accountTypeInstance.errors, view:'create'
            return
        }

        accountTypeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'accountTypeInstance.label', default: 'AccountType'), accountTypeInstance.id])
                redirect accountTypeInstance
            }
            '*' { respond accountTypeInstance, [status: CREATED] }
        }
    }

    def edit(AccountType accountTypeInstance) {
        respond accountTypeInstance
    }

    @Transactional
    def update(AccountType accountTypeInstance) {
        if (accountTypeInstance == null) {
            notFound()
            return
        }

        if (accountTypeInstance.hasErrors()) {
            respond accountTypeInstance.errors, view:'edit'
            return
        }

        accountTypeInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'AccountType.label', default: 'AccountType'), accountTypeInstance.id])
                redirect accountTypeInstance
            }
            '*'{ respond accountTypeInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(AccountType accountTypeInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/accountType/delete/2
        if (accountTypeInstance == null) {
            notFound()
            return
        }
        accountTypeInstance.recStatus="Deleted"
        accountTypeInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'AccountType.label', default: 'AccountType'), accountTypeInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond accountTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(AccountType accountTypeInstance) { 
        // example: http://localhost:9991/Commons/accountType/undelete/2
        if (accountTypeInstance == null) {
            notFound()
            return
        }
        accountTypeInstance.recStatus="Active"
        accountTypeInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'AccountType.label', default: 'AccountType'), accountTypeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond accountTypeInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accountTypeInstance.label', default: 'AccountType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
         
    def shortList() {
        // example: <server:port>/Commons/accountType/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def accountTypeInstance 
        if (params.recStatus == "All" ) { 
            accountTypeInstance = AccountType.list(params)
        } 
        else {
            accountTypeInstance = AccountType.findAllByRecStatus(params.recStatus, params)
        }        
        if (accountTypeInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        accountTypeInstance.each {
           result["$it.title/$it.titleInt"] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from AccountType
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("AccountType")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def accountTypeInstance
        try {
            accountTypeInstance =  AccountType.executeQuery(query)
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
            json {render accountTypeInstance as JSON}
            xml  {render accountTypeInstance as XML}
            '*'  {render accountTypeInstance as JSON}
        }
    }        

}
