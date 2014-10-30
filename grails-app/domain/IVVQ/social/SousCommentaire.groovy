package IVVQ.social

import IVVQ.utilisateurs.Utilisateur

class SousCommentaire {

    long dateC
    String texteCommentaire

    static belongsTo =[commentaire:Commentaire, utilisateur:Utilisateur]
    static constraints = {
        dateC max: new Date().time
        texteCommentaire nullable:false, blank:false
        commentaire nullable:false
        utilisateur nullable:false
    }
}
