package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class ShadowAccountController {

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
            respond ShadowAccount.list(params), model:[shadowAccountInstanceCount: ShadowAccount.count()]
        } 
        else {
            respond ShadowAccount.findAllByRecStatus(params.recStatus, params), model:[shadowAccountInstanceCount: ShadowAccount.count()] 
        } 
    }
    
    def show(ShadowAccount shadowAccountInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && shadowAccountInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond shadowAccountInstance
    }

    def create() {
        respond new ShadowAccount(params)
    }

    @Transactional
    def save(ShadowAccount shadowAccountInstance) {
        if (shadowAccountInstance == null) {
            notFound()
            return
        }

        if (shadowAccountInstance.hasErrors()) {
            respond shadowAccountInstance.errors, view:'create'
            return
        }

        shadowAccountInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'shadowAccountInstance.label', default: 'ShadowAccount'), shadowAccountInstance.id])
                redirect shadowAccountInstance
            }
            '*' { respond shadowAccountInstance, [status: CREATED] }
        }
    }

    def edit(ShadowAccount shadowAccountInstance) {
        respond shadowAccountInstance
    }

    @Transactional
    def update(ShadowAccount shadowAccountInstance) {
        if (shadowAccountInstance == null) {
            notFound()
            return
        }

        if (shadowAccountInstance.hasErrors()) {
            respond shadowAccountInstance.errors, view:'edit'
            return
        }

        shadowAccountInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ShadowAccount.label', default: 'ShadowAccount'), shadowAccountInstance.id])
                redirect shadowAccountInstance
            }
            '*'{ respond shadowAccountInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ShadowAccount shadowAccountInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/shadowAccount/delete/2
        if (shadowAccountInstance == null) {
            notFound()
            return
        }
        shadowAccountInstance.recStatus="Deleted"
        shadowAccountInstance.save flush:true
    
        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ShadowAccount.label', default: 'ShadowAccount'), shadowAccountInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond shadowAccountInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(ShadowAccount shadowAccountInstance) { 
        // example: http://localhost:9991/Commons/shadowAccount/undelete/2
        if (shadowAccountInstance == null) {
            notFound()
            return
        }
        shadowAccountInstance.recStatus="Active"
        shadowAccountInstance.save flush:true 

        request.withFormat {
            form {
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'ShadowAccount.label', default: 'ShadowAccount'), shadowAccountInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond shadowAccountInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'shadowAccountInstance.label', default: 'ShadowAccount'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /shadowAccount/getByCode.xml?code=bn
    def getByCode(String code) {
        // example: <server:port>/Commons/shadowAccount/getByCode?code=brn
        //          <server:port>/Commons/shadowAccount/getByCode/brn
        if (!code) {
            request.withFormat {
                '*'{ render status: 400}
            }
            return           
        }
        def shadowAccountInstance = ShadowAccount.findByCode(code.toLowerCase()) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (shadowAccountInstance==null || shadowAccountInstance != params.recStatus) {
            request.withFormat {
                '*'{ render status: NOT_FOUND}
            }
            return
        }          
        withFormat{       
                html {render shadowAccountInstance as JSON}
                xml  {render shadowAccountInstance as XML}
                '*'  {render shadowAccountInstance as JSON}
        }     
    }
         
    def shortList() {
        // example: <server:port>/Commons/shadowAccount/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def shadowAccountInstance 
        if (params.recStatus == "All" ) { 
            shadowAccountInstance = ShadowAccount.list(params)
        } 
        else {
            shadowAccountInstance = ShadowAccount.findAllByRecStatus(params.recStatus, params)
        }        
        if (shadowAccountInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        shadowAccountInstance.each {
           result[it.code] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from ShadowAccount
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("ShadowAccount")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def shadowAccountInstance
        try {
            shadowAccountInstance =  ShadowAccount.executeQuery(query)
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
            json {render shadowAccountInstance as JSON}
            xml  {render shadowAccountInstance as XML}
            '*'  {render shadowAccountInstance as JSON}
        }
    }        

}
