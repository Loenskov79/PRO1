package application.model;

import java.util.ArrayList;
import java.util.Comparator;

public class Deltager implements Comparable<Deltager> {

    private String navn;
    private Adresse adresse;
    private boolean foredragsholder;
    private String tlfNr;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private Firma firma;

    public Deltager(String navn, boolean foredragsholder, String tlfNr) {
        this.navn = navn;
        this.foredragsholder = foredragsholder;
        this.tlfNr = tlfNr;
        this.firma = firma;
    }

    public String getNavn() {
        return navn;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public Tilmelding opretTilmelding(Konference konference){
        Tilmelding tilmelding = new Tilmelding(konference,this);
        tilmeldinger.add(tilmelding);
        konference.addTilmelding(tilmelding);
        return tilmelding;
    }



    public Firma getFirma() {
        return firma;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    @Override
    public String toString() {
        return navn;
    }

    @Override
    public int compareTo(Deltager o) {
        return this.navn.compareTo(o.navn);
    }
}
