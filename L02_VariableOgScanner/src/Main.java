import java.util.Scanner;
// Esben opgave 2:
public class Main {
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";
        String ord6 = "Datamatikeruddannelsen";

        //Opgave 2A - udskriv ord 1 med store bogstaver
        System.out.println(ord1.toUpperCase());

        //Opgave 2B - udskriv ord 2 med små bogstaver
        System.out.println(ord2.toLowerCase());

        //Opgave 2C - sammensæt ord1 og ord2 med et mellemrum i midten og udprint
        String ord3 = ord1.concat(ord2);
        System.out.println(ord3);
        String ord4 = ord1 + " " + ord2;
        System.out.println(ord4);

        //Opgave 2D - Sammensæt ord1 og ord2, hvor ord2 er med små bogstaver
        String ord5 = ord1.concat(ord2.toLowerCase());
        System.out.println(ord5);

        //Opgave 2E - udskriv længden af strengen fra opgave d
        System.out.println("The length of ord5 is " + ord5.length());

        //Opgave 2F - udskriv de første 7 bogstaver af ord1
        System.out.println(ord1.substring(0,7));

        //Opgave 2G - udskriv bogstav 3-7 af ord2
        System.out.println(ord2.substring(2,7));

        //Opgave 2H - udskriv den sidste halvdel af strengen fra opgave d
        System.out.println(ord5.substring(11));

//Opgaver fra bogen - 2.6:
        System.out.println("Enter a number between 0 and 1000: ");
        int number = input.nextInt();
        int a = number % 10;
        int b = (number / 10) % 10;
        int c = number / 100;
        int sum = a + b + c;
        System.out.println("The sum of your number is: " + sum);

        Task2_7();
        Task2_23();
    }

    public static void Task2_7() {
        Scanner input = new Scanner(System.in);
        //Opgaver fra bogen - 2.7:
        System.out.println("Enter the number of minutes: ");
        int minutes = input.nextInt();
        int day = minutes/60/24;
        int year = day/365;
        int extraday = day%365;

        System.out.println(minutes + " minutes is approximately: " + year + " years and " + extraday + " days.");
    }

    public static void Task2_23() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the driving distance: ");
        double distance = input.nextDouble();
        System.out.println("Enter miles per gallon: ");
        double milesPerGallon = input.nextDouble();
        System.out.println("Enter price per gallon: ");
        double pricePerGallon = input.nextDouble();

        double sum = (distance/milesPerGallon) * pricePerGallon;
        System.out.println("The cost of driving is: $"+sum);



    }

}