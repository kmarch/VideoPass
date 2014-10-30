package IVVQ.DVDs

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import videopass.DVDService
import videopass.Genre

/**
 * Created by Romain on 24/10/2014.
 */

@TestFor(DVDService)
@Mock(DVD)
class DVDServiceSpec extends Specification  {

    DVDService dvdService

    def setup() {
        dvdService = new DVDService()
     //   dvdService.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }
    }

    void "la creation d'un DVD valide crée un DVD ayant un titre, un genre, une duree, un id, une date de sortie et un nombre d'exemplaire "() {
        given:"les informations du nouveau DVD"
        String titre = "Fight Club"
        long duree = 1000*60*60*2
        Genre genre = Genre.action
        int nbExemplaire = 10

        when:"un DVD est créé"
        DVD dvd = dvdService.ajoutDVD(titre, duree, genre,nbExemplaire)

        then:"le dvd est horodaté, est attribué d'un id et comporte les attributs qu'on lui a fournit"
        dvd.sortie
        dvd.titre.equals("Fight Club")
        dvd.duree == 1000*60*60*2
        dvd.genre == Genre.action
        nbExemplaire == 10
    }

    void "la creation d'un dvd  avec un attribut non valide déclenche une exception "() {
        given:"les informations du nouveau DVD"
        String titre = "Fight Club"
        long duree = 1000*60*60*2
        Genre genre = Genre.action
        int nbExemplaire = 10

        when:"un dvd est créé avec un titre null"
        def dvd = dvdService.ajoutDVD(null,duree,genre,nbExemplaire)

        then:"une exception est levée"
        dvd.hasErrors()

        when:"un dvd est créé avec un genre null"
        dvd = dvdService.ajoutDVD(titre,duree,null,nbExemplaire)

        then:"une exception est levée"
        dvd.hasErrors()

      //  when:"un dvd est créée avec un nombre d'exemplaire négatif"
      //  dvd = dvdService.ajoutDVD(titre,duree,genre,-1)

      // then:"une exception est levée"
      //  dvd.hasErrors()

    }

    void "la creation d'un DVD valide ajoute un DVD dans la liste "() {
        given:"les informations du nouveau DVD"
        String titre = "Fight Club"
        long duree = 1000*60*60*2
        Genre genre = Genre.action
        int nbExemplaire = 10

        when:"un DVD est créé"
        DVD dvd = dvdService.ajoutDVD(titre, duree, genre,nbExemplaire)

        then:"le dvd est ajoutée dans la liste"
        dvdService.getListeDVD().size()==1

        when:"un DVD est créé"
        dvd = dvdService.ajoutDVD(titre, duree, genre,nbExemplaire)

        then:"le dvd est ajoutée dans la liste et on obtiens alors une liste de 2 DVDs"
        dvdService.getListeDVD().size()==2
    }

    void "la méthode getDVD retourne le DVD correspondant "() {
        given:"les informations du DVD qu'on va rechercher"
        String titre = "Fight Club"
        long duree = 1000*60*60*2
        Genre genre = Genre.action
        int nbExemplaire = 10

        when:"un DVD est créé et recherché"
        DVD dvd = dvdService.ajoutDVD(titre, duree, genre,nbExemplaire)
        DVD dvdSearch = dvdService.getDVD(titre);

        then:"le dvd est retourné"
        dvdSearch.getTitre() == dvd.getTitre()
        dvdSearch.getDuree() == dvd.getDuree()
        dvdSearch.getGenre() == dvd.getGenre()
        dvdSearch.getNbExemplaire() == dvd.getNbExemplaire()
        dvdSearch.getSortie() == dvd.getSortie()
    }

    void "la méthode supprimerDVD supprime le DVD correspondant "() {
        given:"les informations du DVD qu'on va supprimer et les informations d'un autre DVD"
        String titre = "Fight Club"
        long duree = 1000*60*60*2
        Genre genre = Genre.action
        int nbExemplaire = 10

        String titre2 = "Intouchables"
        long duree2 = 1000*60*60*2
        Genre genre2 = Genre.comedie
        int nbExemplaire2 = 15

        when:"les DVDs sont créés"
        DVD dvd = dvdService.ajoutDVD(titre, duree, genre,nbExemplaire)
        DVD dvd2 = dvdService.ajoutDVD(titre2, duree2, genre2,nbExemplaire2)

        then:"les dvds sont ajoutées dans la liste"
        dvdService.getListeDVD().size()==2

        when:"un DVD est supprimé"
        dvdService.supprimerDVD(titre2)

        then:"le dvd est supprimé de la liste"
        dvdService.getListeDVD().size()==1
        dvdService.getDVD(titre2) == null
        dvdService.getDVD(titre) == dvd
    }
}

