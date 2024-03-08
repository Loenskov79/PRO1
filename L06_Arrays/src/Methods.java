import java.util.Scanner;

public class Methods {
    public static void arrayTest1() {
        int x = 30;
        int[] numbers = new int[x];
        x = 60;
        System.out.println("x is " + x);
        System.out.println("The size of numbers is " + numbers.length);
    }

    public static void arrayTest2() {
        double[] values = new double[10];
        double[] myList = {1.2, 1.3, 1.4, 1.5, 2.3, 2.4, 2.7, 4.1, 4.5, 5.5};
        double sum = 0;
        int i;
        int n = myList.length;

        for (i = 0; i < n; i++) {
            sum += myList[i];
        }
        System.out.println(sum);
        values[0] = 39.0;
    }

    public static int sum(int[] t) {
        int sum = 0;
        for (int value : t)
            sum += value;
        return sum;
    }

    public static double sum(double[] doubleInt) {
        double sum = 0;
        for (double value : doubleInt)
            sum += value;
        return sum;
    }

    public static int[] sumOfArrays(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1[i] + arr2[i];
        }
        return arr3;
    }

    public static int[] sumArrays(int[] a1, int[] b) {
        if (a1.length >= b.length) {
            int[] sum = new int[a1.length];

            for (int i = 0; i < a1.length; i++) {
                if (i < b.length)
                    sum[i] = a1[i] + b[i];
                else
                    sum[i] = a1[i];
            }
            return sum;
        } else {
            int[] sum = new int[b.length];

            for (int i = 0; i < b.length; i++) {
                if (i < a1.length)
                    sum[i] = a1[i] + b[i];
                else
                    sum[i] = b[i];
            }
            return sum;
        }
    }

    public static boolean hasUneven(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 != 0)
                return true;
        }
        return false;
    }

    public static int oddNumbersCount(int[] t) {
        int oddCount = 0;
        for (int values : t)
            if (values % 2 != 0)
                oddCount++;
        return oddCount;
    }

    public static int evenNumbersCount(int[] t) {
        int evenCount = 0;
        for (int values : t)
            if (values % 2 == 0)
                evenCount++;
        return evenCount;
    }

    public static int printAmountOfOccurences(int[] t) {

        for (int value : t)
            for (int i = 0; i < t.length; i++) {
                int occurence = 0;
                if (value == t[i])
                    occurence++;
            }

        return 0;
    }
    public static int[] switchElements(int[] t) {
        int temp = t[0];
        t[0] = t[t.length - 1];
        t[t.length - 1] = temp;
        return t;
    }

    public static int[] replaceEvenNumbers(int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] % 2 == 0) {
                t[i] = 0;
            }
        }
        return t;
    }

    public static int secondHighest(int[] t) {
        int max = t[0];
        int second = 0;

        for (int i = 1; i < t.length; i++) {
            int j = t[i];
            if (j >= max) {
                max = j;
            } else if (j > second) {
                second = j;
            }
        }
        return second;
    }

    public static boolean isAscending(int[] t) {
        for (int i = 0; i < t.length - 1; i++) {
            if (t[i] > t[i + 1])
                return false;
        }
        return true;
    }

    public static int[] moveToRight(int[] t, int n) {
        int[] output = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            int newLocation = (i + (t.length + n)) % t.length;
            output[newLocation] = t[i];
        }
        return output;
    }
    public static boolean checkForDuplicates (int[] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = i + 1; j < t.length; j++) {
                if (t[i] == t[j])
                    return true;
            }
        } return false;
    }
}
