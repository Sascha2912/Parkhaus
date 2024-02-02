package Parkhaus;

import java.util.List;
import java.util.ArrayList;

public class Etage{
    private List<Parkplatz> parkplaetze;
    // Konstruktor, der die Anzahl der Parkplätze für die Etage festlegt

    private static int etagencount = 0;
    private int id;

    public Etage(int anzahlParkplaetze){
        this.id = etagencount;
        etagencount++;
        this.parkplaetze = new ArrayList<>();

        // Schleife, um die angegebene Anzahl von Parkplätzen zu erstellen und der Liste hinzuzufügen
        for(int i = 1; i<= anzahlParkplaetze; i++){
            this.parkplaetze.add(new Parkplatz("P" + i));
        }
    }

    public int getEtagenId(){
        return this.id;
    }

    public List<Parkplatz> getParkplaetze(){
        return this.parkplaetze;
    }

    // Methode, um einen freien Parkplatz auf der Etage zu finden
    public Parkplatz findeFreienEtagenParkplatz(){
        // Durchlaufe die Liste der Parkplätze
        for(Parkplatz tmpParkplatz : this.parkplaetze){
            // Überprüfe, ob der Parkplatz frei ist
            if( tmpParkplatz.istFrei() ){
                // Gib den ersten freien Parkplatz zurück
                return tmpParkplatz;
            }
        }
        // Wenn kein freier Parkplatz gefunden wird, gib null zurück
        return null;
    }
}
