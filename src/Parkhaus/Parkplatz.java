package Parkhaus;

public class Parkplatz{

    private String id;
    private boolean frei;

    public Parkplatz(String id){
        this.frei = true;
    }

    public String getId(){
        return this.id;
    }
    public boolean istFrei(){
        return this.frei;
    }
    public void belegen(){
        this.frei = false;
    }
    public void freigeben(){
        this.frei = true;
    }

}
