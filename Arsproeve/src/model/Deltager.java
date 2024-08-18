package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Deltager implements Comparable<Deltager> {

    private String navn;
    private String mobil;
    private ArrayList<Badge> badges = new ArrayList<>();
    private ArrayList<Tur> ture = new ArrayList<>();

    public Deltager(String navn, String mobil, Hold hold) {
        this.navn = navn;
        this.mobil = mobil;
        hold.addDeltager(this);
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public ArrayList<Badge> getBadges() {
        return new ArrayList<>(badges);
    }

    public ArrayList<Tur> getTure() {
        return new ArrayList<>(ture);
    }

    public Tur createTur(LocalDate dato, int antalMinutter, int antalKm) {
        Tur tur = new Tur(dato, antalMinutter, antalKm, this);
        ture.add(tur);
        return tur;
    }

    public void removeTur(Tur tur) {
        if (ture.contains(tur)) {
            ture.remove(tur);
        }
    }

    public void addBadge(Badge badge) {
        if (!badges.contains(badge)) {
            badges.add(badge);
            badge.addDeltager(this);
        }
    }

    public void removeBadge(Badge badge) {
        if (badges.contains(badge)) {
            badges.remove(badge);
            badge.removeDeltager(this);
        }
    }

    public int kmIAlt() {
        int antalKm = 0;

        for (Tur t : ture) {
            antalKm += t.getAntalKm();
        }

        return antalKm;
    }

    public String toString() {
        return navn + ", mobil: " + mobil;
    }

    @Override
    public int compareTo(Deltager o) {
        return o.kmIAlt() - this.kmIAlt();
    }
}
