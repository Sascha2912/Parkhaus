package Controller;
import Parkhaus.*;
import UserInput.UserInput;

public class GaragenController {

    private Parkhaus parkhaus = null;

   public void garageRun(){
       System.out.println("<< Parkhaus erstellen >>");
       parkhaus = createParkhaus();
       parkhaus.showGesamtgroesseParkhaus();
       menue();
       System.out.println("Programm beendet.");


   }

   private void menue(){
        while(true){
            int userWahl = UserInput.getUserIntMinMax("Bitte wähle Sie:\n(1) * Parkhaus bearbeiten *\n(2) * Parkhaus verwalten *\n(3) * Parkhausinformationen *\n(4) * Programm beenden *", 1, 4);
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
   private void menueParkhausBearbeiten(){
        int userWahl = UserInput.getUserIntMinMax("Parkhaus bearbeiten. Bitte wählen Sie:\n(1) * Etagen hinzufügen *\n(2) * Etagen entfernen *\n(3) * Neues Parkhaus erstellen *\n(4) * Zurück *", 1, 4);
        switch (userWahl){
            case 1 -> addEtage();
            case 2 -> parkhaus.removeEtage();
            case 3 -> parkhaus = createParkhaus();
            case 4 -> {return;}
        }
       System.out.println("Parkhaus aktualisiert.");
       parkhaus.showGesamtgroesseParkhaus();
       menueParkhausBearbeiten();

   }
   private void addEtage(){
       int addAnzahlEtagen = UserInput.getUserInt("Wie viele Etagen sollen dem Parkhaus hinzugefügt werden: ");
       parkhaus.addEtage(addAnzahlEtagen);
   }

   private Parkhaus createParkhaus(){
       int addAnzahlEtagen = UserInput.getUserInt("Wie viele Etagen sollen dem Parkhaus hinzugefügt werden: ");
       int anzahlParkplaetzeProEtage = UserInput.getUserInt("Wie viele Parkplätze soll es pro Etage geben: ");
       return new Parkhaus(addAnzahlEtagen, anzahlParkplaetzeProEtage);
   }

   private void menueParkhausVerwalten(){
       parkhaus.showParkhausStatus();
        int userWahl = UserInput.getUserIntMinMax("|Parkhaus verwalten|:\n(1) * Fahrzeuge einparken *\n(2) * Fahrzeuge ausparken *\n(3) * Fahrzeugsuche *\n(4) * Zurück *", 1, 5);

        switch (userWahl){
            case 1 -> parkhausVerwaltenFahrzeugEinparken();
            case 2 -> parkhausVerwaltenFahrzeugAusparken();
            case 3 -> parkhausVerwaltenSucheFahrzeug();
            case 4 -> {return;}
        }
        menueParkhausVerwalten();

   }
    private void parkhausVerwaltenFahrzeugEinparken(){
        parkhaus.showParkhausStatus();
        int userWahl = UserInput.getUserIntMinMax("|Fahrzeuge einparken|: Bitte wählen Sie:\n(1) * Auto einparken *\n(2) * Motorrad einparken *\n(3) * Gesamtes Parkhaus füllen *\n(4) * Zurück *", 1, 4);
        switch (userWahl){
            case 1 -> fahrzeugEinparkenParkeAuto();
            case 2 -> fahrzeugEinparkenParkeMotorrad();
            case 3 -> parkhaus.setAllFahrzeuge();
            case 4 -> {return;}
        }
        parkhausVerwaltenFahrzeugEinparken();
    }

    private void fahrzeugEinparkenParkeAuto(){
        int anzahlAutosParken = UserInput.getUserInt("Wie viele Autos sollen eingeparkt werden: ");
        for(int i = 0; i < anzahlAutosParken; i++){
            parkhaus.setAuto();
        }
    }
    private void fahrzeugEinparkenParkeMotorrad(){
        int anzahlMotorraederParken = UserInput.getUserInt("Wie viele Motorräder sollen eingeparkt werden werden: ");
        for(int i = 0; i < anzahlMotorraederParken; i++){
            parkhaus.setMotorrad();
        }
    }

    private void parkhausVerwaltenFahrzeugAusparken(){
        parkhaus.showParkhausStatus();
        int userWahl = UserInput.getUserIntMinMax("|Fahrzeuge ausparken|: Bitte wählen Sie:\n(1) * Alle geparkten Fahrzeuge anzeigen *\n(2) * Fahrzeug ausparken *\n(3) * Gesamtes Parkhaus leeren *\n(4) * Zurück *", 1, 4);
        switch (userWahl){
            case 1 -> parkhaus.showGeparkteFahrzeuge();
            case 2 -> parkhaus.removeFahrzeug();
            case 3 -> parkhaus.removeAllFahrzeuge();
            case 4 -> {return;}
        }
        parkhausVerwaltenFahrzeugAusparken();
    }

    private void parkhausVerwaltenSucheFahrzeug(){
        System.out.println("|Fahrzeug suche|: ");
        String kennzeichen = UserInput.getUserString("Geben Sie bitte das Kennzeichen des gesuchten Fahrzeuges ein: ");
        parkhaus.getParkplatz(kennzeichen);
    }

    private void menueParkhausStatus(){
        parkhaus.showParkhausStatus();
        int userWahl = UserInput.getUserIntMinMax("|Parkhausinformationen|:\n(1) * Freie Parkplätze *\n(2) * Belegte Parkplätze *\n\n(4) * Zurück *", 1, 4);

        switch (userWahl){
            case 1 -> parkhaus.showFreieParkplaetze();
            case 2 -> parkhaus.showBelegteParkplaetze();
            case 3 -> System.out.println("Ungültige Eingabe");
            case 4 -> {return;}
        }
        menueParkhausStatus();
    }
}
