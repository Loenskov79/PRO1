package rolltwodice;

import java.util.Scanner;

public class Player {

    private Die die1;
    private Die die2;
    private int rollCount;
    private int sum;
    private int sameEyes;
    private int maxThrown;
    private int[] occurences = new int[6];
    private double average;

    public Player() {
        this.die1 = new Die();
        this.die2 = new Die();
    }

    public int getRollCount() {
        return rollCount;
    }

    public double getAverage() {
        average = (double) sum / rollCount;
        return average;
    }

    public int getSum() {
        return sum;
    }

    public int getSameEyes() {
        return sameEyes;
    }

    public int getMaxThrown() {
        return maxThrown;
    }

    public void printOccurences() {
        for (int i = 0; i <= 5; i++) {
            if (occurences[i] > 0) {
                System.out.printf("%2d occurs %2d", i+1, occurences[i]);
                if (occurences[i] == 1) System.out.println(" time");
                else System.out.println(" times");
            }
        }
    }

    public void throwDie() {
        die1.roll();
        die2.roll();
        rollCount++;
        ++occurences[die1.getFaceValue()-1];
        ++occurences[die2.getFaceValue()-1];
        sum += (die1.getFaceValue() + die2.getFaceValue());
        if (die1.getFaceValue() == die2.getFaceValue()) {
            sameEyes++;
        }
        if (die1.getFaceValue() + die2.getFaceValue() > maxThrown) {
            maxThrown = die1.getFaceValue() + die2.getFaceValue();
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();
        boolean finished = false;
        while (!finished) {
            throwDie();
            System.out.printf("Rolling first die... %d\n", die1.getFaceValue());
            System.out.printf("Rolling second die... %d\n", die2.getFaceValue());
            System.out.println("Roll again? (Y/n)");
            String again = scanner.nextLine();
            if (again.toLowerCase().equals("n")) {
                finished = true;
            }
        }
    }
}
