package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private LocalDate dato;
    private LocalTime tid;
    private boolean single;
    private Bane bane;
    private Spiller spiller;

    public Booking(LocalDate dato, LocalTime tid, boolean single, Spiller spiller, Bane bane) {
        this.dato = dato;
        this.tid = tid;
        this.single = single;
        this.spiller = spiller;
        this.bane = bane;
    }

    public void setBane(Bane bane) {
        this.bane = bane;
    }

    public Bane getBane() {
        return bane;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public boolean isSingle() {
        return single;
    }
}
