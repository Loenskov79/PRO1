package test;

import java.util.Scanner;

public class App3a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        while (!finished) {
            System.out.println("Vil du oprette et team? (Ja/Nej)");
            String opretTeam = input.nextLine();
            if (opretTeam.equalsIgnoreCase("nej")) {
                finished = false;
            } else {
                System.out.println("Hvad skal teamet hedde: ");
                input.nextLine();
                System.out.println("Hvad lokale skal teamet være i? ");
            }
        }
    }

}
