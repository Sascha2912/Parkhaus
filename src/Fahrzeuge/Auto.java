package Fahrzeuge;

public class Auto extends Fahrzeug{

    public Auto(){
        super("Auto");
    }

    @Override
    protected String generateKennzeichen() {
        return "AU" + count;
    }

}
