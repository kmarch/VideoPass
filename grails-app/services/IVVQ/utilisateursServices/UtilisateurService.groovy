package IVVQ.utilisateursServices

import IVVQ.utilisateurs.Utilisateur
import grails.transaction.Transactional


class UtilisateurService {

    static transactional = true

    //@Transactional
    def ajoutUtilisateur(Utilisateur utilisateur) {
        utilisateur.save()

        return utilisateur
    }

    //@Transactional
    boolean supprimerUtilisateur(String pseudonyme) {
        boolean estSupprime = false
        def utilisateurSupp = Utilisateur.findByPseudo(pseudonyme)
        if (utilisateurSupp != null) {
            utilisateurSupp?.delete()
            estSupprime = true
        }

        return estSupprime
    }

    def getUtilisateur(String pseudonyme) {
        Utilisateur.findByPseudo(pseudonyme)
    }

}
