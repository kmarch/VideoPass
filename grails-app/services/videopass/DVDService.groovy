package videopass

import IVVQ.DVDs.DVD
import org.springframework.transaction.annotation.Transactional

@Transactional
class DVDService {

    def getListeDVD() {
        DVD.all
    }

    def ajoutDVD(String titre, long duree, Genre genre, int nb) {
        DVD dvd = new DVD(titre: titre, duree: duree, genre : genre, nbExemplaire: nb)
        dvd.sortie = new Date().getTime()
        dvd.save()
        dvd
    }

    def ajoutDVD(String titre, long duree, Genre genre, int nb, long sortie) {
        DVD dvd = new DVD(titre: titre, duree: duree, genre : genre, nbExemplaire: nb, sortie : sortie)
        dvd.save()
        dvd
    }

    def getDVD(String name) {
        def dvd = DVD.findByTitre(name)
        dvd
    }

    def supprimerDVD(String name) {
        def dvd = DVD.findByTitre(name)
        dvd.delete()
    }

    def getNouveaute() {
        def dvds = DVD.all
        ArrayList newDvd = new ArrayList()
        long dateMin = new Date().getTime()-(60*60*24*14)
        for (DVD dvd : dvds) {
            if (dvd.getSortie() > dateMin) {
                newDvd.add(dvd)
            }
        }
        newDvd
    }
}
