package Parkhaus;

import java.util.List;
import java.util.ArrayList;

public class Etage{
    private List<Parkplatz> parkplaetze;

    public Etage(int anzahlParkplaetze){
        this.parkplaetze = new ArrayList<>();

        for(int i = 1; i<= anzahlParkplaetze; i++){
            this.parkplaetze.add(new Parkplatz("P" + i));
        }
    }

    public List<Parkplatz> getParkplaetze(){
        return this.parkplaetze;
    }

    public Parkplatz findeFreienParkplatz(){
        for(Parkplatz tmpParkplatz : this.parkplaetze){
            if( tmpParkplatz.istFrei() ){
                return tmpParkplatz;
            }
        }
        return null;
    }
}
