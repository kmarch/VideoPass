package IVVQ.utilisateurs

class Utilisateur {

    String idUtil
    boolean isAdmin
    String pseudo
    String mdp
    long dateNaissance

    static constraints = {
        idUtil nullable:false, blank:false,  unique:true
        pseudo nullable:false, blank:false, unique:true
        mdp nullable:false, blank:false
        dateNaissance max:new Date().time
    }
}
