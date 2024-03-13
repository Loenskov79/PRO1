package StaticOpgaver;

public class ATM {

    private BankAccount[] bankAccounts;
    private BankAccount currentAccount;

    public ATM(BankAccount[] bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public BankAccount getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(int accountId) {
        this.currentAccount = bankAccounts[accountId];
    }

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }
}
