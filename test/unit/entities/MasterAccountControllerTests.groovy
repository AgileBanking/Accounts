package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(MasterAccountController)
@Mock(MasterAccount)
class MasterAccountControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/masterAccount/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.masterAccountInstanceList.size() == 0
        assert model.masterAccountInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.masterAccountInstance != null
    }

    void testSave() {
        controller.save()

        assert model.masterAccountInstance != null
        assert view == '/masterAccount/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/masterAccount/show/1'
        assert controller.flash.message != null
        assert MasterAccount.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/masterAccount/list'

        populateValidParams(params)
        def masterAccount = new MasterAccount(params)

        assert masterAccount.save() != null

        params.id = masterAccount.id

        def model = controller.show()

        assert model.masterAccountInstance == masterAccount
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/masterAccount/list'

        populateValidParams(params)
        def masterAccount = new MasterAccount(params)

        assert masterAccount.save() != null

        params.id = masterAccount.id

        def model = controller.edit()

        assert model.masterAccountInstance == masterAccount
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/masterAccount/list'

        response.reset()

        populateValidParams(params)
        def masterAccount = new MasterAccount(params)

        assert masterAccount.save() != null

        // test invalid parameters in update
        params.id = masterAccount.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/masterAccount/edit"
        assert model.masterAccountInstance != null

        masterAccount.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/masterAccount/show/$masterAccount.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        masterAccount.clearErrors()

        populateValidParams(params)
        params.id = masterAccount.id
        params.version = -1
        controller.update()

        assert view == "/masterAccount/edit"
        assert model.masterAccountInstance != null
        assert model.masterAccountInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/masterAccount/list'

        response.reset()

        populateValidParams(params)
        def masterAccount = new MasterAccount(params)

        assert masterAccount.save() != null
        assert MasterAccount.count() == 1

        params.id = masterAccount.id

        controller.delete()

        assert MasterAccount.count() == 0
        assert MasterAccount.get(masterAccount.id) == null
        assert response.redirectedUrl == '/masterAccount/list'
    }
}
