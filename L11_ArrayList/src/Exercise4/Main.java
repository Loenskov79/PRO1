package Exercise4;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> a1 = new ArrayList<>();

        a1.add(1);
        a1.add(2);
        a1.add(4);
        a1.add(4);
        a1.add(17);
        a1.add(24);
        a1.add(24);

        ArrayList<Integer> a2 = new ArrayList<>();

        a2.add(1);
        a2.add(2);
        a2.add(3);

        System.out.println(a1);
        System.out.println(switchFirstAndLast(a1));
        System.out.println(replaceEvenNumbers(a1));
        System.out.println(getSecondHighest(a1));
        System.out.println(isAscending(a1));
        System.out.println(shiftElementsToRight(a1));
        System.out.println(hasDoublets(a1));

    }

    public static ArrayList<Integer> switchFirstAndLast(ArrayList<Integer> list) {
        ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();

        temp.set(0,list.get(list.size()-1));
        temp.set(temp.size()-1,list.get(0));

        return temp;
    }

    public static ArrayList<Integer> replaceEvenNumbers(ArrayList<Integer> list) {
        ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();

        for (int i = 0; i < temp.size(); i++) {
            if (list.get(i) % 2 == 0) {
                temp.set(i,0);
            }
        }
        return temp;
    }

    public static int getHighest(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (int value: list) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int getSecondHighest(ArrayList<Integer> list) {
        ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();
        int max = getHighest(temp);

        temp.removeAll(Collections.singleton(max));

        return getHighest(temp);
    }

    public static boolean isAscending(ArrayList<Integer> list) {
        ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();

        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i) > temp.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> shiftElementsToRight(ArrayList<Integer> list) {
        ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();

        int lastElement = temp.get(temp.size() - 1);

        for (int i = temp.size() - 1; i > 0; i--) {
            temp.set(i, temp.get(i - 1));
        }
        temp.set(0, lastElement);

        return temp;
    }

    public static boolean hasDoublets(ArrayList<Integer> list) {
        ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();

        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i) == temp.get(j))
                return true;
            }
        }
        return false;
    }
}
