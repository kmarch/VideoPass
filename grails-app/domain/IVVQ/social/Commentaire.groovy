package IVVQ.social

import IVVQ.DVDs.DVD

class Commentaire {

    String idCritique
    String idDVD
    String idUtilisateur
    String commentaire
    long date
    int note

    DVD dvd

    static belongsTo = [dvd:DVD]

    static constraints = {
        idCritique nullable:false, blank:false
        idDVD nullable:false
        idUtilisateur nullable:false, blank:false
        commentaire nullable:false, blank:false
        date nullable:false, min:new Date().time
        note nullable:false
    }
}
