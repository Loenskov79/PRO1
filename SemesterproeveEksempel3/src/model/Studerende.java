package model;

import java.util.ArrayList;

public class Studerende implements Comparable<Studerende>{

    private String navn;
    private String email;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return deltagelser;
    }

    public void addDeltagelse(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
        }
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse);
        }
    }

    public int antalFraværsLektioner() {
        int antalTimerFraværende = 0;
        for (Deltagelse d : deltagelser) {
            if (d.erRegistreretFraværende()) {
                antalTimerFraværende++;
            }
        }
        return antalTimerFraværende;
    }

    @Override
    public int compareTo(Studerende o) {
        return this.getNavn().compareTo(o.getNavn());
    }
}
