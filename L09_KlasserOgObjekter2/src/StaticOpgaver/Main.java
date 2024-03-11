package StaticOpgaver;

public class Main {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(10000);
        BankAccount ba2 = new BankAccount(5000);
        BankAccount ba3 = new BankAccount(9000);
        BankAccount ba4 = new BankAccount(8000);
        BankAccount ba5 = new BankAccount(7000);
        BankAccount ba6 = new BankAccount(6000);
        BankAccount ba7 = new BankAccount(50002);
        BankAccount ba8 = new BankAccount(50030);
        BankAccount ba9 = new BankAccount(50300);
        BankAccount ba10 = new BankAccount(1000);
        BankAccount ba11 = new BankAccount(7000);
        BankAccount ba12 = new BankAccount(15000);
        BankAccount ba13 = new BankAccount(52000);

        System.out.println(ba11.getBalance(5));
        System.out.println();
        System.out.println(ba5.getBalance(5));
        System.out.println();
        System.out.println(BankAccount.getNumberOfIDs());


    }
}
