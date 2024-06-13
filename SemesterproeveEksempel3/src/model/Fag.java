package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {

    private String navn;
    private String klasse;
    private ArrayList<Lektion> lektioner = new ArrayList<>();

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
    }

    public String getNavn() {
        return navn;
    }

    public String getKlasse() {
        return klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return lektioner;
    }

    public void addLektion(Lektion lektion) {
        if (!lektioner.contains(lektion)) {
            lektioner.add(lektion);
        }
    }

    public void removeLektion(Lektion lektion) {
        if (lektioner.contains(lektion)) {
            lektioner.remove(lektion);
        }
    }

    public ArrayList sygdomPåDato(LocalDate dato) {
        ArrayList<Deltagelse> sygeStuderende = new ArrayList<>();

        for (Lektion l : lektioner) {
            if (l.getDato() == dato) {
                for (Deltagelse d : l.getDeltagelser()) {
                    if (d.erRegistreretFraværende()) {
                        sygeStuderende.add(d);
                    }
                }
            }
        }
        return sygeStuderende;
    }

    public Lektion mestFravær() {
        Lektion lektion = null;
        int max = 0;

        for (Lektion l : lektioner) {
            for (Deltagelse d : l.getDeltagelser()) {
                int fravær = 0;
                if (d.erRegistreretFraværende() == true) {
                    fravær++;
                }
                if (fravær > max) {
                    lektion = l;
                }
            }
        }
        return lektion;
    }

    public String toString() {
        return navn + " " + klasse;
    }
}
