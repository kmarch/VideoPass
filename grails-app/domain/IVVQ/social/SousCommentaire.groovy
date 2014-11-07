package IVVQ.social

import IVVQ.utilisateurs.Utilisateur

class SousCommentaire {

    long dateC
    String texteCommentaire

    static belongsTo =[commentaire:Commentaire, utilisateur:Utilisateur]

    static constraints = {
        commentaire nullable:true
        dateC max: new Date().time
        texteCommentaire nullable:false, blank:false
    }
}
