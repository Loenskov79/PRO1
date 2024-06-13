package storage;

import model.Funktion;
import model.Medarbejder;
import model.Vagt;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Funktion> funktioner = new ArrayList<>();
    private static ArrayList<Medarbejder> medarbejdere = new ArrayList<>();
    private static ArrayList<Vagt> vagter = new ArrayList<>();

    public static ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    public static ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    public static ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public static void tilføjFunktion(Funktion funktion) {
        funktioner.add(funktion);
    }

    public static void tilføjMedarbejder(Medarbejder medarbejder) {
        medarbejdere.add(medarbejder);
    }

    public static void tilføjVagt(Vagt vagt) {
        vagter.add(vagt);
    }
}
