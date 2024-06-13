package controller;

import enums.DeltagerStatus;
import model.Deltagelse;
import model.Fag;
import model.Lektion;
import model.Studerende;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Studerende opretStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.tilføjStuderende(studerende);
        return studerende;
    }

    public static Fag opretFag(String navn, String klasse) {
        Fag fag = new Fag(navn, klasse);
        Storage.tilføjFag(fag);
        return fag;
    }

    public static Lektion opretLektion(LocalDate dato, LocalTime startTid, String lokale, Fag fag) {
        Lektion lektion = new Lektion(dato, startTid, lokale, fag);
        return lektion;
    }

    public static void opretDeltagelser(Fag fag, Studerende studerende) {

        for (Lektion l : fag.getLektioner()) {
            studerende.addDeltagelse(l.createDeltagelse(false, DeltagerStatus.TILSTEDE, studerende));
        }

    }

    public static void initStorage() {
        Studerende peter = opretStuderende("Peter Hansen", "ph@stud.dk");
        Studerende tina = opretStuderende("Tina Jensen", "tj@stud.dk");
        Studerende sascha = opretStuderende("Sascha Petersen", "sp@stud.dk");

        Fag pro1 = opretFag("PRO1", "20S");
        Fag pro2 = opretFag("PRO1", "20T");
        Fag su = opretFag("SU1", "20S");

        Lektion lektion1 = opretLektion(LocalDate.of(2021,2,1), LocalTime.of(8,30),"A1.32", pro1);
        Lektion lektion2 = opretLektion(LocalDate.of(2021,2,1), LocalTime.of(10,30),"A1.32", pro1);
        Lektion lektion3 = opretLektion(LocalDate.of(2021,2,3), LocalTime.of(8,30),"A1.32", pro1);
        Lektion lektion4 = opretLektion(LocalDate.of(2021,2,3), LocalTime.of(10,30),"A1.32", pro1);

        opretDeltagelser(pro1, peter);
        opretDeltagelser(pro1, tina);
        opretDeltagelser(pro1, sascha);

        System.out.println(pro1.sygdomPåDato(LocalDate.of(2021, 2, 1)));

    }

    public static ArrayList studerendeTilObservation(int grænse) {
        ArrayList<Studerende> studerendeHøjFravær = new ArrayList<>();

        for (Studerende s : Storage.getStuderende()) {
            if (s.antalFraværsLektioner() > grænse) {
                studerendeHøjFravær.add(s);
            }
        }

        for (int i = 1; i < studerendeHøjFravær.size(); i++) {
            Studerende next = studerendeHøjFravær.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(studerendeHøjFravær.get(j-1)) > 0) {
                    found = true;
                } else {
                    studerendeHøjFravær.set(j, studerendeHøjFravær.get(j-1));
                    j--;
                }
            }
            studerendeHøjFravær.set(j, next);
        }
        return studerendeHøjFravær;
    }

}
