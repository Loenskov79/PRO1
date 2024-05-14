package application.model;

import enumeration.TillægType;

public class Tillæg {

    private TillægType type;
    private double pris;
    private String beskrivelse;

    public Tillæg(TillægType type, double pris, String beskrivelse) {
        this.type = type;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
    }

    public TillægType getType() {
        return type;
    }

    public double getPris() {
        return pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }
}
