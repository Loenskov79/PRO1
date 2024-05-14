package application.controller;

import application.model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Udflugt opretUdflugt(int pris, String navn, String beskrivelse, LocalDate dato, boolean frokost) {
        Udflugt udflugt = new Udflugt(pris, navn, beskrivelse, dato, frokost);
        return udflugt;
    }

    public static Hotel opretHotel(String navn, int dobbeltpris, int singlepris) {
        Hotel hotel = new Hotel(navn, dobbeltpris, singlepris);
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
        Firma firma = new Firma(navn, tlfNr, adresse);
        Storage.tilføjFirma(firma);
        return firma;
    }

    public static void fjernFirma(Firma firma) {
        Storage.fjernFirma(firma);
    }

    public static Booking opretBooking(Hotel hotel, boolean harLedsager, Tilmelding tilmelding) {
        Booking booking = new Booking(hotel, harLedsager);
        tilmelding.setBooking(booking);
        return booking;
    }

    public static Ledsager opretLedsager(String navn, Tilmelding tilmelding) {
        Ledsager ledsager = new Ledsager(navn, tilmelding);
        tilmelding.setLedsager(ledsager);
        return ledsager;
    }

    public static Deltager findDeltager(String navn) {
        ArrayList<Deltager> deltagere = Storage.getDeltagere();

        Deltager deltager = null;

        for (Deltager d : deltagere) {
            if (navn.equalsIgnoreCase(d.getNavn()));
            deltager = d;
        }
        return deltager;
    }
}
