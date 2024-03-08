import java.util.Arrays;
import java.util.Scanner;

public class Tasks {

    static Scanner input = new Scanner(System.in);

    public static void task1() {
        int[] array1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,};
        System.out.println("Array A is: " + Arrays.toString(array1));
        int[] array2 = {2, 44, -23, 99, 8, -5, 7, 10, 20, 30,};
        System.out.println("Array B is: " + Arrays.toString(array2));
        int[] array3 = new int[10];
        for (int i = 0; i < array3.length; i++) {
            array3[i] = i;
        }
        System.out.println("Array C is: " + Arrays.toString(array3));
        int[] array4 = new int[10];
        for (int i = 1; i <= array4.length; i++) {
            array4[i - 1] = i * 2;
        }
        System.out.println("Array D is: " + Arrays.toString(array4));
        int[] array5 = new int[10];
        for (int i = 1; i <= array5.length; i++) {
            array5[i - 1] = i * i;
        }
        System.out.println("Array E is: " + Arrays.toString(array5));
        int[] array6 = new int[10];
        for (int i = 1; i < array6.length; i++) {
            array6[i] = i % 2;
        }
        System.out.println("Array F is: " + Arrays.toString(array6));
        int[] array7 = new int[10];
        for (int i = 1; i < array7.length; i++) {
            array7[i] = i % 5;
        }
        System.out.println("Array G is: " + Arrays.toString(array7));
        int[] array8 = new int[10];
        for (int i = 1; i < array8.length; i++) {
            if (i % 2 == 0) {
                array8[i] = i * 2;
            } else {
                array8[i] = i * 2 + 1;
            }
        }
        System.out.println("Array H is: " + Arrays.toString(array8));
    }

    public static void task2() {
        int[] myList = {4, 6, 7, 2, 3};
        System.out.println("The sum of " + Arrays.toString(myList) + " is: " + Methods.sum(myList));
        double[] myDoubleList = {1.2, 1.3, 1.5, 1.7, 1.8};
        System.out.println("The sum of " + Arrays.toString(myDoubleList) + " is: " + Methods.sum(myDoubleList));
    }

    public static void task3() {
        int[] arr1 = {3, 5, 7, 9, 7, 5};
        int[] arr2 = {8, 2, 6, 1, 10, 64, 128};
        System.out.println("The sum of " + Arrays.toString(arr1) + " and " + Arrays.toString(arr2) + " is ");
        System.out.println(Arrays.toString(Methods.sumArrays(arr1, arr2)));
    }

    public static void task4() {
        int[] a = {2, 4, 6, 8};
        System.out.println(Methods.hasUneven(a));
    }

    public static void task7_5() {

        int[] numbers = new int[10];
        System.out.println("Please enter 10 numbers: ");

        for (int i = 0; i < 10; i++) {
            numbers[i] = input.nextInt();
        }
        System.out.println("The array " + Arrays.toString(numbers) + " contains: ");
        System.out.println("Odd numbers: " + Methods.oddNumbersCount(numbers));
        System.out.println("Even numbers: " + Methods.evenNumbersCount(numbers));
    }

    public static void task7_3 () {
        Scanner scanner = new Scanner(System.in);

        // Opretter et array der skal gemme frekvensen af de indtastede tal
        int[] frequence = new int[50];

        System.out.println("Enter some integers between 1 and 50, end with 0:");

        // Læser det første tal brugeren indtaster
        int number = scanner.nextInt();
        while (number != 0) {
            if (number < 1 || number > 49) {
                System.out.println(number + " is not in 1..49");
            } else {
                // Frekvensen af det indtastede tal øges
                frequence[number]++;
            }
            // Læser det næste tal der bliver indtastet, og det loopet fortsætter så, indtil brugeren indtaster 0
            number = scanner.nextInt();
        }

        // Starter en løkke der går igennem alle tal fra 1-49 for at udskrive deres frekvenser
        for (int i = 1; i <= 49; i++) {
            // Tjekker om frekvensen er større end nul, fordi hvis det er det, så er tallet blevet indtastet,
            // og frekvensen skal øges
            if (frequence[i] > 0) {
                System.out.printf("%2d occurs %2d", i, frequence[i]);
                if (frequence[i] == 1) System.out.println(" time");
                else System.out.println(" times");
            }
        }
    }

    public static void task6() {
        int[] numberSwitch = {1, 2, 7, 8, 11};
        System.out.println(Arrays.toString(Methods.switchElements(numberSwitch)));
        int[] numberReplacement = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(Methods.replaceEvenNumbers(numberReplacement)));
        int[] secondNumber = {2, 6, 12, 534, 92, 15};
        System.out.println(Methods.secondHighest(secondNumber));
        int[] ascendingNumber = {1, 2, 3, 4, 5, 6, 7, 8, 5};
        System.out.println(Methods.isAscending(ascendingNumber));
        int[] rightShift = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(Methods.moveToRight(rightShift, 1)));
        int[] duplicateNumbers = {1, 2, 3, 11, 5, 11};
        System.out.println(Methods.checkForDuplicates(duplicateNumbers));
    }
}
