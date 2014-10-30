package IVVQ.location

class Location {

    String idUtilisateur
    String idFilm
    static constraints = {
        idUtilisateur nullable:false, blank:false
        idFilm nullable:false, blank:false
    }
}
