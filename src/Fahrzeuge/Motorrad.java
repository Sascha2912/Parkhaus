package Fahrzeuge;

public class Motorrad extends Fahrzeug{

    public Motorrad(){
        super();
    }

    @Override
    protected String generateKennzeichen() {
        count++;
        return "MO" + count;
    }

}
