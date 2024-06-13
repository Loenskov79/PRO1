package Exercise4;

import java.io.IOException;
import java.io.PrintWriter;

public class App {

    public static void main(String[] args) {

        try {
            String fileName = "\\C:\\Users\\VicMan\\Desktop\\Opgave4Test.txt\\";
            PrintWriter printWriter = new PrintWriter(fileName);

            for (int i = 0; i <= 100; i++) {
                if (i % 2 != 0) {
                    printWriter.println(i);
                }
            }

            printWriter.flush();
            printWriter.close();
            System.out.println("Filen er lavet");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
