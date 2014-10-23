package IVVQ.utilisateurs

class Utilisateur {

    String id
    boolean isAdmin
    String pseudo
    String mdp
    long dateNaissance

    static constraints = {
        id nullable:false, blank:false,  unique:true
        pseudo nullable:false, blank:false, unique:true
        mdp nullable:false, blank:false
        dateNaissance min:new  Date().time
    }
}
