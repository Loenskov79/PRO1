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
        while (accountId < 0 || accountId > atm.getBankAccounts().length - 1) {
            System.out.println("Please enter account ID: ");
            if (scanner.hasNextInt()) {
                accountId = scanner.nextInt();
                if (accountId < 0 || accountId > atm.getBankAccounts().length - 1) {
                    System.out.println("Invalid ID");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid ID");
                scanner.next();
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

            if (scanner.hasNextInt()) {
                chosenAction = scanner.nextInt();
                if (chosenAction == 1) {
                    System.out.println("Current balance is: $" + atm.getCurrentAccount().getBalance());
                    MainMenu();
                } else if (chosenAction == 2) {
                    System.out.println("Please enter the amount you wish to deposit: ");
                    if (scanner.hasNextInt()) {
                        int deposit = scanner.nextInt();
                        atm.getCurrentAccount().deposit(deposit);
                        System.out.println("You just deposited: $" + deposit + " and you now have $" + atm.getCurrentAccount().getBalance());
                    } else {
                        System.out.println("Invalid input! Please enter a valid integer amount");
                        scanner.next();
                    }
                } else if (chosenAction == 3) {
                    System.out.println("Please enter the amount you wish to withdraw");
                    if (scanner.hasNextInt()) {
                        int withdraw = scanner.nextInt();
                        atm.getCurrentAccount().withdraw(withdraw);
                        System.out.println("You just withdrew: $" + withdraw + " and you now have $" + atm.getCurrentAccount().getBalance());
                    } else {
                        System.out.println("Invalid input! Please enter a valid integer amount");
                    }
                } else if (chosenAction == 4) {
                    System.out.println("Thank you for using the ATM. Have a nice day!\n");
                    selectAccount();
                } else {
                    System.out.println("Not a valid input! Please choose one of the available actions.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();
            }
        }
    }
}
