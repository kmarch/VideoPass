package IVVQ.location

class Location {

    String idLocation
    String idUtilisateur
    String idFilm
    static constraints = {
        idLocation nullable:false, blank:false, unique:true
        idUtilisateur nullable:false, blank:false
        idFilm nullable:false, blank:false
    }
}
