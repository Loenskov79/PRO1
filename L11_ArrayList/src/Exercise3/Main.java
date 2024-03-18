package Exercise3;

public class Main {
    public static void main(String[] args) {
        Team t1 = new Team("Favourites");

        t1.addPlayer(new Player("Mikkel", 29));
        t1.addPlayer(new Player("Karl", 25));
        t1.addPlayer(new Player("Susan", 11));
        t1.addPlayer(new Player("Cirkeline", 22));

        t1.printPlayers();
        System.out.println(t1.calcAverageAge() + "\n");

        t1.getPlayers().get(0).setScore(15);
        t1.getPlayers().get(1).setScore(45);
        t1.getPlayers().get(2).setScore(35);
        t1.getPlayers().get(3).setScore(25);


        System.out.println(t1.calcTotalScore() + "\n");
        System.out.println(t1.calcOldPlayersScore(23) + "\n");
        System.out.println(t1.maxScore() + "\n");
        System.out.println(t1.bestPlayerNames());

    }
}
