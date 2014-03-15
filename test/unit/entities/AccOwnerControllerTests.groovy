package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(AccOwnerController)
@Mock(AccOwner)
class AccOwnerControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/accOwner/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.accOwnerInstanceList.size() == 0
        assert model.accOwnerInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.accOwnerInstance != null
    }

    void testSave() {
        controller.save()

        assert model.accOwnerInstance != null
        assert view == '/accOwner/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/accOwner/show/1'
        assert controller.flash.message != null
        assert AccOwner.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwner/list'

        populateValidParams(params)
        def accOwner = new AccOwner(params)

        assert accOwner.save() != null

        params.id = accOwner.id

        def model = controller.show()

        assert model.accOwnerInstance == accOwner
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwner/list'

        populateValidParams(params)
        def accOwner = new AccOwner(params)

        assert accOwner.save() != null

        params.id = accOwner.id

        def model = controller.edit()

        assert model.accOwnerInstance == accOwner
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwner/list'

        response.reset()

        populateValidParams(params)
        def accOwner = new AccOwner(params)

        assert accOwner.save() != null

        // test invalid parameters in update
        params.id = accOwner.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/accOwner/edit"
        assert model.accOwnerInstance != null

        accOwner.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/accOwner/show/$accOwner.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        accOwner.clearErrors()

        populateValidParams(params)
        params.id = accOwner.id
        params.version = -1
        controller.update()

        assert view == "/accOwner/edit"
        assert model.accOwnerInstance != null
        assert model.accOwnerInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/accOwner/list'

        response.reset()

        populateValidParams(params)
        def accOwner = new AccOwner(params)

        assert accOwner.save() != null
        assert AccOwner.count() == 1

        params.id = accOwner.id

        controller.delete()

        assert AccOwner.count() == 0
        assert AccOwner.get(accOwner.id) == null
        assert response.redirectedUrl == '/accOwner/list'
    }
}
