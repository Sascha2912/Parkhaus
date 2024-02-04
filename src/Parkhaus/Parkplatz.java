package Parkhaus;

import Fahrzeuge.Fahrzeug;
public class Parkplatz{

    private final String id;
    private Fahrzeug fahrzeug;
    private boolean frei;

    public Parkplatz(String id){
        this.id = id;
        this.frei = true;
    }

    public String getId(){
        return this.id;
    }

    public Fahrzeug getFahrzeug(){
        return this.fahrzeug;
    }

    public void setFahrzeug(Fahrzeug fahrzeug){
        this.fahrzeug = fahrzeug;
        this.frei = false;
    }

    public void removeFahrzeug(){
        this.fahrzeug = null;
        this.frei = true;
    }

    public boolean istFrei(){
        return this.frei;
    }
}
