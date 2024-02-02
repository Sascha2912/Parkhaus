import Parkhaus.Etage;
import Parkhaus.Parkplatz;
import Parkhaus.Parkhaus;
import Fahrzeuge.Fahrzeug;
import Fahrzeuge.Auto;
import Fahrzeuge.Motorrad;
public class Main {
    public static void main(String[] args) {

        // Erstellen von Parkhaus mit 2 Etagen und je 5 Parkplätzen
        Parkhaus parkhaus = new Parkhaus(3, 5);


        // Erstellen von Autos und Motorrädern
        Auto auto1 = new Auto();
        Auto auto2 = new Auto();
        Motorrad motorrad1 = new Motorrad();
        Motorrad motorrad2 = new Motorrad();

        // Einparken der Fahrzeuge
        parkhaus.einparken(auto1);
        parkhaus.einparken(auto2);
        parkhaus.einparken(motorrad1);
        parkhaus.einparken(motorrad2);


        for(int i = 1; i<= 5; i++){
            parkhaus.autoEinparken();
        }

        for(int i = 1; i<= 5; i++){
            parkhaus.motorradEinparken();
        }

        parkhaus.geparkteFahrzeuge();

        // Ausparken eines Fahrzeugs
        parkhaus.ausparken("au5");

        System.out.println("Fahrzeuge nach dem Ausparken:");

        parkhaus.geparkteFahrzeuge();

        parkhaus.freieParkplaetze();

        parkhaus.gesamtGroesseParkhaus();

        parkhaus.parkhausBelegung();

    }



}
