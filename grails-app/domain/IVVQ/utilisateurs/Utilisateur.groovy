package IVVQ.utilisateurs

class Utilisateur {

    String id
    boolean isAdmin
    String pseudo
    String mdp
    long dateNaissance
    static belongsTo = [utilisateur:ListeUtilisateur]

    static constraints = {
        id nullable:false, blank:false,  unique:true
        isAdmin nullable:false
        pseudo nullable:false, blank:false, unique:true
        mdp nullable:false, blank:false
        dateNaissance nullable:false, min:new Date().time
    }
}
