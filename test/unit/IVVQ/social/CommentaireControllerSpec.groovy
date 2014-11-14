package IVVQ.social

import IVVQ.DVDs.DVD
import IVVQ.utilisateurs.Utilisateur
import grails.test.mixin.*
import spock.lang.*

@TestFor(CommentaireController)
@Mock(Commentaire)
class CommentaireControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        Utilisateur utilisateur = Mock(Utilisateur)
        DVD dvd = Mock(DVD)
        params["commentaire"] = 'Bon film'
        params["dvd"] = dvd
        params["utilisateur"] = utilisateur
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.commentaireInstanceList
            model.commentaireInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.commentaireInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            def commentaire = new Commentaire()
            commentaire.validate()
            controller.save(commentaire)

        then:"The create view is rendered again with the correct model"
            model.commentaireInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            commentaire = new Commentaire(params)

            controller.save(commentaire)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/commentaire/show/1'
            controller.flash.message != null
            Commentaire.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def commentaire = new Commentaire(params)
            controller.show(commentaire)

        then:"A model is populated containing the domain instance"
            model.commentaireInstance == commentaire
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def commentaire = new Commentaire(params)
            controller.edit(commentaire)

        then:"A model is populated containing the domain instance"
            model.commentaireInstance == commentaire
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/commentaire/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def commentaire = new Commentaire()
            commentaire.validate()
            controller.update(commentaire)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.commentaireInstance == commentaire

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            commentaire = new Commentaire(params).save(flush: true)
            controller.update(commentaire)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/commentaire/show/$commentaire.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/commentaire/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def commentaire = new Commentaire(params).save(flush: true)

        then:"It exists"
            Commentaire.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(commentaire)

        then:"The instance is deleted"
            Commentaire.count() == 0
            response.redirectedUrl == '/commentaire/index'
            flash.message != null
    }
}
