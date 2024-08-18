package storage;

import model.Badge;
import model.Hold;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Hold> holds = new ArrayList<>();
    private static ArrayList<Badge> badges = new ArrayList<>();

    public static ArrayList<Hold> getHold() {
        return new ArrayList<>(holds);
    }

    public static ArrayList<Badge> getBadges() {
        return new ArrayList<>(badges);
    }

    public static void tilføjHold(Hold hold) {
        holds.add(hold);
    }

    public static void tilføjBadge(Badge badge) {
        badges.add(badge);
    }
}
