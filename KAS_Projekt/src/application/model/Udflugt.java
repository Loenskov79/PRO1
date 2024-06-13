package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Udflugt {

    private int pris;
    private String navn;
    private String beskrivelse;
    private LocalDate dato;
    private boolean frokost;
    private ArrayList<Ledsager> deltagere;

    public Udflugt(int pris, String navn, String beskrivelse, LocalDate dato, boolean frokost) {
        this.pris = pris;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.frokost = frokost;
    }

    public ArrayList<Ledsager> getDeltagere() {
        return deltagere;
    }

    public int getPris() {
        return pris;
    }

    public void tilføjDeltagerTilUdflugt(Ledsager ledsager) {
        if (!deltagere.contains(ledsager)) {
            deltagere.add(ledsager);
        }
        ledsager.tilføjUdflugt(this);
    }

    @Override
    public String toString() {
        return navn + " | " + dato;
    }
}
