package Parkhaus;

import Fahrzeuge.Fahrzeug;

import java.util.ArrayList;
import java.util.List;

public class Parkhaus {

    private List<Etage> etagen;

    public Parkhaus(int anzahlEtagen, int parkplaetzeProEtage){
        etagen = new ArrayList<>();
        for(int i = 1; i <= anzahlEtagen; i++){
            etagen.add(new Etage(parkplaetzeProEtage));
        }
    }

    public Parkplatz findeFreienParkhausParkplatz(){
        for(Etage tmpEtage : etagen) {
           Parkplatz parkplatz = tmpEtage.findeFreienEtagenParkplatz();
           if(parkplatz != null){
               return parkplatz;
           }

        }
        return null;
    }

    public boolean einparken(Fahrzeug fahrzeug){
        Parkplatz freierParkplatz = findeFreienParkhausParkplatz();
        if(freierParkplatz != null){
            freierParkplatz.belegen(fahrzeug);
            System.out.println("Das Fahrezeug: " + fahrzeug.getKennzeichen() + " hat auf dem Parkplatz : " + freierParkplatz.getId() + " eingeparkt.");
            return true;
        }
        System.out.println("Das Parkhaus ist voll. Einparken nicht möglich.");
        return  false;
    }

    public boolean ausparken(Fahrzeug fahrzeug){
        for(Etage tmpEtage : etagen){
            for(Parkplatz tmpParkplatz: tmpEtage.getParkplaetze()){
                if(!tmpParkplatz.istFrei() && tmpParkplatz.getFahrzeug().equals(fahrzeug)){
                    tmpParkplatz.freigeben();
                    System.out.println("Fahrzeug erfolgreich ausgeparkt. Parkplatz wieder freigeben.");
                    return true;
                }

            }
        }
        System.out.println("Fahrzeug nicht gefunden.");
        return false;
    }

}
