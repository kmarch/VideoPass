package IVVQ.utilisateurs

import IVVQ.social.Commentaire
import IVVQ.social.SousCommentaire

class Utilisateur {

    boolean isAdmin
    String pseudo
    String mdp
    long dateNaissance
    static hasMany = [listeCommentaires:Commentaire, listeSousCommentaires:SousCommentaire]

    static constraints = {
        pseudo nullable:false, blank:false, unique:true
        mdp nullable:false, blank:false
        dateNaissance max:new Date().time
    }

}
