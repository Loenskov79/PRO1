package pig;
import java.util.Scanner;

public class Player {

    private int sumCount;
    private Die die;

    public Player() {

        this.sumCount = sumCount;
        this.die = new Die();

    }

    public void throwDie() {
        die.roll();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please press enter to roll, and type 'n' to end turn.");
        boolean finished = false;
        int pointCount = 0;
        while (finished != true) {
            String input = scanner.nextLine();
            throwDie();
            if (input.equals("n")) {
                sumCount += pointCount;
                finished = true;
            }
            else if (die.getFaceValue() != 1) {
                System.out.println("Added " + die.getFaceValue() + " to your points!");
                sumCount += die.getFaceValue();
                System.out.println("You now have " + sumCount + " points.");
            } else if (die.getFaceValue() == 1) {
            System.out.println("You rolled 1. You get zero points!");
            pointCount = 0;
            finished = true;
            }
        }
        System.out.println("Your total points are: " + sumCount);
    }

    public int getSumCount() {
        return sumCount;
    }

    public void gameRules() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Welcome to pigs");
        System.out.println("The rules are simple. First player to get a 100 points wins.");
        System.out.println("Everytime you roll, the dice value gets added into your personal sum");
        System.out.println("If you hit a 1 however, you get zero points for that round, ");
        System.out.println("and the turn gos to the next player.");
        System.out.println("Hit 'n' to end your turn, or when you have reached a 100 or more points");
        System.out.println("and you will be declared the winner! Have fun.");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }
}
