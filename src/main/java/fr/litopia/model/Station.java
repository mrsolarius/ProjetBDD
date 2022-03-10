package fr.litopia.model;

import fr.litopia.model.enums.VStatus;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "LesStations")
public class Station {
    @Id
    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Enumerated
    @Column(name = "v_status", nullable = false)
    private VStatus vStatus;
    @OneToMany(mappedBy = "pk.station", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    //@Todo ATTENTION ICI IL ET POSSIBLE DE NE PAS AVOIR DE BORNETTE ASSOCIER OR LA SPEC EN DEMANDE AU MOINS 2 PAR STATIONS A GERER PLUS TARD !!!
    private Set<Bornette> bornettes = new LinkedHashSet<>();

    public Set<Bornette> getBornettes() {
        return bornettes;
    }

    public void setBornettes(Set<Bornette> bornettes) {
        this.bornettes = bornettes;
    }

    public VStatus getVStatus() {
        return vStatus;
    }

    public void setVStatus(VStatus vStatus) {
        this.vStatus = vStatus;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}