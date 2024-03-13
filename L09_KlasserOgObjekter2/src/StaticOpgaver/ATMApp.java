package StaticOpgaver;
import java.util.Scanner;
public class ATMApp {

    private static ATM atm;
    private static Scanner scanner;

    public static void main(String[] args) {

        BankAccount[] accounts = new BankAccount[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new BankAccount(100);
        }
        atm = new ATM(accounts);
        scanner = new Scanner(System.in);

        selectAccount();



    }

    private static void selectAccount() {
        int accountId = -1;
        while (accountId < 0 || accountId > atm.getBankAccounts().length) {
            System.out.println("Please enter account ID: ");
            accountId = scanner.nextInt();
            if (accountId < 0 || accountId > atm.getBankAccounts().length) {
                System.out.println("Invalid ID");
            }
        }
        atm.setCurrentAccount(accountId);
        MainMenu();
    }

    private static void MainMenu() {

        int chosenAction = 0;

        while (chosenAction != 4) {
            System.out.println("Choose action: ");
            System.out.println("1: Show balance ");
            System.out.println("2: Deposit money ");
            System.out.println("3: Withdraw money ");
            System.out.println("4: Exit ");

            chosenAction = scanner.nextInt();

            if (chosenAction == 1) {
                System.out.println("Current balance is: $" + atm.getCurrentAccount().getBalance());
            } else if (chosenAction == 2) {
                //TODO: Implent deposit money
                System.out.println("You just deposited:... " );
            } else if (chosenAction == 3) {
                //TODO: Implent withdraw money
            }
        }
    }
}
