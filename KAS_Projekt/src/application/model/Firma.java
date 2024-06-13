package application.model;

public class Firma {

    private String navn;
    private String tlfNr;
    private Adresse adresse;

    public Firma(String navn, String tlfNr, Adresse adresse) {
        this.navn = navn;
        this.tlfNr = tlfNr;
        this.adresse = adresse;
    }
}
