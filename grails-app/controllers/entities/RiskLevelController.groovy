package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class RiskLevelController {

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
            respond RiskLevel.list(params), model:[riskLevelInstanceCount: RiskLevel.count()]
        } 
        else {
            respond RiskLevel.findAllByRecStatus(params.recStatus, params), model:[riskLevelInstanceCount: RiskLevel.count()] 
        } 
    }
    
    def show(RiskLevel riskLevelInstance) {
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (params.recStatus != "All" && riskLevelInstance.recStatus != params.recStatus) { 
            notFound()
            return
        }            
        respond riskLevelInstance
    }

    def create() {
        respond new RiskLevel(params)
    }

    @Transactional
    def save(RiskLevel riskLevelInstance) {
        if (riskLevelInstance == null) {
            notFound()
            return
        }

        if (riskLevelInstance.hasErrors()) {
            respond riskLevelInstance.errors, view:'create'
            return
        }

        riskLevelInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'riskLevelInstance.label', default: 'RiskLevel'), riskLevelInstance.id])
                redirect riskLevelInstance
            }
            '*' { respond riskLevelInstance, [status: CREATED] }
        }
    }

    def edit(RiskLevel riskLevelInstance) {
        respond riskLevelInstance
    }

    @Transactional
    def update(RiskLevel riskLevelInstance) {
        if (riskLevelInstance == null) {
            notFound()
            return
        }

        if (riskLevelInstance.hasErrors()) {
            respond riskLevelInstance.errors, view:'edit'
            return
        }

        riskLevelInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RiskLevel.label', default: 'RiskLevel'), riskLevelInstance.id])
                redirect riskLevelInstance
            }
            '*'{ respond riskLevelInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RiskLevel riskLevelInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/riskLevel/delete/2
        if (riskLevelInstance == null) {
            notFound()
            return
        }
        riskLevelInstance.recStatus="Deleted"
        riskLevelInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RiskLevel.label', default: 'RiskLevel'), riskLevelInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond riskLevelInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(RiskLevel riskLevelInstance) { 
        // example: http://localhost:9991/Commons/riskLevel/undelete/2
        if (riskLevelInstance == null) {
            notFound()
            return
        }
        riskLevelInstance.recStatus="Active"
        riskLevelInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'RiskLevel.label', default: 'RiskLevel'), riskLevelInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond riskLevelInstance //, [status: NO_CONTENT] 
            }
        }
    }    

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'riskLevelInstance.label', default: 'RiskLevel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    // READ ONLY Services. They return either XML or JSON (Default)
    // the format is declared at the end of URI, e.g. /riskLevel/getByCode.xml?code=bn
    def getByCode(String code) {
        // example: <server:port>/Commons/riskLevel/getByCode?code=brn
        //          <server:port>/Commons/riskLevel/getByCode/brn
        if (!code) {
            request.withFormat {
                '*'{ render status: 400}
            }
            return           
        }
        def riskLevelInstance = RiskLevel.findByCode(code.toLowerCase()) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        if (riskLevelInstance==null || riskLevelInstance != params.recStatus) {
            request.withFormat {
                '*'{ render status: NOT_FOUND}
            }
            return
        }          
        withFormat{       
                html {render riskLevelInstance as JSON}
                xml  {render riskLevelInstance as XML}
                '*'  {render riskLevelInstance as JSON}
        }     
    }
         
    def shortList() {
        // example: <server:port>/Commons/riskLevel/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        params.recStatus = (params.recStatus ? params.recStatus.toLowerCase() : "Active").capitalize()
        def riskLevelInstance 
        if (params.recStatus == "All" ) { 
            riskLevelInstance = RiskLevel.list(params)
        } 
        else {
            riskLevelInstance = RiskLevel.findAllByRecStatus(params.recStatus, params)
        }        
        if (riskLevelInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        riskLevelInstance.each {
           result[it.code] = [title:"$it.title", titleInt:"$it.titleInt", id:"$it.id"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from RiskLevel
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("RiskLevel")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def riskLevelInstance
        try {
            riskLevelInstance =  RiskLevel.executeQuery(query)
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
            json {render riskLevelInstance as JSON}
            xml  {render riskLevelInstance as XML}
            '*'  {render riskLevelInstance as JSON}
        }
    }        

}
