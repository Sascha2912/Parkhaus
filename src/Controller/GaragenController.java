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
       System.out.println("<< Parkhaus erstellen >>");
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
            int userWahl = UserController.getUserIntMinMax("Bitte wähle Sie:\n(1) * Parkhaus bearbeiten *\n(2) * Parkhaus verwalten *\n(3) * Parkhausinformationen *\n(4) * Programm beenden *", 1, 4);
            switch(userWahl){
                case 1 -> menueParkhausBearbeiten();
                case 2 -> menueParkhausVerwalten();
                case 3 -> menueParkhausStatus();
                case 4 -> {
                    return;
                }

            }

        }
   }
   public void menueParkhausBearbeiten(){
        int userWahl = UserController.getUserIntMinMax("Parkhaus bearbeiten. Bitte wählen Sie:\n(1) * Etagen hinzufügen *\n(2) * Etagen entfernen *\n(3) * Neues Parkhaus erstellen *\n(4) * Zurück *", 1, 4);
        switch (userWahl){
            case 1 -> parkhausBearbeitenAddParkhausEtage();
            case 2 -> parkhausBearbeitenRemoveParkhausEtage();
            case 3 -> parkhaus = createParkhaus();
            case 4 -> {return;}
        }
       System.out.println("Parkhaus aktualisiert.");
       parkhaus.gesamtGroesseParkhaus();
       menueParkhausBearbeiten();



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
   public void menueParkhausVerwalten(){
       parkhaus.parkhausStatus();
        int userWahl = UserController.getUserIntMinMax("|Parkhaus verwalten|:\n(1) * Fahrzeuge einparken *\n(2) * Fahrzeuge ausparken *\n(3) * Fahrzeugsuche *\n(4) * Zurück *", 1, 5);

        switch (userWahl){
            case 1 -> fahrzeugEinparken();
            case 2 -> fahrzeugAusparken();
            case 3 -> sucheFahrzeug();
            case 4 -> {return;}
        }
        menueParkhausVerwalten();


   }
   public void menueParkhausStatus(){
       parkhaus.parkhausStatus();
       int userWahl = UserController.getUserIntMinMax("|Parkhausinformationen|:\n(1) * Freie Parkplätze *\n(2) * Belegte Parkplätze *\n\n(4) * Zurück *", 1, 4);

       switch (userWahl){
           case 1 -> parkhaus.freieParkplaetze();
           case 2 -> parkhaus.belegteParkplaetze();
           case 3 -> System.out.println("Ungültige Eingabe");
           case 4 -> {return;}
       }
       menueParkhausStatus();
   }
   public void fahrzeugEinparken(){
       parkhaus.parkhausStatus();
       int userWahl = UserController.getUserIntMinMax("|Fahrzeuge einparken|: Bitte wählen Sie:\n(1) * Auto einparken *\n(2) * Motorrad einparken *\n(3) * Gesamtes Parkhaus füllen *\n(4) * Zurück *", 1, 4);
       switch (userWahl){
           case 1 -> parkeAuto();
           case 2 -> parkeMotorrad();
           case 3 -> parkhausFuellen();
           case 4 -> {return;}
       }
       fahrzeugEinparken();
   }
    public void fahrzeugAusparken(){
        parkhaus.parkhausStatus();
        int userWahl = UserController.getUserIntMinMax("|Fahrzeuge ausparken|: Bitte wählen Sie:\n(1) * Alle geparkten Fahrzeuge anzeigen *\n(2) * Fahrzeug ausparken *\n(3) * Gesamtes Parkhaus leeren *\n(4) * Zurück *", 1, 4);
        switch (userWahl){
            case 1 -> parkhaus.geparkteFahrzeuge();
            case 2 -> einFahrzeugAusparken();
            case 3 -> parkhausLeeren();
            case 4 -> {return;}
        }
        fahrzeugAusparken();
    }

   public void parkeAuto(){
        int anzahlAutosParken = UserController.getUserInt("Wie viele Autos sollen eingeparkt werden: ");
        for(int i = 0; i < anzahlAutosParken; i++){
            parkhaus.autoEinparken();
        }
   }
    public void parkeMotorrad(){
        int anzahlMotorraederParken = UserController.getUserInt("Wie viele Motorräder sollen eingeparkt werden werden: ");
        for(int i = 0; i < anzahlMotorraederParken; i++){
            parkhaus.motorradEinparken();
        }
    }
    public void parkhausFuellen(){
        parkhaus.alleEinparken();
    }
    public void parkhausLeeren(){
        parkhaus.alleAusparken();
    }
    public void einFahrzeugAusparken(){
        String kennzeichen = UserController.getUserString("Bitte geben Sie das Kennezichen ein von dem Fahrzeug das ausgeparkt werden soll: ");
        parkhaus.ausparken(kennzeichen);
    }

    public void sucheFahrzeug(){
        System.out.println("|Fahrzeug suche|: ");
        String kennzeichen = UserController.getUserString("Geben Sie bitte das Kennzeichen des gesuchten Fahrzeuges ein: ");
        parkhaus.fahrzeugSuche(kennzeichen);
    }
}
