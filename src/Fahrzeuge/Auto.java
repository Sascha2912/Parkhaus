package Fahrzeuge;

public class Auto extends Fahrzeug{

    public Auto(){
        super();
    }

    @Override
    protected String generateKennzeichen() {
        count++;
        return "AU" + count;
    }

}
