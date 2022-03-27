package fr.litopia.views.tinyView;

import fr.litopia.controler.ControlerFactory;
import fr.litopia.controler.api.RetourControler;
import fr.litopia.model.LocationNonAbonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.impl.TinyViewImpl;

public class RetourLocTinyView extends TinyViewImpl<LocationNonAbonne> {
    private RetourControler retourControler;
    private String code;

    @Override
    protected void init() {
        retourControler = ControlerFactory.getRetraitControler();
    }

    @Override
    protected void display() {
        System.out.println("==================");
        System.out.println("Veuillez renseigner votre code (-1 pour annuler): ");
        code = ReadingConsole.readLineWithMaxChar(20);
        if (code.equals("-1")) this.cancel();
    }

    @Override
    protected LocationNonAbonne getValue() {
        LocationNonAbonne loc = retourControler.checkCode(code);
        if (loc==null){
            System.out.println("=================");
            System.out.println("CODE INCORRECT, VEUILLEZ SAISIR A NOUVEAU ou -1 pour anuler");
            System.out.println("==================");
        }
        return loc;
    }

}
