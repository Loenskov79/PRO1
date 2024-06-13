package application.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit.*;

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
        this.adresse = adresse;
        this.prisPerDag = prisPerDag;
        this.beskrivelse = beskrivelse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    public void setTidsperiode(LocalDate start, LocalDate slut) {
        this.start = start;
        this.slut = slut;
    }

    public long getAntalDage(){
        return DAYS.between(this.start,this.slut);
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getSlut() {
        return slut;
    }

    public void addTilmelding(Tilmelding tilmelding){
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
        }
    }

    public ArrayList<Tilmelding> getTilmeldinger(){
        return new ArrayList<>(tilmeldinger);
    }

    public Udflugt opretUdflugt(int pris, String navn, String beskrivelse, LocalDate dato, boolean frokost){
        Udflugt udflugt = new Udflugt(pris, navn, beskrivelse, dato, frokost);
        udflugter.add(udflugt);
        //Ledsager.
        return udflugt;
    }

    public String getNavn() {
        return navn;
    }

    public double getPrisPerDag() {
        return prisPerDag;
    }

    @Override
    public String toString() {
        return navn;
    }

    public void addHotel(Hotel hotel){
        if (!hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public void setUdflugt(Udflugt u) {
        udflugter.add(u);
    }

    public ArrayList<Deltager> getDeltagere(){
        ArrayList<Deltager> deltagere = new ArrayList<>();

        for (Tilmelding t : tilmeldinger){
            deltagere.add(t.getDeltager());
        }
        return deltagere;
    }

}
