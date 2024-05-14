package application.model;

import enumeration.TillægType;
import enumeration.VærelseType;

import java.util.ArrayList;

public class Booking {

    private Hotel hotel;
    private ArrayList<Tillæg> valgteTillæg = new ArrayList<>();
    private Værelse værelse;

    public Booking(Hotel hotel, boolean harLedsager) {
        this.hotel = hotel;
        if (harLedsager == true) {
            this.værelse = hotel.getDobbeltværelse();
        } else {
            this.værelse = hotel.getSingleværelse();
        }
    }

    public double beregnPrisPerDag() {
        double pris = 0;
        pris += værelse.getPris();
        for (Tillæg t : valgteTillæg) {
            pris += t.getPris();
        }
        return pris;
    }

    public void tilføjTillæg(Tillæg tillæg) {
        if (hotel.getTillæg().contains(tillæg)) {
            valgteTillæg.add(tillæg);
        }
    }
}
