import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

public class AdditionQuiz {
  public static void main(String[] args) {

    //Task_2();
    //Task_3();
    //sign();
    //Rock_Paper_Scissor();
    //RockPaperScissor();

    int number1 = (int)(System.currentTimeMillis() % 10);
    int number2 = (int)(System.currentTimeMillis() * 7 % 10);
    int number3 = (int)(System.currentTimeMillis() * 7 % 10);

    // Create a Scanner
    Scanner input = new Scanner(System.in);

    System.out.print(
      "What is " + number1 + " * " + number2 + " * " + number3 + "?");

    int answer = input.nextInt();

    System.out.println(
      number1 + " * " + number2 + " * " + number3 + " = " + answer + " is " +
     (number1 * number2 * number3 == answer));


  }

  public static void Task_2() {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter any number - positive, negative or 0: ");
    int answer = input.nextInt();

    if (answer > 0) {
      System.out.println("Positive");
    }
    else if (answer == 0) {
      System.out.println("Nul");
    }
    else {
      System.out.println("Negative");
    }

  }

  public static void Task_3() {
    Scanner input = new Scanner(System.in);
    System.out.println("Input 3 different numbers: ");
    int answer = input.nextInt();
    int answer1 = input.nextInt();
    int answer2 = input.nextInt();

    if (answer < answer1 && answer1 < answer2) {
      System.out.println("Er voksende");
    }
    else if (!(answer < answer1 && answer1 < answer2)
            && !(answer > answer1 && answer1 > answer2)) {
      System.out.println("Hverken eller");
    }
    else if (answer > answer1 && answer1 > answer2) {
      System.out.println("Er aftagende");
    }
  }

  //Opgave 6 metode
  public static String sign(int answer) {
    Scanner input = new Scanner(System.in);

    String myString = new String();
    if (answer > 0)
      myString = "Positive";
    if (answer == 0)
      myString = "Null";
    if (answer < 0)
      myString = "Negative";
    return myString;
  }

  //Opgave 7 metode
  public static String inorder(int num1, int num2, int num3) {
    String myString = new String();

    if (num1 < num2 && num2 < num3)
      myString = "Er voksende";
    if (!(num1 < num2 && num2 < num3)
            && !(num1 > num2 && num2 > num3))
      myString = "Hverken eller";
    if (num1 > num2 && num2 > num3)
      myString = "Er aftagende";
    return myString;
  }

  //Opgave 8 - 3.17 i bogen metode:
  public static void RockPaperScissor() {
    Scanner input = new Scanner(System.in);

    Random computerAnswer = new Random();

    System.out.println("Enter a number: scissor (0), rock (1), paper (2): ");

    int computerAnswer1 = computerAnswer.nextInt(3);
    int answer = input.nextInt();

    if (answer == 0) {
      if (computerAnswer1 == 0)
        System.out.println("Computer got scissor. You got scissor. You draw");
      else if (computerAnswer1 == 1)
        System.out.println("Computer got rock. You got scissor. Computer won");
      else if (computerAnswer1 == 2)
        System.out.println("Computer got paper. You got scissor. You won");
    }
    else if (answer == 1) {
      if (computerAnswer1 == 0)
        System.out.println("Computer got scissor. You got rock. You won");
      else if (computerAnswer1 == 1)
        System.out.println("Computer got rock. You got rock. You draw");
      else if (computerAnswer1 == 2)
        System.out.println("Computer got paper. You got rock. Computer won");
    }
    else if (answer == 2) {
      if (computerAnswer1 == 0)
        System.out.println("Computer got scissor. You got paper. Computer won");
      else if (computerAnswer1 == 1)
        System.out.println("Computer got rock. You got paper. You won");
      else if (computerAnswer1 == 2)
        System.out.println("Computer got paper. You got paper. You draw");
    }
  }
}
