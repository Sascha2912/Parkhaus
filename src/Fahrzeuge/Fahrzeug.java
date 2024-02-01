package Fahrzeuge;

public abstract class Fahrzeug {

    private String kennzeichen;

    protected static int count = 0;

    public Fahrzeug(){
        count++;
        this.kennzeichen = generateKennzeichen();
    }

    protected String generateKennzeichen(){
        return "KFZ" + count;
    }

    public String getKennzeichen(){
        return this.kennzeichen;
    }

    public void reinfahren(){
        System.out.println("Das Fahrzeug mit dem Kennzeichen: " + kennzeichen + " fährt ins Parkhaus hinein.");
    }
    public void verlassen(){
        System.out.println("Das Fahrzeug mit dem Kennzeichen: " + kennzeichen + " verlässt das Parkhaus.");
    }

}
