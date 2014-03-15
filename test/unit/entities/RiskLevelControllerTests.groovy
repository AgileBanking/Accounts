package entities



import org.junit.*
import grails.test.mixin.*

@TestFor(RiskLevelController)
@Mock(RiskLevel)
class RiskLevelControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/riskLevel/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.riskLevelInstanceList.size() == 0
        assert model.riskLevelInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.riskLevelInstance != null
    }

    void testSave() {
        controller.save()

        assert model.riskLevelInstance != null
        assert view == '/riskLevel/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/riskLevel/show/1'
        assert controller.flash.message != null
        assert RiskLevel.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/riskLevel/list'

        populateValidParams(params)
        def riskLevel = new RiskLevel(params)

        assert riskLevel.save() != null

        params.id = riskLevel.id

        def model = controller.show()

        assert model.riskLevelInstance == riskLevel
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/riskLevel/list'

        populateValidParams(params)
        def riskLevel = new RiskLevel(params)

        assert riskLevel.save() != null

        params.id = riskLevel.id

        def model = controller.edit()

        assert model.riskLevelInstance == riskLevel
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/riskLevel/list'

        response.reset()

        populateValidParams(params)
        def riskLevel = new RiskLevel(params)

        assert riskLevel.save() != null

        // test invalid parameters in update
        params.id = riskLevel.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/riskLevel/edit"
        assert model.riskLevelInstance != null

        riskLevel.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/riskLevel/show/$riskLevel.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        riskLevel.clearErrors()

        populateValidParams(params)
        params.id = riskLevel.id
        params.version = -1
        controller.update()

        assert view == "/riskLevel/edit"
        assert model.riskLevelInstance != null
        assert model.riskLevelInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/riskLevel/list'

        response.reset()

        populateValidParams(params)
        def riskLevel = new RiskLevel(params)

        assert riskLevel.save() != null
        assert RiskLevel.count() == 1

        params.id = riskLevel.id

        controller.delete()

        assert RiskLevel.count() == 0
        assert RiskLevel.get(riskLevel.id) == null
        assert response.redirectedUrl == '/riskLevel/list'
    }
}
