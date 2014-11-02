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

    void "Test des contraintes sur les attributs avec des Utilisateur  non valides"() {
        given:"Un utilisateur invalide"
        utilisateur.isAdmin = isAdminUtil
        utilisateur.pseudo = pseudoUtil
        utilisateur.mdp = mdpUtil
        utilisateur.dateNaissance = dateNaissanceUtil
        when:"On déclenche la validation de l'Utilisateur"
        def estValide = utilisateur.validate()
        then:"L'Utilisateur doit être invalide"
        !estValide

        where:
        isAdminUtil | pseudoUtil | mdpUtil | dateNaissanceUtil
        false       | null       | null    | new Date().time + 86400000
        false       | null       | null    | new Date().time + 86400000
        false       | "Methos"   | null    | new Date().time + 86400000
        false       | "Methos"   | "azerty"| new Date().time + 86400000
        false       | ""         | ""      | new Date().time + 86400000
        false       | ""         | ""      | new Date().time + 86400000
        false       | "Methos"   | ""      | new Date().time + 86400000
    }

    void "Test des contraintes sur les attributs des Utilisateur valides"() {
        given:"Un utilisateur valide"
        utilisateur.isAdmin = false
        utilisateur.pseudo = "Methos"
        utilisateur.mdp = "azerty"
        utilisateur.dateNaissance = new Date().time - 86400000
        when:"On déclenche la validation de l'Utilisateur"
        def estValide = utilisateur.validate()
        then:"l'Utilisateur doit être valide"
        estValide
    }
}
