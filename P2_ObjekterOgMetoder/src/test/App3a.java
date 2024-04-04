package test;

import model.Student;
import model.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class App3a {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean finished = false;
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Vil du oprette et team? (Ja/Nej)");
        String opretTeam = input.nextLine();

        while (!finished && opretTeam.equalsIgnoreCase("ja")) {

            System.out.println("Hvad skal teamet hedde: ");
            String holdnavn = input.nextLine();
            System.out.println("Hvad lokale skal teamet være i? ");
            String lokale = input.nextLine();
            Team hold = new Team(holdnavn, lokale);
            System.out.println("Hvor mange studerende skal der oprettes i teamet? ");
            int antalStuderende = input.nextInt();
            input.nextLine();

            for (int i = 0; i < antalStuderende; i++) {
                System.out.println("Navn på studerende: ");
                String navn = input.nextLine();
                System.out.println("Er den studerende aktiv: ");
                boolean aktiv = input.nextBoolean();
                input.nextLine();
                System.out.println("Hvor mange karakterer har den studerende fået: ");
                int antalKarakterer = input.nextInt();
                input.nextLine();
                System.out.println("Den studerendes karakter adskilt med blanke: ");
                String karakterInput = input.nextLine();
                String[] karakterArray = karakterInput.split(" ");
                ArrayList<Integer> karakterer = new ArrayList<>();
                for (String karakter : karakterArray) {
                    karakterer.add(Integer.parseInt(karakter));
                }
                Student student = new Student(navn, aktiv, antalKarakterer, karakterer);
                students.add(student);
            }
            System.out.println("Vil du oprette et nyt team? (Ja/Nej)");
            String opretNytTeam = input.nextLine();
            if (opretNytTeam.equalsIgnoreCase("nej")) {
                finished = true;
            }

        }
        if (!students.isEmpty()) {
            for (Student student : students) {
                student.studentAnswers();
                System.out.printf("%-15s %-20s %-20s\n", "Name: " + student.getName(), "Gennemsnit: " + String.format("%.2f",student.getAverageGrade()), "Antal rigtige: " + student.correctAnswersCount());
            }
        } else {
            System.out.println("Ingen teams med studerende blev oprettet.");
        }
    }
}
