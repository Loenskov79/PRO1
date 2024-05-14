package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Konference {

    private String navn;
    private LocalDate start;
    private LocalDate slut;
    private Adresse adresse;
    private double prisPerDag;
    private String beskrivelse;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<Hotel> hoteller = new ArrayList<>();

    public Konference(String navn, double prisPerDag, String beskrivelse) {
        this.navn = navn;
        this.prisPerDag = prisPerDag;
        this.beskrivelse = beskrivelse;
    }

    public void addHotel(Hotel hotel) {
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setTidsperiode(LocalDate start, LocalDate slut) {
        this.start = start;
        this.slut = slut;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return udflugter;
    }

    public void setUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public ArrayList<Hotel> getHoteller() {
        return hoteller;
    }

    public double getPrisPerDag() {
        return prisPerDag;
    }

    public long getAntalDage() {
        return DAYS.between(this.start, this.slut);
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getSlut() {
        return slut;
    }

    public String getNavn() {
        return navn;
    }

    public void tilføjTilmelding(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    public Udflugt opretUdflugt(int pris, String navn, String beskrivelse, LocalDate dato, boolean frokost) {
        Udflugt udflugt = new Udflugt(pris, navn, beskrivelse, dato, frokost);
        udflugter.add(udflugt);
        return udflugt;
    }

    @Override
    public String toString() {
        return navn;
    }

}
