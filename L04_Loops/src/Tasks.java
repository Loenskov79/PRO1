import java.lang.reflect.Method;
import java.util.Scanner;

public class Tasks {
    public static int Task_1a(int fra, int til) {
        int sum = 0;
        int i = fra;

        while (i <= til) {
            sum = sum + i;
            i = i + 2;
        }
        return sum;
    }

    public static int Task_2b(int fra, int limit) {
        int sum = 0;
        int i = fra;

        while (i * i <= limit) {
            sum = sum + i*i;
            i++;
        }
        return sum;
    }

    public static void tasks2a() {
        Methods.printPowersOfTwo();
    }

    public static int sumOddDigits(int number) {
        int sum = 0;
        while (number > 0 ) {
            int remainder = number % 10;
            if (remainder % 2 != 0) {
                sum = sum + remainder;
            }
            number = number / 10;
        }
        System.out.println("The sum of all odd digits are: " + sum);
        return sum;
    }

    public static void task6p3() {
        Scanner input = new Scanner(System.in);
        System.out.println("Input number: ");
        int number = input.nextInt();

        System.out.println("The reverse number of " + number + " is: " + Methods.reverse(number));
        if (Methods.isPalindrome(number)) {
            System.out.println("The number is palindrome.");
        }
        else {
            System.out.println("The number is not palindrome");
        }
    }
    public static void task6p7() {
        Scanner input = new Scanner(System.in);

        System.out.println("The amount invested: ");
        double investmentAmount = input.nextDouble();
        System.out.println("Annual interest rate: ");
        double monthlyInputRate = input.nextDouble() / 12;
        System.out.println("Number of years: ");
        int years = input.nextInt();

        int i = 1;

        System.out.println("Year            Future Value");
        while (i <= years) {
            System.out.print(i + "            ");
            System.out.printf("%,.2f", Methods.futureInvestmentValue(investmentAmount, monthlyInputRate, i));
            System.out.println();
            i++;
        }
    }


    public static void task6p11() {
        System.out.println("Sales amount            Commission");

        double salesAmount = 1000;
        while (salesAmount <= 20000){
            System.out.println(salesAmount + "                  " + Methods.computeCommission(salesAmount));
            salesAmount += 1000;
        }
    }
}
