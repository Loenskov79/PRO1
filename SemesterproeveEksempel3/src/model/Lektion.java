package model;

import enums.DeltagerStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {

    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Lektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
        fag.addLektion(this);
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public String getLokale() {
        return lokale;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public Deltagelse createDeltagelse(boolean registreret, DeltagerStatus status, Studerende studerende) {
        Deltagelse deltagelse = new Deltagelse(false, DeltagerStatus.TILSTEDE, this, studerende);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse);
        }
    }

    public String toString() {
        return dato + " " + startTid + " " + lokale;
    }
}
