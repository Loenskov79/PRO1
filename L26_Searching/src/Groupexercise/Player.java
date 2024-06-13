package Groupexercise;

public class Player implements Comparable<Player> {

    private String name;
    private int height;
    private int weight;
    private Integer scoredGoals;

    public Player(String name, int height, int weight, Integer scoredGoals) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.scoredGoals = scoredGoals;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public Integer getScoredGoals() {
        return scoredGoals;
    }

    public int compareTo(Player o) {
        return scoredGoals - o.getScoredGoals();
    }

    @Override
    public String toString() {
        return "Navn: " + name + " Mål: " + scoredGoals;
    }
}
