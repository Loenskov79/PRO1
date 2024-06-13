package application.model;

import enumeration.VærelseType;

public class Værelse {

    private VærelseType type;
    private double pris;

    public Værelse(VærelseType type, int pris) {
        this.type = type;
        this.pris = pris;
    }

    public void setType(VærelseType type) {
        this.type = type;
    }

    public double getPris(){
        return pris;
    }

    public VærelseType getType() {
        return type;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
}
