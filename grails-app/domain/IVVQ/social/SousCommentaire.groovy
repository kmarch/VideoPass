package IVVQ.social

import IVVQ.utilisateurs.Utilisateur

class SousCommentaire {

    long dateC
    String texteCommentaire

    static belongsTo =[utilisateur:Utilisateur, commentaire:Commentaire]

    static constraints = {
        dateC max: new Date().time
        texteCommentaire nullable:false, blank:false
    }
}
