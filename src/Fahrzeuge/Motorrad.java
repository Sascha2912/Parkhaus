package Fahrzeuge;

public class Motorrad extends Fahrzeug{

    public Motorrad(){
        super("Motorrad");
    }

    @Override
    protected String generateKennzeichen() {
        return "MO" + count;
    }

}
