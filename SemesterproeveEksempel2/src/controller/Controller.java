package controller;

import model.Antal;
import model.Funktion;
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Controller {

    public static Medarbejder opretMedarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        Medarbejder medarbejder = new Medarbejder(navn, antalTimerPrDag, typiskMødetid);
        Storage.tilføjMedarbejder(medarbejder);
        return medarbejder;
    }

    public static Vagt opretVagt(String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        Vagt vagt = new Vagt(navn, tidFra, tidTil);
        Storage.tilføjVagt(vagt);
        return vagt;
    }

    public static Funktion opretFunktion(String navn) {
        Funktion funktion = new Funktion(navn);
        Storage.tilføjFunktion(funktion);
        return funktion;
    }

    public static void udskrivVagtplan(Vagt vagt, String fileName) {

        try {
            PrintWriter printer = new PrintWriter(fileName);

            printer.println("------------------------------------------------\n " +
                    vagt.getTidFra() + " (" + vagt + ")\n" +
                    "------------------------------------------------\n\n" +
                    "Funktioner:\n " +
                    "Filetrering(" + vagt.getAntals() +
                    "Medarbejdere: " + vagt.getMedarbejdere().toString() + "\n" +
                    "Status: " + vagt.status());

            printer.flush();
            printer.close();
            System.out.println("Filen er blevet lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
