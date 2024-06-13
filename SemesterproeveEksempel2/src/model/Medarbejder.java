package model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Medarbejder {

    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private ArrayList<Vagt> vagter = new ArrayList<>();
    private ArrayList<Funktion> funktioner = new ArrayList<>();

    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    public void addFunktion(Funktion funktion) {
        if (!funktioner.contains(funktion)) {
            funktioner.add(funktion);
        }
    }

    public void removeFunktion(Funktion funktion) {
        if (funktioner.contains(funktion)) {
            funktioner.remove(funktion);
        }
    }

//    public void addVagt(Vagt vagt) {
//        if (!vagter.contains(vagt)) {
//            vagter.add(vagt);
//            vagt.addMedarbejder(this);
//        }
//    }

    public void addVagt(Vagt vagt) {
        try {
            if (!vagter.contains(vagt)) {
                vagter.add(vagt);
                vagt.addMedarbejder(this);
            }
        } catch (RuntimeException e) {
            System.out.println(navn + " har allerede " + vagt + " i dette tidsrum og kan derfor ikke påtage sig en ny.");
        }
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.removeMedarbejder(this);
        }
    }

    public String toString() {
        return navn;
    }
}
