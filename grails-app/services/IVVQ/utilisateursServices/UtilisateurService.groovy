package IVVQ.utilisateursServices

import IVVQ.social.Commentaire
import IVVQ.social.SousCommentaire
import IVVQ.utilisateurs.Utilisateur
import grails.transaction.Transactional


class UtilisateurService {

    List listeUtilisateurs = []

    void initialiserListeUtilisateurs(Utilisateur u) {
        listeUtilisateurs = Utilisateur.all
    }

//    def getListeUtilisateurs() {
//        listeUtilisateurs
//    }

    //@Transactional
    def ajoutUtilisateur(Utilisateur utilisateur) {
        listeUtilisateurs.add(utilisateur)
        utilisateur.save()

        return utilisateur.pseudo
    }

    //@Transactional
    boolean supprimerUtilisateur(String pseudonyme) {
        boolean estSupprime = false
        for (int i = 0; i < listeUtilisateurs.size() && !estSupprime; i++) {
            if (listeUtilisateurs[i].pseudo == pseudonyme) {
                def utilisateurSupp = (listeUtilisateurs[i])
                utilisateurSupp.delete()
                listeUtilisateurs.remove(i)
                estSupprime = true
            }
        }
        return estSupprime
    }

    def getUtilisateur(String pseudonyme) {
        for (int i = 0; i < listeUtilisateurs.size(); i++) {
            if (listeUtilisateurs[i].pseudo == pseudonyme)
                return listeUtilisateurs[i]
        }
    }

    def ajoutCommentaire(Utilisateur utilisateur, Commentaire aAjouter) {
        utilisateur.addToListeCommentaires(aAjouter)
        utilisateur.save()
    }

    def ajoutSousCommentaire(Utilisateur utilisateur, SousCommentaire aAjouter) {
        utilisateur.addToListeSousCommentaires(aAjouter)
        utilisateur.save()
    }
}
