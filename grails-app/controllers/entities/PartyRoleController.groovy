package entities



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PartyRoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PartyRole.list(params), model:[partyRoleInstanceCount: PartyRole.count()]
    }

    def show(PartyRole partyRoleInstance) {
        respond partyRoleInstance
    }

    def create() {
        respond new PartyRole(params)
    }

    @Transactional
    def save(PartyRole partyRoleInstance) {
        if (partyRoleInstance == null) {
            notFound()
            return
        }

        if (partyRoleInstance.hasErrors()) {
            respond partyRoleInstance.errors, view:'create'
            return
        }

        partyRoleInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'partyRoleInstance.label', default: 'PartyRole'), partyRoleInstance.id])
                redirect partyRoleInstance
            }
            '*' { respond partyRoleInstance, [status: CREATED] }
        }
    }

    def edit(PartyRole partyRoleInstance) {
        respond partyRoleInstance
    }

    @Transactional
    def update(PartyRole partyRoleInstance) {
        if (partyRoleInstance == null) {
            notFound()
            return
        }

        if (partyRoleInstance.hasErrors()) {
            respond partyRoleInstance.errors, view:'edit'
            return
        }

        partyRoleInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PartyRole.label', default: 'PartyRole'), partyRoleInstance.id])
                redirect partyRoleInstance
            }
            '*'{ respond partyRoleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PartyRole partyRoleInstance) {

        if (partyRoleInstance == null) {
            notFound()
            return
        }

        partyRoleInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PartyRole.label', default: 'PartyRole'), partyRoleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'partyRoleInstance.label', default: 'PartyRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
