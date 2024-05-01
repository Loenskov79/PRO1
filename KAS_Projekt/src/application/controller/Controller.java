package application.controller;

import application.model.*;
import storage.Storage;

public class Controller {

    public static Hotel opretHotel(String navn, int pris) {
        Hotel hotel = new Hotel(navn, pris);
        Storage.tilføjHotel(hotel);
        return hotel;
    }

    public static void fjernHotel(Hotel hotel) {
        Storage.fjernHotel(hotel);
    }

    public static Deltager opretDeltager(String navn, Adresse adresse, boolean foredragsholder, String tlfNr, Firma firma) {
        Deltager deltager = new Deltager(navn, adresse, foredragsholder, tlfNr, firma);
        Storage.tilføjDeltager(deltager);
        return deltager;
    }

    public static void fjernDeltager(Deltager deltager) {
        Storage.fjernDeltager(deltager);
    }

    public static Konference opretKonference(String navn, Adresse adresse, double prisPerDag, String beskrivelse) {
        Konference konference = new Konference(navn, adresse, prisPerDag, beskrivelse);
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

    public static void sletFirma(Firma firma) {
        Storage.fjernFirma(firma);
    }

    public static Deltager findDeltager() {
        Storage.getDeltagere();
        //TODO
        return null;
    }


}
