package fr.litopia.respository.api;

import fr.litopia.model.Bornette;
import fr.litopia.model.BornettePK;
import fr.litopia.model.Station;
import fr.litopia.model.enums.Etat;

import java.util.Set;

public interface BornetteRepository extends Repository<Bornette, BornettePK> {
    //@Todo ajouter des methods utiles pour la gestion des bornettes
    long getLastIdInStation(Station s);

    /**
     * renvoie les bornettes d'une station
     */
    Set<Bornette> getBornettesStation(Station s);

    /**
     * renvoie les bornettes à l'état e qui contiennent des vélos à l'état e
     */
    Set<Bornette> getBornettesStation(Station s, Etat e);
}
