package Opgave3;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class RentalApp {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        Rental rentals[] = new Rental[2];
        rentals[0] = new Rental(10,350,LocalDate.of(2024,4, 1),1000);
        rentals[1] = new Rental(7,100, currentDate.plusMonths(10), 800);

        for (int i = 0; i < rentals.length; i++) {
            if (rentals[i] != null) {
                System.out.println(rentals[i].toString());
                System.out.println("The total price of the rental is: " + rentals[i].getTotalPrice());
                System.out.println("The end date of the rental is: " + rentals[i].getEndDate());
                System.out.println("The day before the start date of the rental is: " + rentals[i].getStartDate().minusDays(1));
            }
        }
        Period per = Period.between(rentals[0].getStartDate(),rentals[1].getStartDate());
        System.out.println("Time between the start date of the two units: ");
        System.out.println(per.getYears() + " years, " + per.getMonths() + " months and " + per.getDays() + " days.");
        System.out.println("The amount of days between the start date of the two units: " + ChronoUnit.DAYS.between(rentals[0].getStartDate(),rentals[1].getStartDate()));

    }

}
