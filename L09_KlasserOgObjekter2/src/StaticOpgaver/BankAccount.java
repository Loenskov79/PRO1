package StaticOpgaver;
public class BankAccount {

    private double balance;
    private static int numberOfIDs = 0;
    private int ID;

    public BankAccount(double balance) {
        this.balance = balance;
        numberOfIDs++;
        ID = numberOfIDs;
    }

    public static int getNumberOfIDs() {
        return numberOfIDs;
    }

    public int getID() {
        return ID;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw (double amount){
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getBalance(int years) {
        System.out.println("Your initial balance is " + balance + " and your balance after " + years + " years is: ");
        if(ID <= 10) {
            double yearlyRate = 0.05;
            return balance * Math.pow(1 + yearlyRate,years);
        } else {
            double yearlyRate2 = 0.035;
            return balance * Math.pow(1 + yearlyRate2, years);
        }
    }
}
