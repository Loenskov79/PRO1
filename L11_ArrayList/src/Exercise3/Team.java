package Exercise3;

import java.util.ArrayList;

public class Team {

    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<Player>();
    }

    public String toString() {
        return "Team(" + name + ")";
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer (Player p) {
        players.add(p);
    }

    public void printPlayers() {
        for (Player player: players) {
            System.out.println(player);
        }
    }

    public double calcAverageAge() {
        double avg = 0;

        for (Player player: players) {
            avg += player.getAge();
        }
        avg = avg / players.size();
        return avg;
    }

    public int calcTotalScore() {
        int totalScore = 0;

        for(Player player: players) {
            totalScore += player.getScore();
        }
        return totalScore;
    }

    public int calcOldPlayersScore (int ageLimit) {
        int total = 0;

        for (Player player: players) {
            if (player.getAge() > ageLimit) {
                total += player.getScore();
            }
        }
        return total;
    }

    public int maxScore() {
        int max = Integer.MIN_VALUE;

        for (Player player: players) {
            if (player.getScore() > max) {
                max = player.getScore();
            }
        }
        return max;
    }

    public ArrayList<String> bestPlayerNames() {
        ArrayList<String> bestPlayers = new ArrayList<>();

        for (Player player: players) {
            if (player.getScore() == maxScore()) {
                bestPlayers.add(player.getName());
            }
        }
        return bestPlayers;
    }

}
