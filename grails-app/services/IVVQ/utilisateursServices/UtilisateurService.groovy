package IVVQ.utilisateursServices

import IVVQ.social.Commentaire
import IVVQ.social.SousCommentaire
import IVVQ.utilisateurs.Utilisateur
import org.springframework.transaction.annotation.Transactional

class UtilisateurService {

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

    @Transactional
    def ajoutCommentaire(Utilisateur utilisateur, Commentaire aAjouter) {
        utilisateur.addToListeCommentaires(aAjouter)
        utilisateur.save()
    }

    @Transactional
    def ajoutSousCommentaire(Utilisateur utilisateur, SousCommentaire aAjouter) {
        utilisateur.addToListeSousCommentaires(aAjouter)
        utilisateur.save()
    }
}
