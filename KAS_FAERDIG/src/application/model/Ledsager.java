package application.model;

import java.util.ArrayList;

public class Ledsager {

    private String navn;
    private Tilmelding tilmelding;
    private ArrayList<Udflugt> udflugter = new ArrayList<>();

    public Ledsager(String navn, Tilmelding tilmelding) {
        this.navn = navn;
        this.tilmelding = tilmelding;
    }

    public Ledsager(String navn){
        this.navn = navn;
    }

    public void addUdflugt(Udflugt udflugt){
        udflugter.add(udflugt);
    }

    public Deltager getDeltager(){
        return tilmelding.getDeltager();
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    @Override
    public String toString() {
        return navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setTilmelding(Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
    }

    public Tilmelding getTilmelding() {
        return tilmelding;
    }
}
