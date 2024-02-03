package Controller;
import Fahrzeuge.*;
import Parkhaus.*;

public class GaragenController {

    Parkhaus parkhaus = null;
    Auto auto = null;
    Motorrad motorrad = null;
    public GaragenController(){
        garageRun();

    }

   public void garageRun(){
       System.out.println("Parkhaus erstellen:");
       parkhaus = createParkhaus();
       parkhaus.gesamtGroesseParkhaus();
       menue();
       System.out.println("Programm beendet.");


   }

   public Parkhaus createParkhaus(){
       int anzahlEtagen = UserController.getUserInt("Wie viele Etagen soll das Parkhaus besitzen: ");
       int anzahlParkplaetzeProEtage = UserController.getUserInt("Wie viele Parkplätze soll es pro Etage geben: ");
       Parkhaus newParkhaus = new Parkhaus(anzahlEtagen, anzahlParkplaetzeProEtage);
       return newParkhaus;
   }
   public void menue(){
        while(true){
            int userWahl = UserController.getUserIntMinMax("Bitte wähle Sie:\nParkhaus bearbeiten (1)\nProgramm beenden (4)", 1, 4);
            switch(userWahl){
                case 1 -> menueParkhausBearbeiten();

                case 4 -> {
                    return;
                }

            }

        }
   }
   public void menueParkhausBearbeiten(){
        int userWahl = UserController.getUserIntMinMax("Parkhaus bearbeiten. Bitte wählen Sie:\nEtagen hinzufügen (1)\nEtagen entfernen (2)\nNeues Parkhaus erstellen (3)\nZurück (4)", 1, 4);
        switch (userWahl){
            case 1 -> parkhausBearbeitenAddParkhausEtage();
            case 2 -> parkhausBearbeitenRemoveParkhausEtage();
            case 3 -> parkhaus = createParkhaus();
            case 4 -> {return;}
        }
       System.out.println("Parkhaus aktualisiert.");
       parkhaus.gesamtGroesseParkhaus();



   }
   public void parkhausBearbeitenAddParkhausEtage(){
       int addAnzahlEtagen = UserController.getUserInt("Wie viele Etagen sollen dem Parkhaus hinzugefügt werden: ");
       // int addAnzahlParkplaetzeProEtage = UserController.getUserInt("Wie viele Parkplätze soll es pro Etage geben: ");
       parkhaus.addEtage(addAnzahlEtagen,parkhaus.getParkplaetzeProEtage());
   }
   public void parkhausBearbeitenRemoveParkhausEtage(){
       int removeAnzahlEtagen = UserController.getUserInt("Wie viele Etagen sollen aus dem Parkhaus entfernt werden: ");
       parkhaus.removeEtage(removeAnzahlEtagen);
   }
   public void parkhausVerwalten(){
        int userWahl = UserController.getUserIntMinMax("Fahrzeuge Verwalten:\nFahrzeuge einparken (1)\nFahrzeuge ausparken (2)\nFahrzeugsuche (3)\nParkhausinformationen (4)\nZurück (5)", 1, 5);
        /*
        switch (userWahl){
            case 1 -> fahrzeugEinparken();
            case 2 -> fahrzeugeAusparken();
            case 3 -> fahrzeugSuche();
            case 4 -> parkhausInfo()
            case 5 -> {return;}
        }
        */

   }
   public void fahrzeugEinparken(){
       int userWahl = UserController.getUserIntMinMax("Fahrzeuge einparken. Bitte wählen Sie:\nAuto einparken (1)\nMotorrad einparken (2)\nZurück (3)", 1, 3);
       switch (userWahl){
           case 1 -> parkeAuto();
           case 2 -> parkeMotorrad();
           case 3 -> {return;}
       }
   }
   public void parkeAuto(){
        int anzahlAutosParken = UserController.getUserInt("Wie viele Autos sollen eingeparkt werden: ");
        parkhaus.autoEinparken(anzahlAutosParken);
   }
    public void parkeMotorrad(){
        int anzahlMotorraederParken = UserController.getUserInt("Wie viele Motorräder sollen eingeparkt werden werden: ");
        parkhaus.motorradEinparken(anzahlMotorraederParken);
    }
}
