package fr.litopia.views.menus;

import fr.litopia.controler.ControlerFactory;
import fr.litopia.controler.api.StationsControler;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.menus.station.StationView;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.api.ViewContext;
import fr.litopia.views.struct.impl.ViewContextImpl;
import fr.litopia.views.struct.impl.ViewImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class StationsChooserView extends ViewImpl {

    private ArrayList<Station> stationList;
    private StationView bornView;

    /**
     * @param parent la vue parente
     */
    public StationsChooserView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {

    }

    @Override
    protected void init() {
        StationsControler controler = ControlerFactory.getStationsControler();
        this.stationList = new ArrayList<>(controler.getAllStations());
    }

    @Override
    protected void display() {
        System.out.println("==========================");
        System.out.println("Liste des stations");
        this.displayStation(this.stationList);
        System.out.println("A quelle station voulez-vous aller ? (-1 pour quitter)");
        Integer selectedStation = ReadingConsole.readInt(-1, this.stationList.size()-1);
        if (selectedStation == -1) {
            this.stop();
        }else {
            HashMap <String, Object> context = new HashMap<>();
            context.put("station", stationList.get(selectedStation));
            ViewContext viewContext = new ViewContextImpl(this.name,context);
            bornView = new StationView(this);
            bornView.setContext(viewContext);
            bornView.run();
        }
    }

    private void displayStation(ArrayList<Station> stationList) {
        System.out.println("==========================\n");
        for (int i = 0; i < stationList.size(); i++) {
            System.out.println(i + " : " + stationList.get(i).getVStatus()+" "+stationList.get(i).getAdresse());
        }
        System.out.println("\n==========================");
    }

    @Override
    protected void close() {

    }
}
