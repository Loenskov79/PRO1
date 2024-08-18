package controller;

import model.Badge;
import model.Deltager;
import model.Hold;
import model.Tur;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Hold opretHold(String navn) {
        Hold hold = new Hold(navn);
        Storage.tilføjHold(hold);
        return hold;
    }

    public static Deltager opretDeltager(String navn, String mobil, Hold hold) {
        Deltager deltager = new Deltager(navn, mobil, hold);
        return deltager;
    }

    public static Tur opretTur(LocalDate dato, int antalMinutter, int antalKm, Deltager deltager) {
        Tur tur = new Tur(dato, antalMinutter, antalKm, deltager);
        return tur;
    }

    public static Badge opretBadge(String beskrivelse) {
        Badge badge = new Badge(beskrivelse);
        Storage.tilføjBadge(badge);
        return badge;
    }

    public static String deltagerOversigt(Hold hold) {
        String str = "";

        for (Hold h : Storage.getHold()) {
            for (Deltager d : h.getDeltagere()) {
                if (d.getBadges().size() == 0) {
                    str += str += d.getNavn() + " " + d.getMobil() + ", " + d.kmIAlt() + " km, badges: - ingen badges -\n";
                } else {
                    str += d.getNavn() + " " + d.getMobil() + ", " + d.kmIAlt() + " km, badges: " +
                            d.getBadges() + "\n";
                }
            }
        }
        return str;
    }

    public static void udskrivDeltagerOversigt(Hold hold, String fileName) {

        ArrayList<Deltager> sorteretDeltagerArray = new ArrayList<>();

        for (Hold h : Storage.getHold()) {
            for (Deltager d : h.getDeltagere()) {
                sorteretDeltagerArray.add(d);
            }
        }

        for (int i = 1; i < sorteretDeltagerArray.size(); i++) {
            Deltager next = sorteretDeltagerArray.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(sorteretDeltagerArray.get(j-1)) > 0) {
                    found = true;
                } else {
                    sorteretDeltagerArray.set(j, sorteretDeltagerArray.get(j-1));
                    j--;
                }
            }
            sorteretDeltagerArray.set(j, next);
        }

        try {
            PrintWriter printer = new PrintWriter(fileName);

            for (int i = 0; i < sorteretDeltagerArray.size(); i++) {
                Deltager d = sorteretDeltagerArray.get(i);
                if (d.getBadges().size() > 0) {
                    printer.println(d + ", " + d.kmIAlt() + " km, badges: " + d.getBadges() + "\n");
                } else {
                    printer.println(d + ", " + d.kmIAlt() + " km, badges: - ingen badges -\n");
                }
            }
            printer.flush();
            printer.close();
            System.out.println("Filen er blevet lavet");
        } catch (IOException e) {
            System.out.println("Filen kunne ikke printes");
        }
    }

}
