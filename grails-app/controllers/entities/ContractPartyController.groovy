package entities

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ContractPartyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ContractParty.list(params), model:[contractPartyInstanceCount: ContractParty.count()]
    }

    def show(ContractParty contractPartyInstance) {
        respond contractPartyInstance
    }

    def create() {
        respond new ContractParty(params)
    }

    @Transactional
    def save(ContractParty contractPartyInstance) {
        if (contractPartyInstance == null) {
            notFound()
            return
        }

        if (contractPartyInstance.hasErrors()) {
            respond contractPartyInstance.errors, view:'create'
            return
        }

        contractPartyInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.created.message', args: [message(code: 'contractPartyInstance.label', default: 'ContractParty'), contractPartyInstance.id])
                redirect contractPartyInstance
            }
            '*' { respond contractPartyInstance, [status: CREATED] }
        }
    }

    def edit(ContractParty contractPartyInstance) {
        respond contractPartyInstance
    }

    @Transactional
    def update(ContractParty contractPartyInstance) {
        if (contractPartyInstance == null) {
            notFound()
            return
        }

        if (contractPartyInstance.hasErrors()) {
            respond contractPartyInstance.errors, view:'edit'
            return
        }

        contractPartyInstance.save flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ContractParty.label', default: 'ContractParty'), contractPartyInstance.id])
                redirect contractPartyInstance
            }
            '*'{ respond contractPartyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(ContractParty contractPartyInstance) {

        if (contractPartyInstance == null) {
            notFound()
            return
        }

        contractPartyInstance.delete flush:true

        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ContractParty.label', default: 'ContractParty'), contractPartyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm{
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contractPartyInstance.label', default: 'ContractParty'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
