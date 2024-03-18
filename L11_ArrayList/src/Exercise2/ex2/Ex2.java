package Exercise2.ex2;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
//        ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();

        // Test of sum1() method: correct sum is 61.
        int total = sum1(ints);
        System.out.println("Sum: " + total);

        // Test of sum() method: correct sum is 61.
        int total1 = sum(ints);
        System.out.println("Sum: " + total1);

        // Test of minimum() method: correct minimum is -16.
        System.out.println("Minimum: " + minimum(ints));

        // Test of maximum() method: correct maximum is 45.
        System.out.println("Maximum: " + maximum(ints));

        // Test of average() method: correct average is 7.625.
        System.out.println("Average: " + average(ints));

        // Test of zeroes() method: correct number of zeroes is 2.
        System.out.println("Amount of zeroes: " + zeroes(ints));

        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        System.out.println("Array full of evens: " + evens(ints));
    }

    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum += number;
        }
        return sum;
    }

    public static int sum(ArrayList<Integer> list) {
        int sum = 0;

        for (Integer value: list) {
            sum += value;
        }
        return sum;
    }

    public static int minimum(ArrayList<Integer> list) {
        int minimum = Integer.MAX_VALUE;

        for (Integer value: list) {
            if (value < minimum) {
                minimum = value;
            }
        }
        return minimum;
    }

    public static int maximum(ArrayList<Integer> list) {
        int maximum = Integer.MIN_VALUE;

        for (Integer value: list) {
            if (value > maximum) {
                maximum = value;
            }
        }
        return maximum;
    }

    public static double average(ArrayList<Integer> list) {
        double avg = 0;

        for (Integer value: list) {
            avg += value;
        }

        avg = avg / list.size();
        return avg;
    }

    public static int zeroes(ArrayList<Integer> list) {
        int zeroes = 0;
        for (Integer value: list) {
            if (value == 0) {
                zeroes++;
            }
        }
        return zeroes;
    }

    public static ArrayList<Integer> evens(ArrayList<Integer> list) {
        ArrayList<Integer> evens = new ArrayList<>();
        for (Integer value: list) {
            if (value % 2 == 0) {
                evens.add(value);
            }
        }
        return evens;
    }
}
