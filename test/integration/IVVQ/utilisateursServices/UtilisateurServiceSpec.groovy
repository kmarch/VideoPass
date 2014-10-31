package IVVQ.utilisateursServices

import IVVQ.utilisateurs.Utilisateur
import spock.lang.Specification

//import spock.lang.*

/**
 *
 */
class UtilisateurServiceSpec extends Specification {

    UtilisateurService service
    Utilisateur utilisateur1
    Utilisateur utilisateur2

    def setup() {
        service = new UtilisateurService()

        utilisateur1 = new Utilisateur()
        utilisateur1.pseudo = "Methos"
        utilisateur1.mdp = "azerty"

        utilisateur2 = new Utilisateur()
        utilisateur2.pseudo = "Sohtem"
        utilisateur2.mdp = "ytreza"
    }

    def cleanup() {
        Utilisateur.all.each {it -> it.delete()}
    }

    void "test d'ajout d'un utilisateur"() {
        given: "un utilisateur"

        when: "on ajoute l'utilisateur"
        def res = service.ajoutUtilisateur(utilisateur1)

        then: "l'utilisateur est inséré dans la base de données"
        Utilisateur recupUtil1 = Utilisateur.find(utilisateur1)
        recupUtil1 != null

        and: "l'utilisateur retourné est bien l'utilisateur ajouté"
        res.pseudo == utilisateur1.pseudo
    }

    void "test de suppression d'un utilisateur existant"() {
        given: "un utilisateur dans la base de données"
        service.ajoutUtilisateur(utilisateur1)

        when: "on supprime l'utilisateur"
        def res = service.supprimerUtilisateur(utilisateur1.pseudo)

        then: "l'utilisateur n'est plus dans la base de données"
        Utilisateur recupUtil1 = Utilisateur.find(utilisateur1)
        recupUtil1 == null

        and: "l'utilisateur est bien supprimé"
        res == true
    }

    void "test de suppression d'un utilisateur inexistant"() {
        given: "une base de données non vide"
        service.ajoutUtilisateur(utilisateur1)
        def listeUtilisateurs = Utilisateur.all

        when: "on supprime un utilisateur inexistant dans la base"
        def res = service.supprimerUtilisateur(utilisateur2.pseudo)

        then: "la base de données est inchangée"
        def listeApresSupp = Utilisateur.all
        listeApresSupp.size() == listeUtilisateurs.size()
        listeApresSupp.contains(utilisateur1)

        and: "aucun utilisateur n'est supprimé"
        res == false
    }

    void "test de récupération d'un utilisateur"() {
        given: "un utilisateur dans la base de données"
        service.ajoutUtilisateur(utilisateur1)

        when: "on récupère l'utilisateur"
        def res = service.getUtilisateur(utilisateur1.pseudo)

        then: "l'utilisateur récupéré est bien celui demandé"
        res.pseudo == utilisateur1.pseudo
    }
}
