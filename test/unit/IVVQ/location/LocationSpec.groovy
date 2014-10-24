package IVVQ.location

import IVVQ.DVDs.DVD
import IVVQ.utilisateurs.Utilisateur
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Location)
class LocationSpec extends Specification {

    Location loc
    def setup() {
        loc = new Location()
    }

    void "test des contraintes sur les attributs des Location invalides"() {
        given:"un identifiant de DVD et un identifiant Utilisateur attribués à la Location"
        loc.idLocation = idLocation
        loc.idUtilisateur = idUtilisateur
        loc.idFilm = idFilm
        when:"on teste si la location est valide"
        def estValide = loc.validate()
        then:"les Location sont invalides"
        !estValide
        where:
        idLocation | idUtilisateur | idFilm
        null       | null          | null
        "loc1"     | null          | null
        "loc1"     | "007"         | null
        ""         | ""            | ""
        "loc1"     | "007"         | ""
    }

    void "test des contraintes sur les attributs "() {
        given:"un identifiant de DVD et un identifiant Utilisateur attribués à la Location"
        loc.idLocation = "loc1"
        loc.idUtilisateur = "007"
        loc.idFilm = "DVD01"
        when:"on teste si la location est valide"
        def estValide = loc.validate()
        then:"les Location sont invalides"
        estValide
    }

    def cleanup() {
    }


}
