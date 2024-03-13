package Opgave2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        Scanner input = new Scanner(System.in);

        boolean finished = false;

        while (!finished) {
            System.out.println("Press 1 to start the stopwatch.");
            input.nextInt();
            stopWatch.start();
            System.out.println("Press 2 to stop the stopwatch");
            input.nextInt();
            stopWatch.stop();
            System.out.println("Elapsed time is: " + stopWatch.elapsedTime());
            finished = true;
        }

    }
}
