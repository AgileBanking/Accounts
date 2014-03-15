package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(AccOwnerCategoryController)
@Mock(AccOwnerCategory)
class AccOwnerCategoryControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/accOwnerCategory/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.accOwnerCategoryInstanceList.size() == 0
        assert model.accOwnerCategoryInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.accOwnerCategoryInstance != null
    }

    void testSave() {
        controller.save()

        assert model.accOwnerCategoryInstance != null
        assert view == '/accOwnerCategory/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/accOwnerCategory/show/1'
        assert controller.flash.message != null
        assert AccOwnerCategory.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwnerCategory/list'

        populateValidParams(params)
        def accOwnerCategory = new AccOwnerCategory(params)

        assert accOwnerCategory.save() != null

        params.id = accOwnerCategory.id

        def model = controller.show()

        assert model.accOwnerCategoryInstance == accOwnerCategory
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwnerCategory/list'

        populateValidParams(params)
        def accOwnerCategory = new AccOwnerCategory(params)

        assert accOwnerCategory.save() != null

        params.id = accOwnerCategory.id

        def model = controller.edit()

        assert model.accOwnerCategoryInstance == accOwnerCategory
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/accOwnerCategory/list'

        response.reset()

        populateValidParams(params)
        def accOwnerCategory = new AccOwnerCategory(params)

        assert accOwnerCategory.save() != null

        // test invalid parameters in update
        params.id = accOwnerCategory.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/accOwnerCategory/edit"
        assert model.accOwnerCategoryInstance != null

        accOwnerCategory.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/accOwnerCategory/show/$accOwnerCategory.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        accOwnerCategory.clearErrors()

        populateValidParams(params)
        params.id = accOwnerCategory.id
        params.version = -1
        controller.update()

        assert view == "/accOwnerCategory/edit"
        assert model.accOwnerCategoryInstance != null
        assert model.accOwnerCategoryInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/accOwnerCategory/list'

        response.reset()

        populateValidParams(params)
        def accOwnerCategory = new AccOwnerCategory(params)

        assert accOwnerCategory.save() != null
        assert AccOwnerCategory.count() == 1

        params.id = accOwnerCategory.id

        controller.delete()

        assert AccOwnerCategory.count() == 0
        assert AccOwnerCategory.get(accOwnerCategory.id) == null
        assert response.redirectedUrl == '/accOwnerCategory/list'
    }
}
