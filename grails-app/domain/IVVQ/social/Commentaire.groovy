package IVVQ.social

import IVVQ.DVDs.DVD
import IVVQ.utilisateurs.Utilisateur

class Commentaire {


    String commentaire
    long date
    int note

    DVD dvd

    static belongsTo = [dvd:DVD]

    static constraints = {

        commentaire nullable:false, blank:false
        date nullable:false, min:new Date().time
        note nullable:false
    }
}
