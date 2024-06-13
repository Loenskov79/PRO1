package storage;

import application.model.*;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Firma> firmaer = new ArrayList<>();

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<Hotel>(hoteller);
    }

    public static void tilføjHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public static void fjernHotel(Hotel hotel) {
        hoteller.remove(hotel);
    }

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<Deltager>(deltagere);
    }

    public static void tilføjDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void fjernDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<Konference>(konferencer);
    }

    public static void tilføjKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void fjernKonference(Konference konference) {
        konferencer.remove(konference);
    }

    public static ArrayList<Firma> getFirmaer() {
        return new ArrayList<Firma>(firmaer);
    }

    public static void tilføjFirma(Firma firma) {
        firmaer.add(firma);
    }

    public static void fjernFirma(Firma firma) {
        firmaer.remove(firma);
    }
}
