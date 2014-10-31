package IVVQ.utilisateurs

import IVVQ.social.Commentaire
import spock.lang.*

/**
 *
 */
class UtilisateurIntegrationSpec extends Specification  {

    Utilisateur utilisateur
    Utilisateur jumeau
    def setup() {
        utilisateur = new Utilisateur()
        utilisateur.isAdmin = false
        utilisateur.pseudo = "Methos"
        utilisateur.mdp = "azerty"
        utilisateur.dateNaissance = new Date().time - 86400000
        utilisateur.save(failOnError:true)
    }

    def cleanup() {
    }

    void "Test ajout de deux utilisateurs ayant le même pseudo"() {
        given:"Te même pseudo"
        jumeau = new Utilisateur()
        jumeau.isAdmin = false
        jumeau.pseudo = "Methos"
        jumeau.mdp = "azerty"
        jumeau.dateNaissance = new Date().time - 86400000
        when:"Ajout du même pseudo"
        def estBon = jumeau.save()
        then:"Ca plante"
        !estBon
    }
}
