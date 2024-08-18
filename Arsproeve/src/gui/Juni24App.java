package gui;

import controller.Controller;
import javafx.application.Application;
import model.Badge;
import model.Deltager;
import model.Hold;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;

public class Juni24App {

    public static void main(String[] args) {
        initStorage();
        Application.launch(MainWindow.class);
    }

    public static void initStorage() {
        Hold cyklisterne = Controller.opretHold("Cyklisterne");
        Hold optimisterne = Controller.opretHold("Optimisterne");

        Deltager anna = Controller.opretDeltager("Anna", "12344321", cyklisterne);
        Deltager ole = Controller.opretDeltager("Ole", "12345678", cyklisterne);
        Deltager per = Controller.opretDeltager("Per", "12341234", cyklisterne);

        ole.createTur(LocalDate.of(2024,05,15), 120, 30);
        ole.createTur(LocalDate.of(2024,05,16), 60, 15);
        per.createTur(LocalDate.of(2024,05,16), 90, 25);

        Badge km25 = Controller.opretBadge("25 km på én dag");
        Badge dage2 = Controller.opretBadge("2 dage i træk");
        Badge hentKollega = Controller.opretBadge("Hent en kollega");

        ole.addBadge(km25);
        ole.addBadge(dage2);
        per.addBadge(km25);

        System.out.println(ole.kmIAlt());
        System.out.println(cyklisterne.deltagerMedFlestKm());
        System.out.println(dage2.findDeltager());
        System.out.println(cyklisterne.holdBadges());

        System.out.println(Arrays.toString(cyklisterne.hurtigeDeltagere(100, 10)));
        System.out.println();
        System.out.println(Controller.deltagerOversigt(cyklisterne));
        Controller.udskrivDeltagerOversigt(cyklisterne, "\\C:\\Users\\VicMan\\Desktop\\udskrivCykelHold.txt\\");

    }

}
