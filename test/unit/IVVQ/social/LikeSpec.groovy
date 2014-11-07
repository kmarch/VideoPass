package IVVQ.social

import IVVQ.utilisateurs.Utilisateur
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Like)
class LikeSpec extends Specification {

    Like likeValide
    @Shared
    Utilisateur util
    @Shared
    Commentaire comment

    def setup() {
        util = Mock(Utilisateur)
        comment = Mock(Commentaire)

        likeValide = new Like()
        likeValide.isLike = true
        likeValide.utilisateur = util
        likeValide.commentaire = comment
    }

    void "test d'initialisation du Like"() {
        given: "un like"
        likeValide.isLike = true

        when: "le like est créé"

        then: "le like a une valeur"
        likeValide.isSet
        likeValide.isLike != null

        and: "il est associé à un commentaire et un utilisateur"
        likeValide.utilisateur != null
        likeValide.commentaire != null
    }

    void "test des contraintes sur Like valide"() {
        given: "un like valide"

        when: "on déclenche la validation de l'objet"
        def res = likeValide.validate()

        then: "il n'y a pas d'erreur de validation"
        res == true
        !likeValide.hasErrors()
    }

    @Unroll
    void "test des contraintes sur Like invalide"() {
        given: "un like invalide"
        Like likeInvalide = new Like()
        likeInvalide.isLike = isLikeVal
        likeInvalide.isSet = isSetVal
        likeInvalide.commentaire = commentaireVal
        likeInvalide.utilisateur = utilisateurVal

        when: "on déclenche la validation de l'objet"
        def res = likeInvalide.validate()

        then: "il y a des erreurs de validation"
        !res
        likeInvalide.hasErrors()

        where:
        isLikeVal | isSetVal | commentaireVal | utilisateurVal
        true      | true     | null           | util
        true      | true     | comment        | null
    }
    
}
