package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(ShadowAccountController)
@Mock(ShadowAccount)
class ShadowAccountControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/shadowAccount/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.shadowAccountInstanceList.size() == 0
        assert model.shadowAccountInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.shadowAccountInstance != null
    }

    void testSave() {
        controller.save()

        assert model.shadowAccountInstance != null
        assert view == '/shadowAccount/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/shadowAccount/show/1'
        assert controller.flash.message != null
        assert ShadowAccount.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/shadowAccount/list'

        populateValidParams(params)
        def shadowAccount = new ShadowAccount(params)

        assert shadowAccount.save() != null

        params.id = shadowAccount.id

        def model = controller.show()

        assert model.shadowAccountInstance == shadowAccount
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/shadowAccount/list'

        populateValidParams(params)
        def shadowAccount = new ShadowAccount(params)

        assert shadowAccount.save() != null

        params.id = shadowAccount.id

        def model = controller.edit()

        assert model.shadowAccountInstance == shadowAccount
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/shadowAccount/list'

        response.reset()

        populateValidParams(params)
        def shadowAccount = new ShadowAccount(params)

        assert shadowAccount.save() != null

        // test invalid parameters in update
        params.id = shadowAccount.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/shadowAccount/edit"
        assert model.shadowAccountInstance != null

        shadowAccount.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/shadowAccount/show/$shadowAccount.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        shadowAccount.clearErrors()

        populateValidParams(params)
        params.id = shadowAccount.id
        params.version = -1
        controller.update()

        assert view == "/shadowAccount/edit"
        assert model.shadowAccountInstance != null
        assert model.shadowAccountInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/shadowAccount/list'

        response.reset()

        populateValidParams(params)
        def shadowAccount = new ShadowAccount(params)

        assert shadowAccount.save() != null
        assert ShadowAccount.count() == 1

        params.id = shadowAccount.id

        controller.delete()

        assert ShadowAccount.count() == 0
        assert ShadowAccount.get(shadowAccount.id) == null
        assert response.redirectedUrl == '/shadowAccount/list'
    }
}
