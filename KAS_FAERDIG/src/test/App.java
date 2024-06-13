package test;

import application.controller.Controller;
import application.model.*;
import enumeration.TillægType;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Konference havHimmel = Controller.opretKonference("Hav og Himmel",1500,"Konference om vand osv");
        havHimmel.setTidsperiode(LocalDate.of(2024,06,03),LocalDate.of(2024,06,05));

        Deltager finn = Controller.opretDeltager("Finn Madsen",false,"12345678");
        Deltager niels = Controller.opretDeltager("Niels Petersen",false,"12345678");
        Deltager peter = Controller.opretDeltager("Peter Sommer",false,"12345678");
        Deltager lone = Controller.opretDeltager("Lone Jensen",true,"12345678");


        Hotel denHvideSvane = Controller.opretHotel("Den Hvide Svane",1250,1050);
        Tillæg wifi = denHvideSvane.opretTillæg(TillægType.WIFI,50,"Fri WIFI");

        Udflugt egeskov = havHimmel.opretUdflugt(75,"Egeskov","tur i skoven",LocalDate.of(2024,06,04),false);
        Udflugt trapholt = havHimmel.opretUdflugt(200,"Trapholt Museum","tur på musem",LocalDate.of(2024,06,05),true);
        Udflugt odense = havHimmel.opretUdflugt(125,"Byrundtur, Odense","tur i byen",LocalDate.of(2024,06,03),true);

        Tilmelding tFinn = finn.opretTilmelding(havHimmel);

        Tilmelding tNiels = niels.opretTilmelding(havHimmel);
        Controller.opretBooking(denHvideSvane,tNiels.harLedsager(),tNiels);

        Tilmelding tPeter = peter.opretTilmelding(havHimmel);
        Ledsager lPeter = Controller.opretLedsager("Mie Sommer",tPeter);
        Booking bPeter = Controller.opretBooking(denHvideSvane,tPeter.harLedsager(),tPeter);
        lPeter.addUdflugt(trapholt);
        lPeter.addUdflugt(egeskov);
        bPeter.addTillæg(wifi);

        Tilmelding tLone = lone.opretTilmelding(havHimmel);
        Ledsager lLone = Controller.opretLedsager("Jan Madsen",tLone);
        Booking bLone = Controller.opretBooking(denHvideSvane,tLone.harLedsager(),tLone);
        bLone.addTillæg(wifi);
        lLone.addUdflugt(egeskov);
        lLone.addUdflugt(odense);

        System.out.println("tFinn.getTotalPris() = " + tFinn.getTotalPris());
        System.out.println("tNiels.getTotalPris() = " + tNiels.getTotalPris());
        System.out.println("tPeter.getTotalPris() = " + tPeter.getTotalPris());
        System.out.println("tLone.getTotalPris() = " + tLone.getTotalPris());

    }
}
