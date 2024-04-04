import java.util.Scanner;

public class AppVictorM {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Indtast personens navn: ");
        String name = input.nextLine();
        System.out.println("Indtast personens vægt i kg: ");
        int weight = input.nextInt();
        System.out.println("Indtast personens højde: ");
        double height = input.nextDouble();

        double BMI = (weight) / (height * height);

        System.out.println("Beregnet BMI: " + BMI);

        if (BMI < 18.5) {
            System.out.println(name + ", BMI siger: undervægt");
        } else if (BMI >= 18.5 && BMI <= 25) {
            System.out.println(name + ", BMI siger: normal vægt");
        } else if (BMI > 25 && BMI <= 30) {
            System.out.println(name + ", BMI siger: overvægt");
        } else  {
            System.out.println(name + ", BMI siger: fedme");
        }
    }
}
