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
        utilisateur.idUtil = "007"
        utilisateur.isAdmin = false
        utilisateur.pseudo = "Methos"
        utilisateur.mdp = "azerty"
        utilisateur.dateNaissance = new Date().time - 86400000
        utilisateur.save(failOnError:true)
    }

    def cleanup() {
    }

    void "test ajout de deux utilisateurs ayant le même id"() {
        given:"le même utilisateur"
        jumeau = new Utilisateur()
        jumeau.idUtil = "007"
        jumeau.isAdmin = false
        jumeau.pseudo = "Lol"
        jumeau.mdp = "azerty"
        jumeau.dateNaissance = new Date().time - 86400000
        when:"ajout de lui même"
        def estBon = jumeau.save()
        then:"ça plante"
        !estBon
    }

    void "test ajout de deux utilisateurs ayant le même pseudo"() {
        given:"le même pseudo"
        jumeau = new Utilisateur()
        jumeau.idUtil = "008"
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
