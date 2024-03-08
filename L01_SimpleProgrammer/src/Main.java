import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args)
    {
        // Opgaver i bogen: 1.1
        System.out.println("Welcome to Java");
        System.out.println("Learning Java Now");
        System.out.println("Programming is fun");

        // Opgaver i bogen: 1.2
        for(int i=1; i<=5; i++)
        System.out.println("I love Java");

        // Opgaver i bogen: 1.6
        System.out.println(1+2+3+4+5+6+7+8+9+10);

        // Opgaver i bogen: 1.7
        System.out.println(4*(1.0-1.0/3+1.0/5-1.0/7+1.0/9-1.0/11));
        System.out.println(4*(1.0-1.0/3+1.0/5-1.0/7+1.0/9-1.0/11+1.0/13));

        // Opgaver i bogen: 1.8
        double pi = 3.14159;
        double radius = 6.5;
        double perimeter = 2 * radius * pi;
        double area = radius * radius * pi;
        System.out.println("Perimeter = "+perimeter);
        System.out.println("Area = "+area);

        // Opgaver i bogen: 1.9
        double width = 5.3;
        double height = 8.6;
        double area1 = width * height;
        double perimeter1 = 2 * (width + height);
        System.out.println("Area1 = "+area1);
        System.out.println("Perimeter1 = "+perimeter1);

        // Esbens børn opgave
        double b1 = 6.0;
        double b2 = 6.0;
        double b3 = 8.0;
        double g1 = 15.0;
        double g2 = 16.0;
        double g3 = 18.0;
        double averageAge = (b1+b2+b3+g1+g2+g3)/6;
        double averageBage = (b1+b2+b3)/3;
        double averageGage = (g1+g2+g3)/3;
        System.out.println("Samlet gennemsnit = "+averageAge);
        System.out.println("Drenge gennemsnit = "+averageBage);
        System.out.println("Pige gennemsnit = "+averageGage);

        double madpakkerOmDagen = 6;
        double skoledage = 200;
        double antalBørn = 3;
        System.out.println(madpakkerOmDagen*skoledage);

        double antalSmurtAfSeksÅrig = 400 * 1.5;
        double antalSmurtAfOtteÅrig = 400 * 2;
        double antalSmurtAfTiÅrige = 800 * 2 * 3;
    }
}