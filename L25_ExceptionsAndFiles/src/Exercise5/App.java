package Exercise5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        try {
            String fileName = "\\C:\\Users\\VicMan\\Desktop\\Opgave5Test.txt\\";
            PrintWriter printer = new PrintWriter(fileName);

            Scanner input = new Scanner(System.in);
            System.out.println("Skriv de tal som skal skrives i filen. Slut med -1. (OBS. -1 kommer ikke med i filen)");

            boolean finished = false;
            while (!finished) {
                int tal = input.nextInt();
                if (tal > 0) {
                    printer.println(tal);
                }
                if (tal == -1) {
                    finished = true;
                }
            }

            printer.flush();
            printer.close();
            System.out.println("Filen er blevet lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
