package IVVQ.DVDs



import spock.lang.*
import videopass.Genre

/**
 *
 */
class DVDIntegrationSpec extends Specification {

    DVD dvd1
    DVD dvd2

    def setup() {
        dvd1 = new DVD(titre:"seven",sortie:new Date().time + 86400000,duree: 130, idDVD: "dvd1" , genre: Genre.thriller, nbExemplaire: 2)

        dvd1.save(failOnError:true)

    }

    def cleanup() {
    }

    void "test création deux DVD identiques avec même id"() {

        given : "deux dvd identiques"
        dvd2 = new DVD(titre:"seven",sortie:new Date().time + 86400000,duree: 130, idDVD: "dvd1" , genre: Genre.thriller, nbExemplaire: 2)

        when : "ajout du même dvd"
        def estBon = dvd2.save(failOnError:true)

        then : "erreur"
        estBon == false
    }

    void "test création deux DVD identiques avec id différent"() {

        given : "deux dvd identiques"
        dvd2 = new DVD(titre:"seven",sortie:new Date().time + 86400000,duree: 130, idDVD: "dvd2" , genre: Genre.thriller, nbExemplaire: 2)

        when : "ajout du même dvd"
        def estBon = dvd2.save(failOnError:true)

        then : "ça marche"
        estBon == true
    }
}
