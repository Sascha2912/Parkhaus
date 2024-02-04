package Parkhaus;

import Fahrzeuge.Auto;
import Fahrzeuge.Fahrzeug;
import Fahrzeuge.Motorrad;

import java.util.ArrayList;
import java.util.List;

public class Parkhaus {

    public List<Etage> etagen;

    private int anzahlEtagen;
    private int parkplaetzeProEtage;

    private int anzahlParkplaetzeGesamt;

    public Parkhaus(int anzahlEtagen, int parkplaetzeProEtage){
        etagen = new ArrayList<>();
        this.parkplaetzeProEtage = parkplaetzeProEtage;
        addEtage(anzahlEtagen, parkplaetzeProEtage);

    }

    public List<Etage> getEtagen(){
        return this.etagen;
    }
    public int getParkplaetzeProEtage(){
        return this.parkplaetzeProEtage;
    }
    public int getAllAnzahlParkplaetze(){
        int parkplatzCount = 0;
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz : tmpEtage.getAllParkplaetze()){
                parkplatzCount++;
            }
        }
        return  parkplatzCount;
    }
    public Parkplatz getFreienParkhausParkplatz(){
        for(Etage tmpEtage : etagen) {
            Parkplatz parkplatz = tmpEtage.getFreienEtagenParkplatz();
            if(parkplatz != null){
                return parkplatz;
            }

        }
        return null;
    }

    public Parkplatz getParkplatz(String kennzeichen){
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz: tmpEtage.getAllParkplaetze()){
                Fahrzeug tmpFahrzeug = tmpParkplatz.getFahrzeug();
                if( tmpFahrzeug != null && !tmpParkplatz.istFrei() && tmpFahrzeug.getKennzeichen().equals( kennzeichen.toUpperCase() ) ){
                    System.out.println("Kennzeichen: " + tmpFahrzeug.getKennzeichen() + " | Fahrzeugtyp: " + tmpFahrzeug.getType() +  " | Etage: " + tmpEtage.getEtagenId() + " | Parkplatz: " + tmpParkplatz.getId() );
                    return tmpParkplatz;
                }

            }
        }
        System.out.println("Fahrzeug nicht gefunden.\n");
        return null;
    }

    public void setAuto(){
        Auto auto = new Auto();
        Parkplatz freierParkplatz = getFreienParkhausParkplatz();
        if(freierParkplatz != null){
            freierParkplatz.setFahrzeug(auto);
            System.out.println("\nDas Auto: " + auto.getKennzeichen() + " hat auf dem Parkplatz : " + freierParkplatz.getId() + " eingeparkt.");
        }
        System.out.println("Das Parkhaus ist voll. Einparken nicht möglich!\n");
    }

    public void setMotorrad(){
        Motorrad motorrad = new Motorrad();
        Parkplatz freierParkplatz = getFreienParkhausParkplatz();
        if(freierParkplatz != null){
            freierParkplatz.setFahrzeug(motorrad);
            System.out.println("\nDas Motorrad: " + motorrad.getKennzeichen() + " hat auf dem Parkplatz: " + freierParkplatz.getId() + " eingeparkt.");
        }
        System.out.println("Das Parkhaus ist voll. Einparken nicht möglich!\n");
    }

    public void setAllFahrzeuge(){
        for(Etage tmpEtage : this.etagen){
            for(Parkplatz tmpParkplatz : tmpEtage.getAllParkplaetze()){
                Auto auto = new Auto();
                tmpParkplatz = getFreienParkhausParkplatz();
                if(tmpParkplatz != null){
                    tmpParkplatz.setFahrzeug(auto);
                }

                Motorrad motorrad = new Motorrad();
                Parkplatz freierParkplatz = getFreienParkhausParkplatz();
                if(freierParkplatz != null){
                    freierParkplatz.setFahrzeug(motorrad);
                }
            }
        }
        System.out.println("Das Parkhaus wurde gefüllt.\n");

    }

    public void addEtage(int anzahlEtagen, int parkplaetzeProEtage){
        for(int i = 1; i <= anzahlEtagen; i++){
            etagen.add(new Etage(parkplaetzeProEtage));
        }
        this.anzahlEtagen += anzahlEtagen;
        this.anzahlParkplaetzeGesamt = getAllAnzahlParkplaetze();
    }

    public void removeEtage(int removeAnzahlEtagen){
        int aktuelleAnzahlEtagen = etagen.size();
        int neueAnzahlEtagen = aktuelleAnzahlEtagen - removeAnzahlEtagen;

        if(neueAnzahlEtagen >= 0){
            for(int i = 0; i < removeAnzahlEtagen; i++){
                etagen.remove(etagen.size() - 1);
            }
            this.anzahlEtagen = neueAnzahlEtagen;
            this.anzahlParkplaetzeGesamt = getAllAnzahlParkplaetze();
        }else{
            System.out.println("Fehler: Die Anzahl der zu entfernenden Etagen ist größer als die aktuelle Anzahl der Etagen.\n");
        }
    }

    public void removeFahrzeug(String kennzeichen){
        Parkplatz tmpParkplatz = getParkplatz(kennzeichen);
        if(tmpParkplatz != null){
            System.out.println(" Ausgeparkt.\nParkplatz wieder frei.\n");
            tmpParkplatz.removeFahrzeug();
        }
        System.out.println("Fahrzeug nicht gefunden.\n");
    }

    public void removeAllFahrzeuge(){
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz: tmpEtage.getAllParkplaetze()){
                if(!tmpParkplatz.istFrei()){
                    tmpParkplatz.removeFahrzeug();
                }

            }
        }
        System.out.println("\nAlle Fahrzeuge ausgeparkt.");
    }

    public void showGeparkteFahrzeuge(){
        int geparkteFahrzeuge = 0;
        System.out.println("\nGeparkte Fahrzeuge:");
        for (Etage etage : this.getEtagen()) {
            for (Parkplatz parkplatz : etage.getAllParkplaetze()) {
                if (!parkplatz.istFrei()) {
                    geparkteFahrzeuge++;
                    System.out.println(etage.getEtagenId() + ". Etage | Parkplatz: " + parkplatz.getId()  + " | " + parkplatz.getFahrzeug().getType() +  " | Kennzeichen: " + parkplatz.getFahrzeug().getKennzeichen());
                }
            }
        }
        System.out.println(geparkteFahrzeuge + " Fahrzeuge gefunden.");
    }

    public void showFreieParkplaetze(){
        System.out.println("Freie Parkplätze:");
        for (Etage etage : this.getEtagen()) {
            for (Parkplatz parkplatz : etage.getAllParkplaetze()) {
                if (parkplatz.istFrei()) {
                    System.out.print(parkplatz.getId() + " Etage: " + etage.getEtagenId() + " | ");
                }
            }
            System.out.println(" ");
        }
    }

    public void showBelegteParkplaetze(){
        System.out.println("Belegte Parkplätze:");
        for (Etage etage : this.getEtagen()) {
            for (Parkplatz parkplatz : etage.getAllParkplaetze()) {
                if ( !parkplatz.istFrei() ) {
                    System.out.print(parkplatz.getId() + " Etage: " + etage.getEtagenId() + " | ");
                }
            }
            System.out.println(" ");
        }

    }

    public void showGesamtgroesseParkhaus(){
        int parkplaetzeProEtage = anzahlParkplaetzeGesamt / anzahlEtagen;
        System.out.println("\nDas Parkhaus besteht aus:\n" + anzahlEtagen + " Etagen | " + parkplaetzeProEtage + " Parkplätzen pro Etage: " + "\nParkplätze gesamt => " + anzahlParkplaetzeGesamt);
    }
    public void showParkhausStatus(){
        int freieParkplaetze = 0;
        int belegteParkplaetze = 0;
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz : tmpEtage.getAllParkplaetze()){
                if (tmpParkplatz.istFrei()) {
                    freieParkplaetze++;
                }
            }
        }
        belegteParkplaetze = anzahlParkplaetzeGesamt - freieParkplaetze;
        System.out.println("\nAnzahl Parkplätze gesamt: " + anzahlParkplaetzeGesamt + " | belegt: " + belegteParkplaetze + " | frei: " + freieParkplaetze);

    }

}
