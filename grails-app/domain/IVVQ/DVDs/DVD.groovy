package IVVQ.DVDs

import IVVQ.social.Commentaire
import videopass.Genre

class DVD {

    String titre
    long sortie
    int duree
    Genre genre
    int nbExemplaire

    static hasMany = [commentaire: Commentaire]

    static constraints = {
        titre nullable:false, blank:false
        sortie nullable:false, max:new Date().time + 86400000
        duree nullable:false, blank:false
        genre nullable:false, blank:false
        nbExemplaire nullable:false



    }
}
