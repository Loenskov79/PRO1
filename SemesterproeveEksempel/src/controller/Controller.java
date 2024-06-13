package controller;

import model.*;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Controller {

    public static Spiller opretSpiller(String navn, String uddannelse) {
        Spiller spiller = new Spiller(navn, uddannelse);
        Storage.tilføjSpiller(spiller);
        return spiller;
    }

    public static Bane opretBane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        Bane bane = new Bane(nummer, inde, førsteTid, sidsteTid, kategori);
        Storage.tilføjBane(bane);
        return bane;
    }

    public static Kategori opretKategori(String navn, int prisKrSingle, int prisKrDouble) {
        Kategori kategori = new Kategori(navn, prisKrSingle, prisKrDouble);
        Storage.tilføjKategori(kategori);
        return kategori;
    }

    public static int samletBooketDoubleTid(String uddannelse, Kategori kategori) {

        int samletTid = 0;

        for (Spiller s : Storage.getSpillere()) {
            if (s.getUddannelse().equals(uddannelse)) {
                for (Booking b : s.getBookings()) {
                    if (!b.isSingle() && b.getBane().getKategori().equals(kategori)) {
                        samletTid++;
                    }
                }
            }
        }
        return samletTid;
    }

    public static void udskrivBookingsAfBaner(String fileName) {

        try {
            PrintWriter printer = new PrintWriter(fileName);

            for (Bane baner : Storage.getBaner()) {
                if (baner.getBookings() != null) {
                    for (Booking bookings : baner.getBookings()) {
                        printer.println("Bane nr: " + baner.getNummer() +
                                ", dag: " + bookings.getDato() +
                                " kl. " + bookings.getTid() +
                                ", spil: " + baner.getKategori() +
                                ", spiller: " + bookings.getSpiller());
                    }
                }
            }
            printer.flush();
            printer.close();
            System.out.println("Filen er blevet lavet!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Bane findLedigBane(LocalDate dato, LocalTime tid, Kategori kategori) {
        Bane bane = null;

        for (Bane b : Storage.getBaner()) {
            if (b.tidLedig(dato, tid) && b.getKategori().equals(kategori)) {
                bane = b;
            }
        }
        return bane;
    }
}
