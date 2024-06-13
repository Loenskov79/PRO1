package application.model;

public class Firma {

    private String navn;
    private String tlfNr;
    private Adresse adresse;

    public Firma(String navn, String tlfNr) {
        this.navn = navn;
        this.tlfNr = tlfNr;
        this.adresse = adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
}
