package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(AccOwnershipController)
@Mock(AccOwnership)
class AccOwnershipControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/accOwnership/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.accOwnershipInstanceList.size() == 0
        assert model.accOwnershipInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.accOwnershipInstance != null
    }

    void testSave() {
        controller.save()

        assert model.accOwnershipInstance != null
        assert view == '/accOwnership/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/accOwnership/show/1'
        assert controller.flash.message != null
        assert AccOwnership.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwnership/list'

        populateValidParams(params)
        def accOwnership = new AccOwnership(params)

        assert accOwnership.save() != null

        params.id = accOwnership.id

        def model = controller.show()

        assert model.accOwnershipInstance == accOwnership
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwnership/list'

        populateValidParams(params)
        def accOwnership = new AccOwnership(params)

        assert accOwnership.save() != null

        params.id = accOwnership.id

        def model = controller.edit()

        assert model.accOwnershipInstance == accOwnership
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwnership/list'

        response.reset()

        populateValidParams(params)
        def accOwnership = new AccOwnership(params)

        assert accOwnership.save() != null

        // test invalid parameters in update
        params.id = accOwnership.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/accOwnership/edit"
        assert model.accOwnershipInstance != null

        accOwnership.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/accOwnership/show/$accOwnership.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        accOwnership.clearErrors()

        populateValidParams(params)
        params.id = accOwnership.id
        params.version = -1
        controller.update()

        assert view == "/accOwnership/edit"
        assert model.accOwnershipInstance != null
        assert model.accOwnershipInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/accOwnership/list'

        response.reset()

        populateValidParams(params)
        def accOwnership = new AccOwnership(params)

        assert accOwnership.save() != null
        assert AccOwnership.count() == 1

        params.id = accOwnership.id

        controller.delete()

        assert AccOwnership.count() == 0
        assert AccOwnership.get(accOwnership.id) == null
        assert response.redirectedUrl == '/accOwnership/list'
    }
}
