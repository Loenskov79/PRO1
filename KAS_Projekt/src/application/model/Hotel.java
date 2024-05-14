package application.model;

import enumeration.TillægType;
import enumeration.VærelseType;

import java.util.ArrayList;

public class Hotel {

    private String navn;
    private Adresse adresse;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();
    private Værelse dobbeltværelse;
    private Værelse singleværelse;

    public Hotel(String navn, int dobbeltpris, int singlepris) {
        this.navn = navn;
        opretVærelse(VærelseType.DOBBELT,dobbeltpris);
        opretVærelse(VærelseType.SINGLE,singlepris);
    }

    public Værelse opretVærelse(VærelseType værelseType, int pris) {
        Værelse værelse = new Værelse(værelseType, pris);
        if (værelseType == VærelseType.DOBBELT) {
            værelse = new Værelse(værelseType,pris);
            this.dobbeltværelse = værelse;
        } else {
            værelse = new Værelse(værelseType,pris);
            this.singleværelse = værelse;
        }
        return værelse;
    }

    public Tillæg opretTillæg(TillægType type, double pris, String beskrivelse) {
        Tillæg t = new Tillæg(type, pris, beskrivelse);
        tillæg.add(t);
        return t;
    }

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    public Værelse getDobbeltværelse() {
        return dobbeltværelse;
    }

    public Værelse getSingleværelse() {
        return singleværelse;
    }

    public String toString() {
        return navn;
    }
}
