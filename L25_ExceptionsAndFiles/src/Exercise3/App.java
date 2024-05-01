package Exercise3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArrayList<Integer> tal = new ArrayList<>();

        try {
            File file = new File("\\C:\\Users\\VicMan\\Desktop\\Opgave2Test.txt\\");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                tal.add(scanner.nextInt());
            }
            for (int i = tal.size() - 1; i >= 0; i--) {
                System.out.println(tal.get(i));
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
