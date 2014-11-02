package IVVQ.utilisateursServices

import IVVQ.DVDs.DVD
import IVVQ.social.Commentaire
import IVVQ.social.SousCommentaire
import IVVQ.utilisateurs.Utilisateur
import spock.lang.Specification

import videopass.Genre

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

    void "Test Ajout Commentaire et SousCommentaire"() {
        given: "Un utilisateur valide et des Commentaire et SousCommentaire et un DVD"
        Utilisateur utilisateur = new Utilisateur()
        DVD dvd = new DVD()
        Commentaire commentaire1 = new Commentaire()
        SousCommentaire sousCommentaire = new SousCommentaire()
        utilisateur.isAdmin = false
        utilisateur.pseudo = "Madara"
        utilisateur.mdp = "azerty"
        utilisateur.dateNaissance = new Date().time - 86400000
        dvd.duree = 120
        dvd.genre = Genre.action
        dvd.nbExemplaire = 12
        dvd.titre = "La mort au trousse"
        dvd.sortie = new Date().time - 86400000
        commentaire1.utilisateur = utilisateur
        commentaire1.commentaire = "Bien"
        commentaire1.date = new Date().time + 86400000
        commentaire1.dvd = dvd
        sousCommentaire.commentaire = commentaire1
        sousCommentaire.dateC = new Date().time - 86400000
        sousCommentaire.texteCommentaire = "J'aime aussi"
        sousCommentaire.utilisateur = utilisateur
        dvd.save(failOnError: true)

        when: "Ajoute les Commentaires et SousCommentaire"
        utilisateur.addToListeSousCommentaires(sousCommentaire)
        utilisateur.addToListeCommentaires(commentaire1)
        utilisateur.save()
        service.ajoutUtilisateur(utilisateur)

        then: "On a 1 Commentaires et 1 SousCommentaire"
        utilisateur.listeSousCommentaires.size() == 1
        utilisateur.listeCommentaires.size() == 1
    }

    void "Test Suppression en cascade d'un utilisateur"() {
        given: "Un utilisateur valide et des Commentaire et SousCommentaire et un DVD"
        Utilisateur utilisateur = new Utilisateur()
        DVD dvd = new DVD()
        Commentaire commentaire1 = new Commentaire()
        SousCommentaire sousCommentaire = new SousCommentaire()
        utilisateur.isAdmin = false
        utilisateur.pseudo = "Methos"
        utilisateur.mdp = "azerty"
        utilisateur.dateNaissance = new Date().time - 86400000
        dvd.duree = 120
        dvd.genre = Genre.action
        dvd.nbExemplaire = 12
        dvd.titre = "La mort au trousse"
        dvd.sortie = new Date().time - 86400000
        commentaire1.utilisateur = utilisateur
        commentaire1.commentaire = "Bien"
        commentaire1.date = new Date().time + 86400000
        commentaire1.dvd = dvd
        dvd.save()
        service.ajoutUtilisateur(utilisateur)
        sousCommentaire.commentaire = commentaire1
        sousCommentaire.dateC = new Date().time - 86400000
        sousCommentaire.texteCommentaire = "J'aime aussi"
        sousCommentaire.utilisateur = utilisateur
        utilisateur.addToListeSousCommentaires(sousCommentaire)
        utilisateur.addToListeCommentaires(commentaire1)
        utilisateur.save()

        when: "On supprime l'utilisateur"
        (service.supprimerUtilisateur(utilisateur.pseudo))

        then: "On a aucun Commentaire et SousCommentaire en BD"
        Commentaire.all.size() == 0
        SousCommentaire.all.size() == 0

    }
}
