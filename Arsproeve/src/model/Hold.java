package model;

import storage.Storage;

import java.util.ArrayList;

public class Hold {

    private String navn;
    private ArrayList<Deltager> deltagere = new ArrayList<>();

    public Hold(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public void addDeltager(Deltager deltager) {
        if (!deltagere.contains(deltager)) {
            deltagere.add(deltager);
        }
    }

    public void removeDeltager(Deltager deltager) {
        if (deltagere.contains(deltager)) {
            deltagere.remove(deltager);
        }
    }

    public Deltager deltagerMedFlestKm() {
        Deltager deltager = null;
        int antalKm = 0;

        for (Deltager d : deltagere) {
            if (d.kmIAlt() > antalKm) {
                deltager = d;
                antalKm = deltager.kmIAlt();
            }
        }

        return deltager;
    }

    public ArrayList holdBadges() {
        ArrayList<Badge> alleBadgesPåHold = new ArrayList<>();

        for (Deltager d : deltagere) {
            for (Badge b : d.getBadges()) {
                if (!alleBadgesPåHold.contains(b)) {
                    alleBadgesPåHold.add(b);
                }
            }
        }
        return alleBadgesPåHold;
    }

    public Deltager[] hurtigeDeltagere(int minutMax, int kmMin) {
        ArrayList<Deltager> hurtigeDeltagere = new ArrayList<>();


        for (Deltager d : deltagere) {
            for (Tur t : d.getTure()) {
                if (t.getAntalKm() >= kmMin && t.getAntalMinutter() <= minutMax && !hurtigeDeltagere.contains(d)) {
                    hurtigeDeltagere.add(d);
                }
            }
        }

        Deltager[] hurtigeDeltagereFærdig = new Deltager[hurtigeDeltagere.size()];
        for (int i = 0; i < hurtigeDeltagere.size(); i++) {
            hurtigeDeltagereFærdig[i] = hurtigeDeltagere.get(i);
        }

        return hurtigeDeltagereFærdig;
    }

    public String toString() {
        return navn;
    }
}
