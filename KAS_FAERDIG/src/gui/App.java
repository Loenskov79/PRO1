package gui;

import application.controller.Controller;
import application.model.Deltager;
import application.model.Konference;
import application.model.*;
import enumeration.TillægType;
import javafx.application.Application;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(StartWindow.class);
    }

    public static void initStorage(){
        Konference havHimmel = Controller.opretKonference("Hav og Himmel",1500,"Konference om vand osv");
        havHimmel.setTidsperiode(LocalDate.of(2024,06,03),LocalDate.of(2024,06,05));

        Deltager finn = Controller.opretDeltager("Finn Madsen",false,"12345678");
        Deltager niels = Controller.opretDeltager("Niels Petersen",false,"12345678");
        Deltager peter = Controller.opretDeltager("Peter Sommer",false,"12345678");
        Deltager lone = Controller.opretDeltager("Lone Jensen",true,"12345678");


        Hotel denHvideSvane = Controller.opretHotel("Den Hvide Svane",1250,1050);
        Hotel phønix = Controller.opretHotel("Phønix",800,700);
        Tillæg wifi = denHvideSvane.opretTillæg(TillægType.WIFI,50,"Fri WIFI");
        Tillæg bad = phønix.opretTillæg(TillægType.BAD,200,"Luksus Bad");
        Tillæg wiFi = phønix.opretTillæg(TillægType.WIFI,75,"Fri WIFI");
        Hotel tusindfryd = Controller.opretHotel("Pension Tusindfryd",600,500);
        Tillæg mad = tusindfryd.opretTillæg(TillægType.MORGENMAD,100,"Morgenmad");

        havHimmel.addHotel(denHvideSvane);
        havHimmel.addHotel(phønix);
        havHimmel.addHotel(tusindfryd);

        Udflugt egeskov = havHimmel.opretUdflugt(75,"Egeskov","tur i skoven",LocalDate.of(2024,06,04),false);
        Udflugt trapholt = havHimmel.opretUdflugt(200,"Trapholt Museum","tur på musem",LocalDate.of(2024,06,05),true);
        Udflugt odense = havHimmel.opretUdflugt(125,"Byrundtur, Odense","tur i byen",LocalDate.of(2024,06,03),true);

        Tilmelding tFinn = finn.opretTilmelding(havHimmel);
        Booking bFinn = Controller.opretBooking(tusindfryd,tFinn.harLedsager(),tFinn);

        Tilmelding tNiels = niels.opretTilmelding(havHimmel);
        Controller.opretBooking(denHvideSvane,tNiels.harLedsager(),tNiels);

        Tilmelding tPeter = peter.opretTilmelding(havHimmel);
        Ledsager lPeter = Controller.opretLedsager("Mie Sommer",tPeter);
        Booking bPeter = Controller.opretBooking(denHvideSvane,tPeter.harLedsager(),tPeter);
        lPeter.addUdflugt(trapholt);
        lPeter.addUdflugt(egeskov);

        trapholt.addDeltager(lPeter);
        egeskov.addDeltager(lPeter);

        bPeter.addTillæg(wifi);
    }
}
