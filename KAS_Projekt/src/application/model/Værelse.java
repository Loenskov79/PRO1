package application.model;

import enumeration.VærelseType;

public class Værelse {

    private VærelseType type;
    private double pris;

    public Værelse(VærelseType type) {
        this.type = type;
    }

    public void setType(VærelseType type) {
        this.type = type;
    }
}
