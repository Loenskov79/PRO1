package application.model;

import java.util.ArrayList;

public class Deltager {

    private String navn;
    private Adresse adresse;
    private boolean foredragsholder;
    private String tlfNr;
    private ArrayList<Tilmelding> tilmeldinger;
    private Firma firma;

    public Deltager(String navn, Adresse adresse, boolean foredragsholder, String tlfNr, Firma firma) {
        this.navn = navn;
        this.adresse = adresse;
        this.foredragsholder = foredragsholder;
        this.tlfNr = tlfNr;
        this.firma = firma;
    }
}
