import java.util.Scanner;

public class Methods {
    public static int reverse(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int lastNumber = number % 10;
            reversedNumber = reversedNumber * 10 + lastNumber;
            number /= 10;
        }
        return reversedNumber;
    }

    public static boolean isPalindrome(int number){
        if (reverse(number) == number) {
            return true;
        } else {
            return false;
        }
    }

    public static void printPowersOfTwo() {
        int base = 2;
        int eksponent = 0;

        while (eksponent <= 20) {
            int n = eksponent;
            int result = 1;
            while (n > 0) {
                result *= base;
                n--;
            }
            System.out.println("2 opløftet i " + eksponent + " er " + result);
            eksponent++;
        }
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        double result = 0.0;

        result = investmentAmount * (Math.pow(1 + monthlyInterestRate,years*12));
        return result;
    }

    public static double computeCommission(double salesAmount){

        double result = 0.0;

        double rate1 = 0.06;
        double rate2 = 0.08;
        double rate3 = 0.1;

        if (salesAmount <= 5000) {
            result += salesAmount*rate1;
        }
        else if (salesAmount > 5000 && salesAmount <= 10000) {
            result += 5000*rate1;
            result += (salesAmount-5000) * rate2;
        }
        else if (salesAmount > 10000) {
            result += 5000*rate1;
            result += (salesAmount-5000) * rate2;
            result += (salesAmount-10000) * rate3;
        }
            return result;
        }
}
