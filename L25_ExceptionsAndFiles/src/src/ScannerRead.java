package src;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScannerRead {

    public static void main(String[] args) {
        try {
            File file = new File("C:\\PRO1_24Y\\Programmering1\\Dag25_Exceptions\\txt\\helloworld.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.print(scanner.nextLine() + " ");
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
