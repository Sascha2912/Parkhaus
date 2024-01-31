package Fahrzeuge;

public abstract class Fahrzeug {

    private String kennzeichen;

    public Fahrzeug(String kennzeichen){
        this.kennzeichen = kennzeichen;
    }

    public String getKennzeichen(){
        return this.kennzeichen;
    }
    public void setKennzeichen(String kennzeichen){
        this.kennzeichen = kennzeichen;
    }

    public void reinfahren(){
        System.out.println("Das Fahrzeug mit dem Kennzeichen: " + kennzeichen + " fährt ins Parkhaus hinein.");
    }
    public void verlassen(){
        System.out.println("Das Fahrzeug mit dem Kennzeichen: " + kennzeichen + " verlässt das Parkhaus.");
    }

}
