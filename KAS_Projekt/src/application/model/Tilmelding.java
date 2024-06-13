package application.model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Tilmelding {

    private LocalDate start;
    private LocalDate slut;
    private Konference konference;
    private Deltager deltager;
    private Booking booking;
    private Ledsager ledsager;

    public Tilmelding(Konference konference, Deltager deltager) {
        this.konference = konference;
        this.deltager = deltager;
        this.start = konference.getStart();
        this.slut = konference.getSlut();
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public Booking getBooking() {
        return booking;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public boolean harLedsager() {
        if (this.ledsager != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setTidsperiode(LocalDate start, LocalDate slut) {
        if (!start.isBefore(konference.getStart()) && !start.isAfter(konference.getSlut())) {
            this.start = start;
        }
        if (!slut.isAfter(konference.getSlut()) && slut.isAfter(start)) {
            this.slut = slut;
        }
    }

    public long getAntalDage() {
        return DAYS.between(this.start, this.slut);
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public double beregnTotalPris() {
        double pris = 0;
        long antalDage = getAntalDage();

        if (booking != null) {
            pris += booking.beregnPrisPerDag() * antalDage;
        }

        if (!deltager.isForedragsholder()) {
            pris += konference.getPrisPerDag() * (antalDage + 1);
        }

        if (ledsager != null) {
            for (Udflugt u : ledsager.getUdflugter()) {
                pris += u.getPris();
            }
        }
        return pris;
    }

    @Override
    public String toString() {
        return deltager.getNavn() + " til " + konference.getNavn();
    }
}
