package Parkhaus;

import java.util.List;
import java.util.ArrayList;

public class Etage{
    private final List<Parkplatz> parkplaetze;
    private static int etagencount = 0;
    private final int id;

    public Etage(int anzahlParkplaetze){
        this.id = etagencount;
        etagencount++;
        this.parkplaetze = new ArrayList<>();
        for(int i = 1; i<= anzahlParkplaetze; i++){
            this.parkplaetze.add(new Parkplatz("P" + i));
        }
    }

    public int getEtagenId(){
        return this.id;
    }

    public List<Parkplatz> getAllParkplaetze(){
        return this.parkplaetze;
    }

    public Parkplatz getFreienEtagenParkplatz(){
        for(Parkplatz tmpParkplatz : this.parkplaetze){
            if( tmpParkplatz.istFrei() ){
                return tmpParkplatz;
            }
        }
        return null;
    }
}
