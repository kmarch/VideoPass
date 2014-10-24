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
        commentaire.idCritique = idCritiqueCom
        commentaire.idDVD = idDVDCom
        commentaire.idUtilisateur = idUtilisateurCom
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
        idCritiqueCom | idDVDCom | idUtilisateurCom | commentaireCom  | dateCom                    | noteCom
        "idC1"        | "dvd1"   | "toto"           | "Trés bon film" | new Date().time + 86400000 | 18
        "idC2"        | "dvd1"   | "toti"           | "Bon film"      | new Date().time + 86400000 | 12
    }

    void "test des contraintes sur commentaire invalide"() {

        given: "un commentaire valide"
        commentaire.idCritique = idCritiqueCom
        commentaire.idDVD = idDVDCom
        commentaire.idUtilisateur = idUtilisateurCom
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
        idCritiqueCom | idDVDCom | idUtilisateurCom | commentaireCom  | dateCom                    | noteCom
        "idC1"        | null     | "toto"           | "Trés bon film" | new Date().time + 86400000 | 18
        "idC2"        | null     | "toti"           | "Bon film"      | new Date().time + 86400000 | 14
    }

}
