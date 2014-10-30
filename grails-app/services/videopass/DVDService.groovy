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
        int id = DVD.all.size()
        dvd.sortie = new Date().getTime()
        dvd.save()
        dvd
    }

    def getDVD(String name) {
        def dvd = DVD.findByTitre(name)
        dvd
    }

    def supprimerDVD(int id) {
        def dvd = DVD.findById(id)
        dvd.delete()
    }

    def getNouveaute() {
        def dvds = DVD.all()
        List newDvd
        def dateMin = new Date().getTime()-(1000*60*60*24*14)
        for (DVD dvd : dvds) {
            if (dvd.getSortie() > dateMin) {
                newDvd.add(dvd)
            }
        }
        newDvd
    }
}
