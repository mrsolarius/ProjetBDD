package fr.litopia.controller.impl;

import fr.litopia.controller.api.RetraitControler;
import fr.litopia.model.*;
import fr.litopia.model.enums.Etat;
import fr.litopia.respository.RepositoryFactory;
import fr.litopia.respository.api.BornetteRepository;
import fr.litopia.respository.api.LocationAbonneRepository;
import fr.litopia.respository.api.LocationNonAbonneRepository;
import java.util.Set;


public class RetraitControlerImpl extends ControlerImp implements RetraitControler {

    private BornetteRepository bornette;
    private LocationNonAbonneRepository locationNonAbonneRepository;
    private LocationAbonneRepository locationAbonneRepository;

    @Override
    public void init() {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        bornette = repositoryFactory.newBornetteRepository(getEntityManager());
        locationNonAbonneRepository = repositoryFactory.newLocationNonAbonneRepository(getEntityManager());
        locationAbonneRepository = repositoryFactory.newLocationAbonneRepository(getEntityManager());
    }

    @Override
    public Bornette peutRendre(Station station) {
        Set<Bornette> set;
        set=bornette.getBornettesStationWithoutBike(station, Etat.OK);
        if(set.isEmpty()){
            return null;
        }
        else{
            return set.iterator().next();
        }
    }

    @Override
    public LocationNonAbonne checkCode(String code) {
        return locationNonAbonneRepository.getLocNonAbonne(code);
    }

    @Override
    public Boolean isUnderFiveMinutes(Location loc) {
        return loc.isUnderFiveMinutes();
    }

    @Override
    public Double clotureLocationNonAbonne(Bornette bornette, LocationNonAbonne loc) {
        loc.cloreLocation(bornette);
        locationNonAbonneRepository.save(loc);
        return loc.getPrix();
    }

    @Override
    public Set<LocationAbonne> getLocationsEnCours(Abonne abonne) {
        return abonne.getLocationAbonnes();
    }

    @Override
    public Double clotureLocationAbonne(Bornette bornette, LocationAbonne loc) {
        loc.cloreLocation(bornette);
        locationAbonneRepository.save(loc);
        return loc.getPrix();
    }

    @Override
    public void clotureLocationHSUnderFiveMinutes(Bornette bornette, Location loc) {
        loc.clotureLocationHSUnderFiveMinutes(bornette);
    }
}
