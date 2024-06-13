package model;

import controller.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Spiller s1 = new Spiller ("Victor", "EAAA");
        Spiller s2 = new Spiller("Loui", "EAAA");
        Spiller s3 = new Spiller ("Mads", "EAAA");
        Spiller s4 = new Spiller("Mikkel", "AU");
        Spiller s5 = new Spiller ("Ralle", "AU");

        Kategori single = new Kategori("Single", 100, 200);
        Kategori dobbelt = new Kategori("Double", 100, 200);


        Bane bane1 = new Bane(1, true, LocalTime.of(10,00), LocalTime.of(22,00), single);
        Bane bane2 = new Bane (2, true, LocalTime.of(10,00), LocalTime.of(22,00), dobbelt);

        Booking b1 = new Booking(LocalDate.of(2024,10,05), LocalTime.of(10,00), true, s1, bane1);
        Booking b2 = new Booking(LocalDate.of(2024, 10, 05), LocalTime.of(15,00), false, s1, bane1);
        Booking b3 = new Booking(LocalDate.of(2024,10,05), LocalTime.of(21,00),true,s1,bane1);

        bane1.addBooking(b1);
        bane1.addBooking(b2);
        bane1.addBooking(b3);

        System.out.println(Arrays.toString(bane1.antalBookningerPrTime()));
        System.out.println(bane1.bookedeTimerPåDato(LocalDate.of(2024, 10, 05)));
        System.out.println(s1.samletPris(single));
        Controller.udskrivBookingsAfBaner("\\C:\\Users\\VicMan\\Desktop\\SemesterprøveTest.txt\\");
    }

}
