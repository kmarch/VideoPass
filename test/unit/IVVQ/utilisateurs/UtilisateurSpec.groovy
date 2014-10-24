package IVVQ.utilisateurs

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Utilisateur)
class UtilisateurSpec extends Specification {

    Utilisateur  utilisateur
    def setup() {
        utilisateur = new Utilisateur()
    }

    def cleanup() {
    }

    void "test des contraintes sur les attributs avec des Utilisateur  non valides"() {
        given:"un utilisateur invalide"
        utilisateur.idUtil = idUtil
        utilisateur.isAdmin = isAdminUtil
        utilisateur.pseudo = pseudoUtil
        utilisateur.mdp = mdpUtil
        utilisateur.dateNaissance = dateNaissanceUtil
        when:"on déclenche la validation de l'Utilisateur"
        def estValide = utilisateur.validate()
        then:"l'Utilisateur doit être invalide"
        !estValide

        where:
        idUtil  | isAdminUtil | pseudoUtil | mdpUtil | dateNaissanceUtil
        null    | false       | null       | null    | new Date().time + 86400000
        "007"   | false       | null       | null    | new Date().time + 86400000
        "007"   | false       | "Methos"   | null    | new Date().time + 86400000
        "007"   | false       | "Methos"   | "azerty"| new Date().time + 86400000
        ""      | false       | ""         | ""      | new Date().time + 86400000
        "007"   | false       | ""         | ""      | new Date().time + 86400000
        "007"   | false       | "Methos"   | ""      | new Date().time + 86400000
    }

    void "test des contraintes sur les attributs des Utilisateur valides"() {
        given:"un utilisateur valide"
        utilisateur.idUtil = "007"
        utilisateur.isAdmin = false
        utilisateur.pseudo = "Methos"
        utilisateur.mdp = "azerty"
        utilisateur.dateNaissance = new Date().time - 86400000
        when:"on déclenche la validation de l'Utilisateur"
        def estValide = utilisateur.validate()
        then:"l'Utilisateur doit être valide"
        estValide
    }
}
