package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Konference {

    private String navn;
    private LocalDate tidsperiode;
    private Adresse adresse;
    private double prisPerDag;
    private String beskrivelse;
    private ArrayList<Tilmelding> tilmeldinger;
    private ArrayList<Udflugt> udflugter;
    private ArrayList<Hotel> hoteller;

    public Konference(String navn, Adresse adresse, double prisPerDag, String beskrivelse) {
        this.navn = navn;
        this.adresse = adresse;
        this.prisPerDag = prisPerDag;
        this.beskrivelse = beskrivelse;
    }
}
