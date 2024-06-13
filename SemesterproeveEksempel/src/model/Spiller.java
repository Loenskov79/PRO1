package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Spiller {

    private String navn;
    private String uddannelse;
    private ArrayList<Booking> bookings = new ArrayList<>();

    public Spiller(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    public ArrayList<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    public Booking createBooking(LocalDate dato, LocalTime tid, boolean single, Bane bane) {
        Booking booking = new Booking(dato, tid, single, this, bane);
        bookings.add(booking);
        bane.addBooking(booking);
        return booking;
    }

    public int samletPris(Kategori kategori) {
        int sum = 0;

        for (Booking b : bookings) {
            if (b.getBane().getKategori().equals(kategori)) {
                if (b.isSingle() == true) {
                    sum += b.getBane().getKategori().getPrisKrSingle();
                } else {
                    sum += b.getBane().getKategori().getPrisKrDouble();
                }
            }
        }
        return sum;
    }

    public String toString() {
        return navn + " (" + uddannelse + ")";
    }
}
