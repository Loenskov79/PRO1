package craps;

public class CrapsGame {
    public static void main(String[] args) {
        Player player = new Player();
        printRules();
        player.play();
    }

    public static void printRules() {
        System.out.println("=====================================================================");
        System.out.println("Rules of craps:");
        System.out.println("The player throws two dices:");
        System.out.println("First roll: Roll 7 or 11 and you win! Roll 2, 3 or 12 and you lose!");
        System.out.println("If you manage to roll either 4, 5, 6, 8, 9 or 10, that is your point");
        System.out.println("Roll your point again and you win, roll 7 and you lose. Good luck!");
        System.out.println("=====================================================================");
    }
}
