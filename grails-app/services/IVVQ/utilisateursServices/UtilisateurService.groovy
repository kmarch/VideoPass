package IVVQ.utilisateursServices

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
                def utilisateurSupp = Utilisateur.find(listeUtilisateurs[i])
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

}
