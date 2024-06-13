package Groupexercise;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        ArrayList<Player> spillere = new ArrayList<>();

        spillere.add(new Player("Mikkel", 180, 80, 10));
        spillere.add(new Player("Mads", 190, 90, 5));
        spillere.add(new Player("Anders", 170, 70, 150));
        spillere.add(new Player("Jonas", 175, 75, 20));
        spillere.add(new Player("Morten", 185, 85, 25));
        spillere.add(new Player("Jens", 195, 95, 30));
        spillere.add(new Player("Peter", 165, 65, 35));
        spillere.add(new Player("Henrik", 200, 100, 15));

        int[] test = {7,56,34,3,7,14,13,4};

        System.out.println(intervalNumberAbstract(test));
        System.out.println(unevenNumber(test));

        System.out.println(findPlayerLinear(spillere, 35));
        Collections.sort(spillere);
        System.out.println(findPlayerBinary(spillere, 150));

        int[] list = {18,15,34,45,11,67};
        int[] list2 = {15,18,34,11,45,67};
        int[] list3 = {15,18,11,34,45,67};
        int[] list4 = {15,11,18,34,45,67};
        int[] list5 = {11,15,18,34,45,67};

    }

    public static Player findPlayerLinear(ArrayList<Player> spillere, int scoredGoals) {
        Player player = null;
        int i = 0;

        while (player == null && i < spillere.size()) {
            Player p = spillere.get(i);
            if (p.getScoredGoals() == scoredGoals) {
                player = p;
            } else {
                i++;
            }
        }
        return player;
    }

    public static Player findPlayerBinary(ArrayList<Player> spillere, int scoredGoals) {
        Player player = null;
        int left = 0;
        int right = spillere.size() - 1;
        while (player == null && left <= right) {
            int middle = (left + right) / 2;
            Player p = spillere.get(middle);
            if (p.getScoredGoals().compareTo(scoredGoals) == 0) {
                player = p;
            } else if (p.getScoredGoals().compareTo(scoredGoals) > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return player;
    }

    public static boolean unevenNumber(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static int intervalNumber(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 10 && arr[i] <= 15) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int intervalNumberAbstract(int[] arr) {
        boolean found = false;
        int i = 0;
        int m = -1;

        while (!found && i < arr.length) {
            if (arr[i] >= 10 && arr[i] <= 15) {
                m = arr[i];
                found = true;
            }
            i++;
        }
        return m;
    }
}
