package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(StatementFrequencyController)
@Mock(StatementFrequency)
class StatementFrequencyControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/statementFrequency/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.statementFrequencyInstanceList.size() == 0
        assert model.statementFrequencyInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.statementFrequencyInstance != null
    }

    void testSave() {
        controller.save()

        assert model.statementFrequencyInstance != null
        assert view == '/statementFrequency/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/statementFrequency/show/1'
        assert controller.flash.message != null
        assert StatementFrequency.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/statementFrequency/list'

        populateValidParams(params)
        def statementFrequency = new StatementFrequency(params)

        assert statementFrequency.save() != null

        params.id = statementFrequency.id

        def model = controller.show()

        assert model.statementFrequencyInstance == statementFrequency
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/statementFrequency/list'

        populateValidParams(params)
        def statementFrequency = new StatementFrequency(params)

        assert statementFrequency.save() != null

        params.id = statementFrequency.id

        def model = controller.edit()

        assert model.statementFrequencyInstance == statementFrequency
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/statementFrequency/list'

        response.reset()

        populateValidParams(params)
        def statementFrequency = new StatementFrequency(params)

        assert statementFrequency.save() != null

        // test invalid parameters in update
        params.id = statementFrequency.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/statementFrequency/edit"
        assert model.statementFrequencyInstance != null

        statementFrequency.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/statementFrequency/show/$statementFrequency.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        statementFrequency.clearErrors()

        populateValidParams(params)
        params.id = statementFrequency.id
        params.version = -1
        controller.update()

        assert view == "/statementFrequency/edit"
        assert model.statementFrequencyInstance != null
        assert model.statementFrequencyInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/statementFrequency/list'

        response.reset()

        populateValidParams(params)
        def statementFrequency = new StatementFrequency(params)

        assert statementFrequency.save() != null
        assert StatementFrequency.count() == 1

        params.id = statementFrequency.id

        controller.delete()

        assert StatementFrequency.count() == 0
        assert StatementFrequency.get(statementFrequency.id) == null
        assert response.redirectedUrl == '/statementFrequency/list'
    }
}
