package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.*
import grails.converters.*

@Transactional(readOnly = true)
class TransactionController {

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
          respond Transaction.list(params), model:[transactionInstanceCount: Transaction.count()]
      }
      
    
    def show(Transaction transactionInstance) {           
        respond transactionInstance
    }

    def create() {
        respond new Transaction(params)
    }

    @Transactional
    def save(Transaction transactionInstance) {
        if (transactionInstance == null) {
            notFound()
            return
        }

        if (transactionInstance.hasErrors()) {
            respond transactionInstance.errors, view:'create'
            return
        }

        transactionInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'transactionInstance.label', default: 'Transaction'), transactionInstance.id])
                redirect transactionInstance
            }
            '*' { respond transactionInstance, [status: CREATED] }
        }
    }

    def edit(Transaction transactionInstance) {
        respond transactionInstance
    }
/*
    @Transactional
    def update(Transaction transactionInstance) {
        if (transactionInstance == null) {
            notFound()
            return
        }

        if (transactionInstance.hasErrors()) {
            respond transactionInstance.errors, view:'edit'
            return
        }

        transactionInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Transaction.label', default: 'Transaction'), transactionInstance.id])
                redirect transactionInstance
            }
            '*'{ respond transactionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Transaction transactionInstance) {
        //Pretend deletion
        // example: http://localhost:9991/Commons/transaction/delete/2
        if (transactionInstance == null) {
            notFound()
            return
        }
        transactionInstance.recStatus="Deleted"
        transactionInstance.save flush:true
    
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Transaction.label', default: 'Transaction'), transactionInstance.id])
                redirect action:"index", method:"GET"
            }
             '*'{ 
                respond transactionInstance //, [status: NO_CONTENT] 
            }
        }
    }
    
    @Transactional 
    def undelete(Transaction transactionInstance) { 
        // example: http://localhost:9991/Commons/transaction/undelete/2
        if (transactionInstance == null) {
            notFound()
            return
        }
        transactionInstance.recStatus="Active"
        transactionInstance.save flush:true 

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.undeleted.message', args: [message(code: 'Transaction.label', default: 'Transaction'), transactionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ 
              respond transactionInstance //, [status: NO_CONTENT] 
            }
        }
    }    
*/
    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'transactionInstance.label', default: 'Transaction'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
         
    def shortList() {
        // example: <server:port>/Commons/transaction/shortList
        params.max = Math.min(params.max ?: 50, 100) 
        transactionInstance = Transaction.list(params)
        
        if (transactionInstance==null) {
            request.withFormat {
                '*'{ render status: NOT_FOUND }
            }
            return
        }
        def result =[:]
        transactionInstance.each {
           result[it.accRecNo] = [accno:"$it.account.accno", transCode:"$it.transCode", secondaryCode:"$it.secondaryCode", currency:"$it.currencyCode", amount:"$it.amount"]  
        }
        withFormat{       
                html {render result as JSON}
                xml  {render  result as XML}
                '*'  {render result as JSON}
                
        }  
    }    
    
    def customQuery(String query) {
        // Example: // customQuery?query=select code, name, nameInt from Transaction
        //It is not allowed to contain the words: Update, Delete, and Set
//        println "Input query: $query"
        
        def result = [:]
        result.query = "$query" 
        def x = query.toUpperCase()
        if (x.contains('UPDATE') || x.contains('DELETE') || x.contains('SET') || !query.contains("Transaction")) {
//            println "WRONG QUERY"
            response.status = 400 // Bad Request
            withFormat{
                json {render result as JSON}
                xml  {render result as XML}
                '*'  {render result as JSON}
            }
            return
        }
        def transactionInstance
        try {
            transactionInstance =  Transaction.executeQuery(query)
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
            json {render transactionInstance as JSON}
            xml  {render transactionInstance as XML}
            '*'  {render transactionInstance as JSON}
        }
    }        

}
