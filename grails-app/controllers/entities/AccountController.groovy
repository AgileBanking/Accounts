package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class AccountController {

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
            respond Account.list(params), model:[accountInstanceCount: Account.count()]
        } 
        else {
            respond Account.findAllByRecStatus(params.recStatus, params), model:[accountInstanceCount: Account.count()] 
        } 
    }
    
    def show(Account accountInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && accountInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond accountInstance
    }

    def create() {
        respond new Account(params)
    }

    @Transactional
    def save(Account accountInstance) {
        if (accountInstance == null) {
            notFound()
            return
        }

        if (accountInstance.hasErrors()) {
            respond accountInstance.errors, view:'create'
            return
        }

        accountInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'accountInstance.label', default: 'Account'), accountInstance.id])
                redirect accountInstance
            }
            '*' { respond accountInstance, [status: CREATED] }
        }
    }

    def edit(Account accountInstance) {
        respond accountInstance
    }

    @Transactional
    def update(Account accountInstance) {
        if (accountInstance == null) {
            notFound()
            return
        }

        if (accountInstance.hasErrors()) {
            respond accountInstance.errors, view:'edit'
            return
        }

        accountInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Account.label', default: 'Account'), accountInstance.id])
                redirect accountInstance
            }
            '*'{ respond accountInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Account accountInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/account/delete/2
        if (accountInstance == null) {
            notFound()
            return
        }
        accountInstance.recStatus="Deleted"
        accountInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Account.label', default: 'Account'), accountInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond accountInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Account accountInstance) { 
        // example: http://localhost:9991/Commons/account/undelete/2
        if (accountInstance == null) {
            notFound()
            return
        }
        accountInstance.recStatus="Active"
        accountInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Account.label', default: 'Account'), accountInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond accountInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'accountInstance.label', default: 'Account'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /account/getByCode.xml?code=bn
    def getByCode(String code) {
        // example: <server:port>/Commons/account/getByCode?code=brn
        //          <server:port>/Commons/account/getByCode/brn
        if (!code) {
            request.withFormat {
                '*'{ render status: 400}
            }
            return           
        }
        def accountInstance = Account.findByCode(code.toLowerCase()) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (accountInstance==null || accountInstance != params.recStatus) {
            request.withFormat {
                '*'{ render status: NOT_FOUND}
            }
            return
        }          
        withFormat{       
                html {render accountInstance as JSON}
                xml  {render accountInstance as XML}
                '*'  {render accountInstance as JSON}
        }     
    }
         
    def shortList() {
        // example: <server:port>/Commons/account/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def accountInstance 
        if (params.recStatus == "All" ) { 
            accountInstance = Account.list(params)
        } 
        else {
            accountInstance = Account.findAllByRecStatus(params.recStatus, params)
        }        
        if (accountInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        accountInstance.each {
           result[it.code] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from Account
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("Account")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def accountInstance
        try {
            accountInstance =  Account.executeQuery(query)
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
            json {render accountInstance as JSON}
            xml  {render accountInstance as XML}
            '*'  {render accountInstance as JSON}
        }
    }        

}
