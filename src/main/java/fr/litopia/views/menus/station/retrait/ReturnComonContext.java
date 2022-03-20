package fr.litopia.views.menus.station.retrait;

import fr.litopia.controller.api.EmprunControler;
import fr.litopia.controller.api.RetraitControler;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

public abstract class ReturnComonContext extends ViewImpl {
    protected Station station;
    protected RetraitControler retraitControler;

    public ReturnComonContext(View view) {
        super(view);
    }

    @Override
    protected void onContextSet() {
        this.station = (Station) this.viewContext.getContext().get("station");
        this.retraitControler = (RetraitControler) this.viewContext.getContext().get("retraitControler");
        if(this.station == null || this.retraitControler == null) {
            System.out.println("Erreur : ReturnComonContext n'a pas pu récupérer le contexte");
            ReadingConsole.readLine();
            this.stop();
        }
    }
}