package Controller;

import Parkhaus.*;

public class GaragenController {

    Parkhaus parkhaus = null;
    public GaragenController(){
        garageRun();

    }

   public void garageRun(){
       parkhaus = createParkhaus();
       parkhaus.gesamtGroesseParkhaus();
       parkhausBearbeiten();


   }

   public Parkhaus createParkhaus(){
       int anzahlEtagen = UserController.getUserInt("Wie viele Etagen soll das Parkhaus besitzen: ");
       int anzahlParkplaetzeProEtage = UserController.getUserInt("Wie viele Parkplätze soll es pro Etage geben: ");
       Parkhaus newParkhaus = new Parkhaus(anzahlEtagen, anzahlParkplaetzeProEtage);
       return newParkhaus;
   }
   public void auswahl(){

   }
   public void parkhausBearbeiten(){
        int userwahl = UserController.getUserIntMinMax("Parkhaus bearbeiten. Bitte wählen Sie:\nEtagen hinzufügen (1)\nEtagen entfernen (2)", 1, 2);
        int etagen = 0;
        switch (userwahl){
            case 1 -> addParkhausEtage();
            case 2 -> removeParkhausEtage();
        }
       System.out.println("Parkhaus aktualisiert.");
       parkhaus.gesamtGroesseParkhaus();



   }
   public void addParkhausEtage(){
       int addAnzahlEtagen = UserController.getUserInt("Wie viele Etagen sollen dem Parkhaus hinzugefügt werden: ");
       int addAnzahlParkplaetzeProEtage = UserController.getUserInt("Wie viele Parkplätze soll es pro Etage geben: ");
       parkhaus.addEtage(addAnzahlEtagen, addAnzahlParkplaetzeProEtage);
   }
   public void removeParkhausEtage(){
       int removeAnzahlEtagen = UserController.getUserInt("Wie viele Etagen sollen dem Parkhaus hinzugefügt werden: ");
       parkhaus.removeEtage(removeAnzahlEtagen);
   }
}
