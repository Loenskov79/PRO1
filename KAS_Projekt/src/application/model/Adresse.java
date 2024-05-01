package application.model;

public class Adresse {

    private String vejnavn;
    private int vejnr;
    private int postnr;
    private String by;
    private String land;

    public Adresse(String vejnavn, int vejnr, int postnr, String by, String land) {
        this.vejnavn = vejnavn;
        this.vejnr = vejnr;
        this.postnr = postnr;
        this.by = by;
        this.land = land;
    }

    @Override
    public String toString() {
        return vejnavn + " " + vejnr + "\n" + postnr + "\n" + by + "\n" + land;
    }
}
