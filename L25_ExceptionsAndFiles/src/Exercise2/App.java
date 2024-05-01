package Exercise2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
    try {
        File file = new File("\\C:\\Users\\VicMan\\Desktop\\Opgave2Test.txt\\");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(Integer.parseInt("" + scanner.nextInt() * 2));
        }
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }

    }

}
