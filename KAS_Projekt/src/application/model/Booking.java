package application.model;

import enumeration.TillægType;
import enumeration.VærelseType;

import java.util.ArrayList;

public class Booking {

    private Hotel hotel;
    private ArrayList<Tillæg> tillæg;
    private Værelse værelse;

    public Booking(Hotel hotel, boolean harLedsager) {
        this.hotel = hotel;
        if (harLedsager == true) {
            this.værelse = hotel.createVærelse(VærelseType.DOBBELT);
        } else {
            this.værelse = hotel.createVærelse(VærelseType.SINGLE);
        }
    }

    public double beregnPris() {
        double pris = 0;
        //TODO
        return pris;
    }

    public void addTillæg(TillægType type, double pris, String beskrivelse) {
        Tillæg tillæg = new Tillæg(type, pris, beskrivelse);
        //TODO
    }
}
