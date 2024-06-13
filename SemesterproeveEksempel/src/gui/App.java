package gui;

import controller.Controller;
import javafx.application.Application;
import model.Bane;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {

    public static void main(String[] args) {
        initStorage();
        Application.launch(MainWindow.class);
    }

    public static void initStorage() {
        Kategori luksus = Controller.opretKategori("Luksus", 100, 200);
        Kategori mellem = Controller.opretKategori("Mellem", 50, 100);
        Kategori begynder = Controller.opretKategori("Begynder", 25, 50);

        Bane bane1 = Controller.opretBane(1, true, LocalTime.of(9,00), LocalTime.of(17,00),luksus);
        Bane bane2 = Controller.opretBane(2, true, LocalTime.of(9,00), LocalTime.of(17,00),luksus);
        Bane bane3 = Controller.opretBane(3, true, LocalTime.of(9,00), LocalTime.of(17,00),mellem);
        Bane bane4 = Controller.opretBane(4, false, LocalTime.of(9,00), LocalTime.of(17,00),mellem);
        Bane bane5 = Controller.opretBane(5, false, LocalTime.of(9,00), LocalTime.of(17,00),begynder);
        Bane bane6 = Controller.opretBane(6, false, LocalTime.of(9,00), LocalTime.of(17,00),begynder);

        Spiller Andreas = Controller.opretSpiller("Andreas", "DMU");
        Spiller Petra = Controller.opretSpiller("Petra", "DMU");
        Spiller Henrik = Controller.opretSpiller("Henrik", "ITA");
        Spiller Ulla = Controller.opretSpiller("Ulla", "ITA");

        Booking b1 = Andreas.createBooking(LocalDate.of(2023,06,20), LocalTime.of(10,00), true, bane3);
        Booking b2 = Andreas.createBooking(LocalDate.of(2023,06,22), LocalTime.of(10,00),false, bane2);
        Booking b3 = Henrik.createBooking(LocalDate.of(2023,06,20), LocalTime.of(11,00),false, bane3);
        Booking b4 = Ulla.createBooking(LocalDate.of(2023,06,20), LocalTime.of(16,00), false, bane3);
        Booking b5 = Ulla.createBooking(LocalDate.of(2023,06,23), LocalTime.of(17,00), true, bane5);

    }

}
