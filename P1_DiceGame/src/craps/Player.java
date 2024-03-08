package craps;

import java.util.Scanner;

public class Player {

    private Die die1;
    private Die die2;
    private int sum;
    private int comeOutRoll;

    public Player() {
        this.die1 = new Die();
        this.die2 = new Die();
    }

    public void throwDie() {
        die1.roll();
        die2.roll();
        comeOutRoll = die1.getFaceValue() + die2.getFaceValue();
        sum = die1.getFaceValue() + die2.getFaceValue();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Roll?");
        scanner.nextLine();
        throwDie();
        System.out.printf("Rolling first die... %d\n", die1.getFaceValue());
        System.out.printf("Rolling second die... %d\n", die2.getFaceValue());
        System.out.println("Total number of dices: " + sum);
        if (comeOutRoll == 7 || comeOutRoll == 11)
            System.out.println("You win!");
        else if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll == 12)
            System.out.println("You lose!");
        else {
            boolean finished = false;
            while (finished != true) {
                System.out.println("Roll again");
                String again = scanner.nextLine();
                die1.roll();
                die2.roll();
                sum = die1.getFaceValue() + die2.getFaceValue();
                System.out.printf("Rolling first die... %d\n", die1.getFaceValue());
                System.out.printf("Rolling second die... %d\n", die2.getFaceValue());
                System.out.println("Total number of dices: " + sum);
                if (sum == 7) {
                    System.out.println("You lose!");
                    finished = true;
                } else if (sum == comeOutRoll) {
                    System.out.println("You win!");
                    finished = true;
                }
            }
        }
    }
}
