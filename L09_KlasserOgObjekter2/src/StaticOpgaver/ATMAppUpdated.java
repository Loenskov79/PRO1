package StaticOpgaver;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMAppUpdated {

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

            try {
                chosenAction = scanner.nextInt();

                if (chosenAction == 1) {
                    System.out.println("Current balance is: $" + atm.getCurrentAccount().getBalance());
                    MainMenu();
                } else if (chosenAction == 2) {
                    boolean validDeposit = false;
                    while (!validDeposit) {
                        System.out.println("Please enter the amount you with to deposit: ");
                        if (scanner.hasNextInt()) {
                            int deposit = scanner.nextInt();
                            atm.getCurrentAccount().deposit(deposit);
                            System.out.println("You just deposited: $" + deposit + " and you now have $" + atm.getCurrentAccount().getBalance());
                            validDeposit = true;
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer");
                            scanner.next();
                        }
                    }
                } else if (chosenAction == 3) {
                    boolean validWithdrawal = false;
                    while (!validWithdrawal) {
                        System.out.println("Please enter the amount you wish to withdraw");
                        if (scanner.hasNextInt()) {
                            int withdraw = scanner.nextInt();
                            atm.getCurrentAccount().withdraw(withdraw);
                            System.out.println("You just withdrew: $" + withdraw + " and you now have $" + atm.getCurrentAccount().getBalance());
                            validWithdrawal = true;
                        } else {
                            System.out.println("Invalid input! Please enter a valid integer");
                            scanner.next();
                        }
                    }
                } else if (chosenAction == 4) {
                    System.out.println("Thank you for using the ATM. Have a nice day!\n");
                    selectAccount();
                } else {
                    System.out.println("Not a valid input! Please choose one of the available actions.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();
                chosenAction = 0;
            }
        }
    }

}
