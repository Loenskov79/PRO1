package application.model;

import enumeration.TillægType;
import enumeration.VærelseType;

import java.util.ArrayList;

public class Booking {

    private Hotel hotel;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();
    private Værelse værelse;
    private Tilmelding tilmelding;

    public Booking(Hotel hotel, boolean harLedsager, Tilmelding tilmelding) {
        this.hotel = hotel;
        this.tilmelding = tilmelding;
        if (harLedsager == true){
            this.værelse = hotel.getDobbeltVærelse();
        } else {
            this.værelse = hotel.getSingleVærelse();
        }

    }

    public double getPrisPrDag() {
        double pris = 0;

        pris += værelse.getPris();

        for (Tillæg t : tillæg){
            pris += t.getPris();
        }

        return pris;
    }

    public void addTillæg(Tillæg tillæg) {
        if (hotel.getTillæg().contains(tillæg)){
            this.tillæg.add(tillæg);
        }
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Tilmelding getTilmelding() {
        return tilmelding;
    }
}
