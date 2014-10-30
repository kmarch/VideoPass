package IVVQ.utilisateurs

class Utilisateur {

    boolean isAdmin
    String pseudo
    String mdp
    long dateNaissance



    static constraints = {
        pseudo nullable:false, blank:false, unique:true
        mdp nullable:false, blank:false
        dateNaissance max:new Date().time
    }
}
