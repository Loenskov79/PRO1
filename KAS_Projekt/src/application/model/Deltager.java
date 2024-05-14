package application.model;

import storage.Storage;

import java.util.ArrayList;

public class Deltager {

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
        return tilmeldinger;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Tilmelding opretTilmelding(Konference konference) {
        Tilmelding tilmelding = new Tilmelding(konference, this);
        tilmeldinger.add(tilmelding);
        konference.tilføjTilmelding(tilmelding);
        return tilmelding;
    }

    @Override
    public String toString() {
        return navn;
    }
}
