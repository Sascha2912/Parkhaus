package Parkhaus;

import Fahrzeuge.Auto;
import Fahrzeuge.Fahrzeug;
import Fahrzeuge.Motorrad;

import java.util.ArrayList;
import java.util.List;

public class Parkhaus {

    public List<Etage> etagen;

    private int anzahlEtagen;

    private int anzahlParkplaetzeGesamt;

    public Parkhaus(int anzahlEtagen, int parkplaetzeProEtage){
        etagen = new ArrayList<>();
        addEtage(anzahlEtagen, parkplaetzeProEtage);

    }

    public void addEtage(int anzahlEtagen, int parkplaetzeProEtage){
        for(int i = 1; i <= anzahlEtagen; i++){
            etagen.add(new Etage(parkplaetzeProEtage));
        }
        this.anzahlEtagen += anzahlEtagen;
        this.anzahlParkplaetzeGesamt = getAllParkplaetze();
    }

    public void removeEtage(int removeAnzahlEtagen){
        int aktuelleAnzahlEtagen = etagen.size();
        int neueAnzahlEtagen = aktuelleAnzahlEtagen - removeAnzahlEtagen;

        if(neueAnzahlEtagen >= 0){
            for(int i = 0; i < removeAnzahlEtagen; i++){
                etagen.remove(etagen.size() - 1);
            }
            this.anzahlEtagen = neueAnzahlEtagen;
            this.anzahlParkplaetzeGesamt = getAllParkplaetze();
        }else{
            System.out.println("Fehler: Die Anzahl der zu entfernenden Etagen ist größer als die aktuelle Anzahl der Etagen.");
        }


    }

    public List<Etage> getEtagen(){
        return this.etagen;
    }
    public int getAllParkplaetze(){
        int parkplatzCount = 0;
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz : tmpEtage.getParkplaetze()){
                parkplatzCount++;
            }
        }
        return  parkplatzCount;
    }



    public Parkplatz findeFreienParkhausParkplatz(){
        for(Etage tmpEtage : etagen) {
           Parkplatz parkplatz = tmpEtage.findeFreienEtagenParkplatz();
           if(parkplatz != null){
               System.out.print("Etage: " + tmpEtage.getEtagenId() + ". ");
               return parkplatz;
           }

        }
        return null;
    }

    public boolean einparken(Fahrzeug fahrzeug){
        Parkplatz freierParkplatz = findeFreienParkhausParkplatz();
        if(freierParkplatz != null){
            freierParkplatz.belegen(fahrzeug);
            System.out.println("Das Fahrzeug: " + fahrzeug.getKennzeichen() + " hat auf dem Parkplatz : " + freierParkplatz.getId() + " eingeparkt.");
            return true;
        }
        System.out.println("Das Parkhaus ist voll. Einparken nicht möglich!");
        return  false;
    }

    public boolean autoEinparken(int anzahl){
        Auto auto = new Auto();
        Parkplatz freierParkplatz = findeFreienParkhausParkplatz();
        if(freierParkplatz != null){
            freierParkplatz.belegen(auto);
            System.out.println("Das Fahrzeug: " + auto.getKennzeichen() + " hat auf dem Parkplatz : " + freierParkplatz.getId() + " eingeparkt.");
            return true;
        }
        System.out.println("Das Parkhaus ist voll. Einparken nicht möglich!");
        return  false;
    }



    public boolean motorradEinparken(int anzahl){
        Motorrad motorrad = new Motorrad();
        Parkplatz freierParkplatz = findeFreienParkhausParkplatz();
        if(freierParkplatz != null){
            freierParkplatz.belegen(motorrad);
            System.out.println("Das Fahrzeug: " + motorrad.getKennzeichen() + " hat auf dem Parkplatz : " + freierParkplatz.getId() + " eingeparkt.");
            return true;
        }
        System.out.println("Das Parkhaus ist voll. Einparken nicht möglich!");
        return  false;
    }

    public boolean ausparken(String kennzeichen){
         Parkplatz tmpParkplatz = fahrzeugSuche(kennzeichen);

        if(tmpParkplatz != null){
            System.out.println("Ausgeparkt. Parkplatz wieder frei.");
            tmpParkplatz.freigeben();
            return true;
        }
        System.out.println("Fahrzeug nicht gefunden.");
        return false;
    }

    public Parkplatz fahrzeugSuche(String kennzeichen){
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz: tmpEtage.getParkplaetze()){
                Fahrzeug tmpFahrzeug = tmpParkplatz.getFahrzeug();
                if( tmpFahrzeug != null && !tmpParkplatz.istFrei() && tmpFahrzeug.getKennzeichen().equals( kennzeichen.toUpperCase() ) ){
                    System.out.println("Kennzeichen: " + tmpFahrzeug.getKennzeichen() + " | Fahrzeugtyp: " + tmpFahrzeug.getType() +  " | Etage: " + tmpEtage.getEtagenId() + " | Parkplatz: " + tmpParkplatz.getId() );
                    return tmpParkplatz;
                }

            }
        }
        System.out.println("Fahrzeug nicht gefunden.");
        return null;
    }

    public boolean ausparken2(Fahrzeug fahrzeug){
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz: tmpEtage.getParkplaetze()){
                if(!tmpParkplatz.istFrei() && tmpParkplatz.getFahrzeug().equals(fahrzeug)){
                    tmpParkplatz.freigeben();
                    System.out.println("Das Fahrzeug: " + fahrzeug.getKennzeichen() + " hat den Parkplatz " + tmpParkplatz.getId() + " verlassen.\nParkplatz: " + tmpParkplatz.getId() + " ist wieder freigegeben.");
                    return true;
                }

            }
        }
        System.out.println("Fahrzeug nicht gefunden.");
        return false;
    }

    public void geparkteFahrzeuge(){
        System.out.println("Geparkte Fahrzeuge:");
        for (Etage etage : this.getEtagen()) {
            for (Parkplatz parkplatz : etage.getParkplaetze()) {
                if (!parkplatz.istFrei()) {
                    System.out.println(etage.getEtagenId() + ". Etage | Parkplatz: " + parkplatz.getId()  + " | " + parkplatz.getFahrzeug().getType() +  " | Kennzeichen: " + parkplatz.getFahrzeug().getKennzeichen());
                }
            }
        }
    }

    public void freieParkplaetze(){
        System.out.println("Freie Parkplätze:");
        for (Etage etage : this.getEtagen()) {
            for (Parkplatz parkplatz : etage.getParkplaetze()) {
                if (parkplatz.istFrei()) {
                    System.out.println(parkplatz.getId() + " Etage: " + etage.getEtagenId());
                }
            }
        }
    }

    public void gesamtGroesseParkhaus(){
        int parkplaetzeProEtage = anzahlParkplaetzeGesamt / anzahlEtagen;
        System.out.println("Das Parkhaus besteht aus:\n" + anzahlEtagen + " Etagen | " + parkplaetzeProEtage + " Parkplätzen pro Etage: " + "\nParkplätze gesamt => " + anzahlParkplaetzeGesamt);
    }
    public void parkhausBelegung(){
        int freieParkplaetze = 0;
        int belegteParkplaetze = 0;
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz : tmpEtage.getParkplaetze()){
                if (tmpParkplatz.istFrei()) {
                    freieParkplaetze++;
                }
            }
        }
        belegteParkplaetze = anzahlParkplaetzeGesamt - freieParkplaetze;
        System.out.println("\nAnzahl Parkplätze gesamt: " + anzahlParkplaetzeGesamt + "\nParkplätze frei: " + freieParkplaetze + "\nParkplätze belegt: " + belegteParkplaetze);

    }

}
