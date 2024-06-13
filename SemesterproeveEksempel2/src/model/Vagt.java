package model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Vagt {

    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;
    private ArrayList<Antal> antals = new ArrayList<>();
    private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidTil;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidTil() {
        return tidTil;
    }

    public ArrayList<Antal> getAntals() {
        return new ArrayList<>(antals);
    }

    public ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejdere.contains(medarbejder)) {
            medarbejdere.add(medarbejder);
            medarbejder.addVagt(this);
        }
    }

    public void removeMedarbejder(Medarbejder medarbejder) {
        if (medarbejdere.contains(medarbejder)) {
            medarbejdere.remove(medarbejder);
            medarbejder.removeVagt(this);
        }
    }

    public Antal createAntal(int antal, Funktion funktion) {
        Antal newAntal = new Antal(antal, funktion);
        antals.add(newAntal);
        return newAntal;
    }

    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        Medarbejder medarbejder = null;

        for (Medarbejder m : medarbejdere) {
            if (m.getTypiskMødetid().equals(tidspunkt) && m.getAntalTimerPrDag() >= antalTimer) {
                medarbejder = m;
            }
        }
        return medarbejder;
    }

    public int beregnTimeforbrug() {
        int samletTid = 0;

        for (Medarbejder m : medarbejdere) {
            samletTid += m.getAntalTimerPrDag();
        }

        return samletTid;
    }

    public int antalMedarbejdereMedFunktion(Funktion funktion) {
        int antal = 0;

        for (Medarbejder m : medarbejdere) {
            if (m.getFunktioner().contains(funktion)) {
                antal++;
            }
        }
        return antal;
    }

    public Medarbejder[] skalAdviseresOmMødetid() {
        Medarbejder[] medarbejders = new Medarbejder[medarbejdere.size()];

        for (int i = 0; i < medarbejdere.size(); i++) {
            if (medarbejdere.get(i).getTypiskMødetid().getHour() > this.tidFra.getHour()) {
                medarbejders[i] = medarbejdere.get(i);
            }
        }

        return medarbejders;
    }

    public String status() {
        String s = "";
        int i = 0;

        while (i < medarbejdere.size()) {
            if (this.antalMedarbejdereMedFunktion(this.getAntals().get(i).getFunktion()) >= this.getAntals().size()) {
                s = "Ressourcer tildelt";
            } else {
                s = "Manglende ressourcer";
            }
            i++;
        }
        return s;
    }

    public String status2() {
        String s = "";
        boolean opnået = false;

        for (Antal a : antals) {
            int mål = a.getAntal();
            int i = 0;
            for (Medarbejder m : medarbejdere) {
                for (Funktion f : m.getFunktioner()) {
                    if (f == a.getFunktion()) {
                        i++;
                    }
                }
            }
            if (i >= mål) {
                opnået = true;
            }
        }
        return s;
    }

    public String toString() {
        return navn;
    }

}
