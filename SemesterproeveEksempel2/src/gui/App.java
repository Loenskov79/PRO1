package gui;

import controller.Controller;
import javafx.application.Application;
import model.Funktion;
import model.Medarbejder;
import model.Vagt;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class App {

    public static void main(String[] args) {
        initStorage();
        Application.launch(MainWindow.class);
    }

    public static void initStorage() {
        Funktion filetering = Controller.opretFunktion("Filetering");
        Funktion grøntsager = Controller.opretFunktion("Grøntsager");
        Funktion sovsOgTilbehør = Controller.opretFunktion("Sovs og tilbehør");
        Funktion buffetopfyldning = Controller.opretFunktion("Buffetopfyldning");

        Medarbejder peter = Controller.opretMedarbejder("Peter", 6, LocalTime.of(8,00));
        Medarbejder anne = Controller.opretMedarbejder("Anne", 8, LocalTime.of(8,00));
        Medarbejder marie = Controller.opretMedarbejder("Marie", 6, LocalTime.of(10,00));
        Medarbejder torben = Controller.opretMedarbejder("Torben", 8, LocalTime.of(7,00));

        Vagt røgedeÅl = Controller.opretVagt("Røgede ål til medarbejderne", LocalDateTime.of(2022,06,24,8,00), LocalDateTime.of(2022,06,24,12,30));

        røgedeÅl.createAntal(2,filetering);
        røgedeÅl.createAntal(1,grøntsager);
        røgedeÅl.createAntal(1,sovsOgTilbehør);
        røgedeÅl.createAntal(1,buffetopfyldning);

        peter.addVagt(røgedeÅl);
        anne.addVagt(røgedeÅl);
        marie.addVagt(røgedeÅl);

        peter.addFunktion(grøntsager);
        peter.addFunktion(sovsOgTilbehør);
        peter.addFunktion(buffetopfyldning);

        anne.addFunktion(grøntsager);
        anne.addFunktion(sovsOgTilbehør);
        anne.addFunktion(buffetopfyldning);

        marie.addFunktion(filetering);
        marie.addFunktion(grøntsager);
        marie.addFunktion(buffetopfyldning);

        torben.addFunktion(filetering);
        torben.addFunktion(sovsOgTilbehør);
    }

}
