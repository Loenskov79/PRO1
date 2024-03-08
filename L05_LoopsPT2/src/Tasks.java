import java.util.Scanner;

public class Tasks {
    public static void task1a () {
        Methods.printingOddNumbers();
    }
    public static void task1b () {
        Methods.multiplumOffThree();
    }
    public static void task2a () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount of numbers you want to check: ");
        final int amount = input.nextInt();
        System.out.println("Enter " + amount + " different numbers between 1 - 99");

        int max = 0;
        int min = 0;
        int even = 0;
        int odd = 0;

        for (int i = 1; i <= amount; i++) {
            int num = input.nextInt();
            if (num > 0 && num <= 99) {
                if (min == 0)
                    min = num;
                if (num < min)
                    min = num;
                if (num > max)
                    max = num;
                if (num % 2 == 0)
                    even++;
                if (num % 2 != 0)
                    odd++;
            }
            else
                System.out.println("Wrong input!");
        }
        System.out.println("The biggest number was: " + max);
        System.out.println("The smallest number was: " + min);
        System.out.println("The amount of even numbers were: " + even);
        System.out.println("The amount of odd numbers were " + odd);
    }
    public static void task2b () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount of numbers you want to check: ");
        final int amount = input.nextInt();
        System.out.println("Enter " + amount + " different numbers between 1 - 99");

        int sum = 0;
        for (int i = 1; i <= amount; i++) {
            int num = input.nextInt();
            sum += num;
            System.out.println("Den løbende sum er: " + sum);
        }
    }
    public static void task2c () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount of numbers you want to check: ");
        final int amount = input.nextInt();
        System.out.println("Enter " + amount + " different numbers between 1 - 99");

        int max = 0;
        int count = 0;

        for (int i = 1; i <= amount; i++) {
            int num = input.nextInt();
            if (num > max) {
                max = num;
                count = 0;
                count++;
            }
            else if (num == max)
                count++;
        }
        System.out.println("The max number is: " + max);
        System.out.println("The amount of times the max number appears are: " + count);
    }
    public static void task2d () {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter amount of numbers you want to check: ");
        final int amount = input.nextInt();
        System.out.println("Enter " + amount + " different numbers between 1 - 99");

        int førNummer = input.nextInt();

        for (int i = 1; i <= amount; i++) {
            int num = input.nextInt();
            if (num == num)
                System.out.println(num);
        }
    }
}
