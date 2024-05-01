package Exercise6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilUtil {

    public int max(String filename) throws IOException {
        int max = Integer.MIN_VALUE;

            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                if (Integer.parseInt(scanner.nextLine()) > max) {
                    max = scanner.nextInt();
                }
            }

        return max;
    }

    public int min(String filename) throws IOException {
        int min = Integer.MAX_VALUE;

            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                if (Integer.parseInt(scanner.nextLine()) < min) {
                    min = scanner.nextInt();
                }
            }

        return min;
    }

    public double gennemsnit(String filename) throws IOException {
        double avg = 0;

        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            avg += Integer.parseInt(scanner.nextLine());
        }
        return avg;
    }
}

