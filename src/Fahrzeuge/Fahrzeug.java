package Fahrzeuge;

import java.util.HashMap;

public abstract class Fahrzeug {

    public static HashMap<String, Fahrzeug> fahrzeuge = new HashMap<>();
    private String kennzeichen;
    private String typ = "";

    protected static int count = 0;

    public Fahrzeug(String typ){
        count++;
        this.kennzeichen = generateKennzeichen();
        this.typ = typ;
        fahrzeuge.put(kennzeichen, this);
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
}
