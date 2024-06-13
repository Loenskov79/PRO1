package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Bane {

    private int nummer;
    private boolean inde;
    private LocalTime førsteTid;
    private LocalTime sidsteTid;
    private Kategori kategori;
    private ArrayList<Booking> bookings = new ArrayList<>();

    public Bane(int nummer, boolean inde, LocalTime førsteTid, LocalTime sidsteTid, Kategori kategori) {
        this.nummer = nummer;
        this.inde = inde;
        this.førsteTid = førsteTid;
        this.sidsteTid = sidsteTid;
        this.kategori = kategori;
    }

    public ArrayList<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public Kategori getKategori() {
        return kategori;
    }

    public int getNummer() {
        return nummer;
    }

    public boolean isInde() {
        return inde;
    }

    public LocalTime getFørsteTid() {
        return førsteTid;
    }

    public LocalTime getSidsteTid() {
        return sidsteTid;
    }

    public void addBooking(Booking booking) {
        if (!bookings.contains(booking)) {
            bookings.add(booking);
            booking.setBane(this);
        }
    }

    public int bookedeTimerPåDato(LocalDate dato) {

        int antalTimer = 0;

        for (Booking b : bookings) {
            if (b.getDato().equals(dato)) {
                antalTimer++;
            }
        }
        return antalTimer;
    }

    public int[] antalBookningerPrTime() {

        int[] frekvens = new int[sidsteTid.getHour() - førsteTid.getHour()];

        for (Booking b : bookings) {
            frekvens[b.getTid().getHour() - førsteTid.getHour()] += 1;
        }
        return frekvens;
    }

    public boolean tidLedig(LocalDate dato, LocalTime tid) {
        boolean ledig = true;

        for (Booking b : bookings) {
            if (b.getDato().equals(dato) && b.getTid().equals(tid)) {
                ledig = false;
            }
        }
        return ledig;
    }

    public String toString() {
        return "Nr: " + nummer + " | Indendørs: " + inde + " | " +
                " | Åbningstid: " + førsteTid + " --> " + sidsteTid + " | Kategori: " + kategori;
    }
}
