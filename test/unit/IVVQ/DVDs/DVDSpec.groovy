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
        dvd.genre = genreDVD
        dvd.nbExemplaire = nbExemplaireDVD

        when: "on déclenche la validation du dvd"
        def res = dvd.validate()

        then: "le dvd n'a pas d'erreur de validation"
        res == true
        !dvd.hasErrors()

        where:
        titreDVD | sortieDVD       | dureeDVD | genreDVD       | nbExemplaireDVD
        "Seven"  | new Date().time | 120      | Genre.thriller | 2
        "titi"   | new Date().time | 140      | Genre.action   | 3
        "tutu"   | new Date().time | 130      | Genre.comedie  | 2

    }


    void "test des contraintes sur dvd invalide"() {

        given : "un dvd valide"
        dvd.titre = titreDVD
        dvd.sortie = sortieDVD
        dvd.duree = dureeDVD
        dvd.genre = genreDVD
        dvd.nbExemplaire = nbExemplaireDVD

        when: "on déclenche la validation du dvd"
        def res = dvd.validate()

        then: "le dvd n'a pas d'erreur de validation"
        res == false
        dvd.hasErrors()


        where:
        titreDVD | sortieDVD                  | dureeDVD | genreDVD       | nbExemplaireDVD
        null     | new Date().time + 86400000 | 120      | Genre.thriller | 2
        null     | new Date().time + 86400000 | 140      | Genre.action   | 1
        null     | new Date().time + 86400000 | 130      | Genre.comedie  | 2

    }
}
