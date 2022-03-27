package fr.litopia.controller.impl;

import fr.litopia.controller.api.StationsControler;
import fr.litopia.model.Station;
import fr.litopia.respository.api.StationRepository;

import java.util.Set;

public class StationsControlerImpl extends ControlerImp implements StationsControler {

    private StationRepository stationRepository;

    public StationsControlerImpl() {
        super();
    }

    @Override
    public void init() {
        stationRepository = getRepositoryFactory().newStationRepository(getEntityManager());
    }

    @Override
    public Set<Station> getAllStations() {
        return stationRepository.getAll();
    }
}
