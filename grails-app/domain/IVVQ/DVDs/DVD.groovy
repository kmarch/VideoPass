package IVVQ.DVDs

import IVVQ.social.Commentaire

class DVD {

    String titre
    long sortie
    int duree
    String idDVD
    Enum genre
    int nbExemplaire

    static hasMany = [commentaire: Commentaire]

    static constraints = {
        titre nullable:false, blank:false
        sortie nullable:false, min:new Date().time
        duree nullable:false, blank:false
        idDVD nullable:false, blank:false, unique:true
        genre nullable:false
        nbExemplaire nullable:false



    }
}
