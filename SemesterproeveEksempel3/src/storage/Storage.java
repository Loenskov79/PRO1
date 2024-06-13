package storage;

import model.Fag;
import model.Studerende;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Fag> fags = new ArrayList<>();
    private static ArrayList<Studerende> studerendes = new ArrayList<>();

    public static ArrayList<Fag> getFag() {
        return new ArrayList<>(fags);
    }

    public static ArrayList<Studerende> getStuderende() {
        return new ArrayList<>(studerendes);
    }

    public static void tilføjFag(Fag fag) {
        fags.add(fag);
    }

    public static void tilføjStuderende(Studerende studerende) {
        studerendes.add(studerende);
    }
}
