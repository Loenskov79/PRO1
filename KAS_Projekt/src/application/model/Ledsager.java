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

    public void tilføjUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public Deltager getDeltager() {
        return tilmelding.getDeltager();
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    @Override
    public String toString() {
        return navn;
    }
}
