package pig;

import java.util.Scanner;

public class PigGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player1 = new Player();
        Player player2 = new Player();
        int numToWin;
        player1.gameRules();
        System.out.println();
        System.out.println("Enter the number you have to reach to win: ");
        numToWin = input.nextInt();
        boolean finished = false;
        while (finished != true) {
            System.out.println("Player 1: Your turn");
            player1.play();
            System.out.println();
            System.out.println("Player 2: Your turn");
            player2.play();
            System.out.println();
            if (player1.getSumCount() >= numToWin && player1.getSumCount() > player2.getSumCount()) {
                System.out.println("Player 1 has won!");
                finished = true;
            }
            else if (player2.getSumCount() >= numToWin && player2.getSumCount() > player1.getSumCount()) {
                System.out.println("Player 2 has won!");
                finished = true;
            }

        }
    }
}
