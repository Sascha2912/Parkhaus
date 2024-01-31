package Parkhaus;

import Fahrzeuge.Fahrzeug;
public class Parkplatz{

    private String id;
    private Fahrzeug fahrzeug;
    private boolean frei;

    public Parkplatz(String id){
        this.id = id;
        this.frei = true;
    }

    public String getId(){
        return this.id;
    }
    public boolean istFrei(){
        return this.frei;
    }
    public void belegen(Fahrzeug fahrzeug){
        this.fahrzeug = fahrzeug;
        this.frei = false;
    }
    public void freigeben(){
        this.fahrzeug = null;
        this.frei = true;
    }

    public Fahrzeug getFahrzeug(){
        return this.fahrzeug;
    }

}
