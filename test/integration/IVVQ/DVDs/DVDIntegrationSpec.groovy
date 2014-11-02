package IVVQ.DVDs



import spock.lang.Specification
import videopass.Genre

/**
 *
 */
class DVDIntegrationSpec extends Specification {

    DVD dvd1
    DVD dvd2

    def setup() {
        dvd1 = new DVD(titre:"seven",sortie: new Date().time ,duree: 130 , genre: Genre.thriller, nbExemplaire: 2)

        dvd1.save(failOnError:true)

    }

    def cleanup() {
    }

    void "test création deux DVD identiques avec même titre"() {

        given : "deux dvd identiques"
        dvd2 = new DVD(titre:"seven" , sortie: new Date().time ,duree: 130, genre: Genre.thriller, nbExemplaire: 2)

        when : "ajout du même dvd"
        def estBon = dvd2.save()

        then : "ça marche"
        estBon != null
    }

}
