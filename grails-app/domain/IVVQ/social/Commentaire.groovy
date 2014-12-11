package IVVQ.social

import IVVQ.DVDs.DVD
import IVVQ.utilisateurs.Utilisateur

class Commentaire {


    String commentaire
    long dateCommentaire
    int note

    DVD dvd

    static belongsTo = [dvd:DVD , utilisateur:Utilisateur]
    static hasMany = [listeSousCommentaire:SousCommentaire]
    static constraints = {

        commentaire nullable:false, blank:false
        dateCommentaire nullable:false
        note nullable:false
    }
}
