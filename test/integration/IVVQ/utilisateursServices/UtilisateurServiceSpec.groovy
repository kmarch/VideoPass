package IVVQ.utilisateursServices

import IVVQ.utilisateurs.Utilisateur
import spock.lang.*

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

    void "test d'initialisation de la liste"() {
        given: "une base de données avec deux utilisateurs"
        utilisateur1.save(flush:true, failOnError:true)
        utilisateur2.save(flush:true, failOnError:true)

        when: "on initialise la liste"
        service.initialiserListeUtilisateurs()

        then: "la liste contient les deux utilisateurs"
        service.listeUtilisateurs.size() == 2
        Utilisateur recupUtil1 = Utilisateur.find(utilisateur1)
        Utilisateur recupUtil2 = Utilisateur.find(utilisateur2)
        service.listeUtilisateurs.contains(recupUtil1)
        service.listeUtilisateurs.contains(recupUtil2)
    }

    void "test d'ajout d'un utilisateur"() {
        given: "un utilisateur"

        when: "on ajoute l'utilisateur"
        def res = service.ajoutUtilisateur(utilisateur1)

        then: "l'utilisateur est inséré dans la base de données"
        Utilisateur recupUtil1 = Utilisateur.find(utilisateur1)
        recupUtil1 != null

        and: "l'utilisateur est inséré dans la liste des utilisateurs"
        service.listeUtilisateurs.contains(utilisateur1)

        and: "l'identifiant retourné est bien celui de l'utilisateur ajouté"
        res == utilisateur1.pseudo
    }

    void "test de suppression d'un utilisateur"() {
        given: "un utilisateur dans la base de données et dans la liste"
        service.ajoutUtilisateur(utilisateur1)

        when: "on supprime l'utilisateur"
        def res = service.supprimerUtilisateur(utilisateur1.pseudo)

        then: "l'utilisateur n'est plus dans la base de données"
        Utilisateur recupUtil1 = Utilisateur.find(utilisateur1)
        recupUtil1 == null

        and: "l'utilisateur n'est plus dans la liste d'utilisateurs"
        !service.listeUtilisateurs.contains(utilisateur1)

        and: "l'utilisateur est bien supprimé"
        res == true
    }

    void "test de récupération d'un utilisateur"() {
        given: "un utilisateur dans la liste des utilisateurs"
        service.listeUtilisateurs.add(utilisateur1)

        when: "on récupère l'utilisateur"
        def res = service.getUtilisateur(utilisateur1.pseudo)

        then: "l'utilisateur récupéré est bien celui demandé"
        res.pseudo == utilisateur1.pseudo
    }
}
