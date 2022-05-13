
public class BankAccount {
    private String name;
    private int accountNumber;
    private double balance;

    public BankAccount(){
    }
    public BankAccount(String name, int accountNumber){
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public BankAccount (String name, int accountNumber, double balance) {
        this.balance = balance;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public double deposit(double amount) {
        return balance += amount;
    }

    public double withdraw(double amount) {
        return balance -= amount;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String newName){
        this.name = newName;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }
    /*public void setAccountNumber(int newNumber){
        this.accountNumber = newNumber;
    }*/

    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }

    public void transfer(BankAccount account, double amount){
        this.withdraw(amount);
        account.deposit(amount);
    }

    public void accountDetails() {
        System.out.println(this.name + "'s account balance: " + this.balance);
    }
}