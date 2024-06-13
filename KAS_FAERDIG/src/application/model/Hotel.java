package application.model;

import enumeration.TillægType;
import enumeration.VærelseType;

import java.util.ArrayList;

public class Hotel {

    private String navn;
    private Adresse adresse;
    private ArrayList<Tillæg> tillæg = new ArrayList<>();
    private Værelse dobbeltVærelse;
    private Værelse singleVærelse;
    private ArrayList<Booking> bookings = new ArrayList<>();

    public Hotel(String navn, int dobbeltPris, int singlePris) {
        this.navn = navn;
        createVærelse(VærelseType.DOBBELT,dobbeltPris);
        createVærelse(VærelseType.SINGLE,singlePris);
    }

    public Værelse createVærelse(VærelseType værelseType, int pris) {
        Værelse værelse = new Værelse(værelseType,pris);
        if (værelseType == VærelseType.DOBBELT){
            værelse = new Værelse(værelseType,pris);
            this.dobbeltVærelse = værelse;
        } else {
            værelse = new Værelse(værelseType,pris);
            this.singleVærelse = værelse;
        }
        return værelse;
    }

    public Værelse getDobbeltVærelse() {
        return dobbeltVærelse;
    }

    public Værelse getSingleVærelse() {
        return singleVærelse;
    }

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(tillæg);
    }

    public Tillæg opretTillæg(TillægType type, double pris, String beskrivelse){
        Tillæg t = new Tillæg(type,pris,beskrivelse);
        tillæg.add(t);
        return t;
    }

    @Override
    public String toString() {
        return navn;
    }

    public String getNavn() {
        return navn;
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    public ArrayList<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }
}
