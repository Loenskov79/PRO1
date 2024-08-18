package model;

import java.util.ArrayList;

public class Badge {

    private String beskrivelse;
    private ArrayList<Deltager> deltagere = new ArrayList<>();

    public Badge(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public void addDeltager(Deltager deltager) {
        if (!deltagere.contains(deltager)) {
            deltagere.add(deltager);
            deltager.addBadge(this);
        }
    }

    public void removeDeltager(Deltager deltager) {
        if (deltagere.contains(deltager)) {
            deltagere.remove(deltager);
            deltager.removeBadge(this);
        }
    }

    public Deltager findDeltager() {
        Deltager deltager = null;
        boolean found = false;

            for (Deltager d : deltagere) {
                while (!found) {
                    if (d.getBadges().contains(this)) {
                        deltager = d;
                        found = true;
                    }
                }
            }
        return deltager;
    }

    public String toString() {
        return beskrivelse;
    }
}
