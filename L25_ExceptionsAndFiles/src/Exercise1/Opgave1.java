package Exercise1;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Opgave1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] prim = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        try  {
            System.out.println("Hvilket nr. primtal skal vises?: ");
            int n = scan.nextInt();
            System.out.println("Primtal nr. " + n + " er " + prim[n-1] + "\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Det indtastede tal er ikke mellem 1-10.");
        } catch (InputMismatchException e) {
            System.out.println("Indtast venligst et helt tal melllem 1-10.");
        } catch (NoSuchElementException e) {
            System.out.println("Det ønskede element findes ikke.");
        } catch (IllegalStateException e) {
            System.out.println("Scanneren er lukket");
        }
    }

}
