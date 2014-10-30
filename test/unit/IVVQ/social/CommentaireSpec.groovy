package IVVQ.social

import IVVQ.DVDs.DVD
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Commentaire)
class CommentaireSpec extends Specification {

    Commentaire commentaire
    @Shared DVD dvd

    def setup() {
        commentaire = new Commentaire()
        dvd= Mock(DVD)

    }

    def cleanup() {
    }

    void "test des contraintes sur commentaire valide"() {

        given: "un commentaire valide"

        commentaire.commentaire = commentaireCom
        commentaire.note = noteCom
        commentaire.date = dateCom
        commentaire.dvd = dvd

        when: "on déclenche la validation de l'option"
        def res = commentaire.validate()

        then: "le commentaire n'a pas d'erreur de validation"
        res == true
        !commentaire.hasErrors()

        where:
         commentaireCom  | dateCom                    | noteCom
         "Trés bon film" | new Date().time + 86400000 | 18
         "Bon film"      | new Date().time + 86400000 | 12
    }

    void "test des contraintes sur commentaire invalide"() {

        given: "un commentaire valide"

        commentaire.commentaire = commentaireCom
        commentaire.note = noteCom
        commentaire.date = dateCom
        commentaire.dvd = dvd

        when: "on déclenche la validation de l'option"
        def res = commentaire.validate()

        then: "le commentaire n'a pas d'erreur de validation"
        res == false
        commentaire.hasErrors()

        where:
         commentaireCom  | dateCom                    | noteCom
         null | new Date().time + 86400000 | 18
         null      | new Date().time + 86400000 | 14
    }

}
