package IVVQ.social

import IVVQ.utilisateurs.Utilisateur

class Like {

    boolean isLike
    boolean isSet = true

    static belongsTo = [utilisateur: Utilisateur, commentaire:Commentaire]

    static constraints = {
        utilisateur nullable: false
        commentaire nullable: false
    }

}
