package application.model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Tilmelding implements Comparable<Tilmelding>{

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


    public void setTidsperiode(LocalDate start, LocalDate slut){
        if (!start.isBefore(konference.getStart()) && !start.isAfter(konference.getSlut())) {
            this.start = start;
        }
        if (!slut.isAfter(konference.getSlut()) && slut.isAfter(start)) {
            this.slut = slut;
        }
    }

    public Deltager getDeltager() {
        return deltager;
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

    public boolean harLedsager(){
        if (this.ledsager != null){
            return true;
        } else {
            return false;
        }
    }
    public long getAntalDage(){
        return DAYS.between(this.start,this.slut);
    }

    public double getTotalPris(){

        double totalPris = 0;
        long dage = getAntalDage();

        if (booking != null){
            totalPris += booking.getPrisPrDag()*dage;
        }
        if (!deltager.isForedragsholder()){
            totalPris += konference.getPrisPerDag()*(dage+1);
        }
        if (ledsager != null){
            for (Udflugt u : ledsager.getUdflugter()){
                totalPris += u.getPris();
            }
        }

        return totalPris;
    }

    @Override
    public String toString() {
        return deltager.getNavn();
    }

    @Override
    public int compareTo(Tilmelding o) {
        return this.getDeltager().getNavn().compareTo(o.getDeltager().getNavn());
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getSlut() {
        return slut;
    }
}
