package application.model;

import enumeration.VærelseType;

import java.util.ArrayList;

public class Hotel {

    private String navn;
    private Adresse adresse;
    private int prisPerDag;
    private ArrayList<Tillæg> tillæg;
    private ArrayList<Værelse> værelser = new ArrayList<>();

    public Hotel(String navn, int prisPerDag) {
        this.navn = navn;
        this.prisPerDag = prisPerDag;
    }

    public Værelse createVærelse(VærelseType værelseType) {
        Værelse værelse = new Værelse(værelseType);
        værelser.add(værelse);
        return værelse;
    }

    public ArrayList<Tillæg> getTillæg() {
        return tillæg;
    }
}
