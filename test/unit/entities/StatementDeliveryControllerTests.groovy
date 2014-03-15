package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(StatementDeliveryController)
@Mock(StatementDelivery)
class StatementDeliveryControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/statementDelivery/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.statementDeliveryInstanceList.size() == 0
        assert model.statementDeliveryInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.statementDeliveryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.statementDeliveryInstance != null
        assert view == '/statementDelivery/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/statementDelivery/show/1'
        assert controller.flash.message != null
        assert StatementDelivery.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/statementDelivery/list'

        populateValidParams(params)
        def statementDelivery = new StatementDelivery(params)

        assert statementDelivery.save() != null

        params.id = statementDelivery.id

        def model = controller.show()

        assert model.statementDeliveryInstance == statementDelivery
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/statementDelivery/list'

        populateValidParams(params)
        def statementDelivery = new StatementDelivery(params)

        assert statementDelivery.save() != null

        params.id = statementDelivery.id

        def model = controller.edit()

        assert model.statementDeliveryInstance == statementDelivery
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/statementDelivery/list'

        response.reset()

        populateValidParams(params)
        def statementDelivery = new StatementDelivery(params)

        assert statementDelivery.save() != null

        // test invalid parameters in update
        params.id = statementDelivery.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/statementDelivery/edit"
        assert model.statementDeliveryInstance != null

        statementDelivery.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/statementDelivery/show/$statementDelivery.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        statementDelivery.clearErrors()

        populateValidParams(params)
        params.id = statementDelivery.id
        params.version = -1
        controller.update()

        assert view == "/statementDelivery/edit"
        assert model.statementDeliveryInstance != null
        assert model.statementDeliveryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/statementDelivery/list'

        response.reset()

        populateValidParams(params)
        def statementDelivery = new StatementDelivery(params)

        assert statementDelivery.save() != null
        assert StatementDelivery.count() == 1

        params.id = statementDelivery.id

        controller.delete()

        assert StatementDelivery.count() == 0
        assert StatementDelivery.get(statementDelivery.id) == null
        assert response.redirectedUrl == '/statementDelivery/list'
    }
}
