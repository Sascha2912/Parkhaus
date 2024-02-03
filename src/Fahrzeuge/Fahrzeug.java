package Fahrzeuge;

import java.util.HashMap;

public abstract class Fahrzeug {

    private String kennzeichen;
    private String typ = "";

    protected static int count = 0;

    public Fahrzeug(String typ){
        count++;
        this.kennzeichen = generateKennzeichen();
        this.typ = typ;
    }

    protected String generateKennzeichen(){
        return "KFZ" + count;
    }

    public String getKennzeichen(){
        return this.kennzeichen;
    }

    public String getType(){
        return this.typ;
    }

    public void reinfahren(){
        System.out.println("Das Fahrzeug mit dem Kennzeichen: " + kennzeichen + " fährt ins Parkhaus hinein.");
    }
    public void verlassen(){
        System.out.println("Das Fahrzeug mit dem Kennzeichen: " + kennzeichen + " verlässt das Parkhaus.");
    }

}
