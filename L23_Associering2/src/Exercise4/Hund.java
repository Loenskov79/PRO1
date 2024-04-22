package Exercise4;

import java.util.ArrayList;

public class Hund {

    private String navn;
    private boolean stamtavle;
    private int pris;
    private Race race;

    public Hund(String navn, boolean stamtavle, int pris, Race race) {
        this.navn = navn;
        this.stamtavle = stamtavle;
        this.pris = pris;
        this.race = race;
    }

    public int getPris() {
        return pris;
    }

    public String getNavn() {
        return navn;
    }

    public boolean isStamtavle() {
        return stamtavle;
    }

    public Race getRace() {
        return race;
    }

    public String toString() {
        return "Navn: " + navn + " | Race: " + race + " | Pris: " + pris + " | Stamtavle: " + stamtavle;
    }
}
