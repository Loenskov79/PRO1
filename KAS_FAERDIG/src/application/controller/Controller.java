package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Hotel opretHotel(String navn, int dobbeltPris, int singlePris) {
        Hotel hotel = new Hotel(navn,dobbeltPris, singlePris);
        Storage.tilføjHotel(hotel);
        return hotel;
    }

    public static void fjernHotel(Hotel hotel) {
        Storage.fjernHotel(hotel);
    }

    public static Deltager opretDeltager(String navn, boolean foredragsholder, String tlfNr) {
        Deltager deltager = new Deltager(navn, foredragsholder, tlfNr);
        Storage.tilføjDeltager(deltager);
        return deltager;
    }

    public static void fjernDeltager(Deltager deltager) {
        Storage.fjernDeltager(deltager);
    }

    public static Konference opretKonference(String navn, double prisPerDag, String beskrivelse) {
        Konference konference = new Konference(navn, prisPerDag, beskrivelse);
        Storage.tilføjKonference(konference);
        return konference;
    }

    public static void fjernKonference(Konference konference) {
        Storage.fjernKonference(konference);
    }

    public static Firma opretFirma(String navn, String tlfNr, Adresse adresse) {
        Firma firma = new Firma(navn, tlfNr);
        Storage.tilføjFirma(firma);
        return firma;
    }

    public static void sletFirma(Firma firma) {
        Storage.fjernFirma(firma);
    }

    public static Deltager findDeltager(String navn) {
        ArrayList<Deltager> deltagere = Storage.getDeltagere();

        Deltager deltager = null;

        for (Deltager d : deltagere) {
            if (navn.equalsIgnoreCase(d.getNavn())) {
                deltager = d;
            }
        }

        return deltager;
    }

    public static Booking opretBooking(Hotel hotel, boolean harLedsager, Tilmelding tilmelding){
        Booking booking = new Booking(hotel,harLedsager, tilmelding);
        hotel.addBooking(booking);
        return booking;
    }

    public static Ledsager opretLedsager(String navn, Tilmelding tilmelding){
        Ledsager ledsager = new Ledsager(navn,tilmelding);
        tilmelding.setLedsager(ledsager);
        return ledsager;
    }


    public static Udflugt opretUdflugt(int pris, String navn, String beskrivelse, LocalDate localDate, boolean frokost) {
        Udflugt udflugt = new Udflugt(pris,navn,beskrivelse,localDate,frokost);
        return udflugt;
    }
}
