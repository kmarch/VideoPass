package IVVQ.DVDs

import grails.test.mixin.TestFor
import spock.lang.Specification
import videopass.Genre

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DVD)
class DVDSpec extends Specification {

    DVD dvd

    def setup() {
        dvd = new DVD()
    }

    def cleanup() {

    }


    void "test des contraintes sur dvd valide"() {

        given : "un dvd valide"
        dvd.titre = titreDVD
        dvd.sortie = sortieDVD
        dvd.duree = dureeDVD
        dvd.id = idDVD
        dvd.genre = genreDVD
        dvd.nbExemplaire = nbExemplaireDVD

        when: "on déclenche la validation du dvd"
        def res = dvd.validate()

        then: "le dvd n'a pas d'erreur de validation"
        res == true
        !dvd.hasErrors()

        where:
        titreDVD | sortieDVD                  | dureeDVD | idDVD  | genreDVD       | nbExemplaireDVD
        "Seven"  | new Date().time + 86400000 | 120      | "dvd1" | Genre.thriller | 2
        "titi"   | new Date().time + 86400000 | 140      | "dvd2" | Genre.action   | 3
        "tutu"   | new Date().time + 86400000 | 130      | "dvd3" | Genre.comedie  | 2

    }



}
