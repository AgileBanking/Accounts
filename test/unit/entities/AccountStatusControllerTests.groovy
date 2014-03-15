package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(AccountStatusController)
@Mock(AccountStatus)
class AccountStatusControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/accountStatus/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.accountStatusInstanceList.size() == 0
        assert model.accountStatusInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.accountStatusInstance != null
    }

    void testSave() {
        controller.save()

        assert model.accountStatusInstance != null
        assert view == '/accountStatus/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/accountStatus/show/1'
        assert controller.flash.message != null
        assert AccountStatus.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/accountStatus/list'

        populateValidParams(params)
        def accountStatus = new AccountStatus(params)

        assert accountStatus.save() != null

        params.id = accountStatus.id

        def model = controller.show()

        assert model.accountStatusInstance == accountStatus
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/accountStatus/list'

        populateValidParams(params)
        def accountStatus = new AccountStatus(params)

        assert accountStatus.save() != null

        params.id = accountStatus.id

        def model = controller.edit()

        assert model.accountStatusInstance == accountStatus
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/accountStatus/list'

        response.reset()

        populateValidParams(params)
        def accountStatus = new AccountStatus(params)

        assert accountStatus.save() != null

        // test invalid parameters in update
        params.id = accountStatus.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/accountStatus/edit"
        assert model.accountStatusInstance != null

        accountStatus.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/accountStatus/show/$accountStatus.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        accountStatus.clearErrors()

        populateValidParams(params)
        params.id = accountStatus.id
        params.version = -1
        controller.update()

        assert view == "/accountStatus/edit"
        assert model.accountStatusInstance != null
        assert model.accountStatusInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/accountStatus/list'

        response.reset()

        populateValidParams(params)
        def accountStatus = new AccountStatus(params)

        assert accountStatus.save() != null
        assert AccountStatus.count() == 1

        params.id = accountStatus.id

        controller.delete()

        assert AccountStatus.count() == 0
        assert AccountStatus.get(accountStatus.id) == null
        assert response.redirectedUrl == '/accountStatus/list'
    }
}
