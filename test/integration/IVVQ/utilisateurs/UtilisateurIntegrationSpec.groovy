package IVVQ.utilisateurs
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

    void "test ajout de deux utilisateurs ayant le même pseudo"() {
        given:"le même pseudo"
        jumeau = new Utilisateur()
        jumeau.isAdmin = false
        jumeau.pseudo = "Methos"
        jumeau.mdp = "azerty"
        jumeau.dateNaissance = new Date().time - 86400000
        when:"ajout du même pseudo"
        def estBon = jumeau.save()
        then:"ça plante"
        !estBon
    }
}
