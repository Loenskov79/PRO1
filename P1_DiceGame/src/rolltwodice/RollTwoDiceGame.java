package rolltwodice;

public class RollTwoDiceGame {
    public static void main(String[] args) {
        printRules();
        System.out.println();

        rolltwodice.Player player = new rolltwodice.Player();
        System.out.println("Playing RollTwoDices.");
        player.play();

        printResults(player);
        System.out.println();

        System.out.println("Thank you for playing RollTwoDices.");
    }

    public static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollTwoDices:");
        System.out.println("The player throws one die as long as he/she wants.");
        System.out.println("=====================================================");
    }

    public static void printResults(Player player) {
        System.out.println("Results");
        System.out.println("-------");
        System.out.println("Roll count: "+ player.getRollCount());
        System.out.println("Total sum of dices: " + player.getSum());
        System.out.println("Total times dices displayed same amount of eyes: " + player.getSameEyes());
        System.out.println("The max sum of a throw is: " + player.getMaxThrown());
        player.printOccurences();
        System.out.printf("The average sum of a throw is: " + player.getAverage());
    }
}
