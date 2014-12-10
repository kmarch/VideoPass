package IVVQ.utilisateurs

import spock.lang.Specification

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


    void "Test connexion / deconnexion"(){
        given :"un utilisateur"
        UtilisateurController controller = new UtilisateurController();
        controller.params.pseudo ="mathieu"
        controller.params.mdp ="mathieu"

        when: "Connexion / deconnexion"
        def query = Utilisateur.where {
            (pseudo == "mathieu" && mdp=="mathieu")
        }
        def result = query.list()
        controller.session["login"] = result.pseudo[0]
        controller.deconnexion()

        then :"la session est vide"
        controller.session["login"] == null

    }
}
