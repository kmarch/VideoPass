package IVVQ.DVDs

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import videopass.Genre

@TestFor(DVDController)
@Mock(DVD)
class DVDControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        params["titre"] = 'Titanic'
        params["sortie"] = 100000
        params["duree"] = 240
        params["genre"] = Genre.drame
        params["nbExemplaire"] = 10
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.DVDInstanceList
            model.DVDInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.DVDInstance!= null
    }

    void "Test the save action without any instance"() {
        when:"The save action is executed without any instance"
        controller.save(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def DVD = new DVD()
            DVD.validate()
            controller.save(DVD)

        then:"The create view is rendered again with the correct model"
            model.DVDInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            DVD = new DVD(params)

            controller.save(DVD)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/DVD/show/1'
            controller.flash.message != null
            DVD.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def DVD = new DVD(params)
            controller.show(DVD)

        then:"A model is populated containing the domain instance"
            model.DVDInstance == DVD
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def DVD = new DVD(params)
            controller.edit(DVD)

        then:"A model is populated containing the domain instance"
            model.DVDInstance == DVD
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/DVD/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def DVD = new DVD()
            DVD.validate()
            controller.update(DVD)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.DVDInstance == DVD

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            DVD = new DVD(params).save(flush: true)
            controller.update(DVD)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/DVD/show/$DVD.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/DVD/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def DVD = new DVD(params).save(flush: true)

        then:"It exists"
            DVD.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(DVD)

        then:"The instance is deleted"
            DVD.count() == 0
            response.redirectedUrl == '/DVD/index'
            flash.message != null

    }
}
