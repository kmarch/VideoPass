package IVVQ.social


import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.CREATED
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CommentaireController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Commentaire.list(params), model: [commentaireInstanceCount: Commentaire.count()]
    }

    def show(Commentaire commentaireInstance) {
        respond commentaireInstance
    }

    def create() {
        respond new Commentaire(params)
    }

    @Transactional
    def save(Commentaire commentaireInstance) {

        if (commentaireInstance.hasErrors()) {
            respond commentaireInstance.errors, view: 'create'
            return
        }

        commentaireInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'commentaireInstance.label', default: 'Commentaire'), commentaireInstance.id])
                redirect commentaireInstance
            }
            '*' { respond commentaireInstance, [status: CREATED] }
        }
    }

    def edit(Commentaire commentaireInstance) {
        respond commentaireInstance
    }

    @Transactional
    def update(Commentaire commentaireInstance) {
        if (commentaireInstance == null) {
            notFound()
            return
        }

        if (commentaireInstance.hasErrors()) {
            respond commentaireInstance.errors, view: 'edit'
            return
        }

        commentaireInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Commentaire.label', default: 'Commentaire'), commentaireInstance.id])
                redirect commentaireInstance
            }
            '*' { respond commentaireInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Commentaire commentaireInstance) {

        if (commentaireInstance == null) {
            notFound()
            return
        }

        commentaireInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Commentaire.label', default: 'Commentaire'), commentaireInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'commentaireInstance.label', default: 'Commentaire'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
