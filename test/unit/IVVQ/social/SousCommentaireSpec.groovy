package IVVQ.social

import IVVQ.utilisateurs.Utilisateur
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SousCommentaire)
class SousCommentaireSpec extends Specification {

    SousCommentaire sousCommentaire
    def setup() {
        sousCommentaire = new SousCommentaire()
    }

    def cleanup() {
    }

    void "test de contrainte de SousCommentaires invalides"() {
        given:"Un sousCommentaire avec des attributs invalides"
        sousCommentaire.dateC = dateC
        sousCommentaire.texteCommentaire = texteCommentaire
        sousCommentaire.utilisateur = utilisateur
        sousCommentaire.commentaire = commentaire
        when:"Test de validité"
        def estValide = sousCommentaire.validate()
        then:"ils sont tous invalides"
        !estValide
        where:
        dateC                       | texteCommentaire | utilisateur         | commentaire
        new Date().time+ 86400000   | null             | null                | null
        new Date().time             | ""               | null                | null
        new Date().time             | "un com"         | null                | null
    }

    void "test de contrainte de SousCommentaires valides"() {
        given:"Un sousCommentaire avec des attributs valides"
        sousCommentaire.dateC = new Date().time
        sousCommentaire.texteCommentaire = "Un com"
        sousCommentaire.utilisateur = Mock(Utilisateur)
        sousCommentaire.commentaire = Mock(Commentaire)
        when:"Test de validité"
        def estValide = sousCommentaire.validate()
        then:"il est valides"
        estValide
    }
}
