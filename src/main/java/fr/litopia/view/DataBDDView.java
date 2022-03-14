package fr.litopia.view;

import fr.litopia.controler.DataBDDControler;
import fr.litopia.utils.ReadingConsole;

public class DataBDDView extends View{
    private DataBDDControler controler;

    @Override
    protected void init() {
        controler = new DataBDDControler(this);
    }

    @Override
    protected void display() {
        System.out.println("====================");
        System.out.println("Gestion des données");
        System.out.println("====================\n");
        System.out.println("1. Initaliser la base de données avec des données de test");
        System.out.println("2. Supprimer toutes les données de la base de données");
        System.out.println("3. Retour");
        System.out.println("====================");
        System.out.println("Votre choix : ");
        Integer choice = ReadingConsole.readInt(1,3);
        switch (choice) {
            case 1 -> {
                controler.initializeData();
                System.out.println("Données initialisées");
                System.out.println("Appuyez sur une touche pour continuer");
                ReadingConsole.readLine();
                this.close();
            }
            case 2 -> {
                controler.deleteData();
                System.out.println("Données supprimées");
                System.out.println("Appuyez sur une touche pour retourner au menu");
                ReadingConsole.readLine();
                this.close();
            }
            case 3 -> {
                this.stop();
            }
        }
    }

    @Override
    protected void close() {

    }
}
