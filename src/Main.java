import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);


        BankAccount larry = new BankAccount("Larry", 10001, 5000);
        larry.withdraw(100);
        BankAccount mary = new BankAccount("Mary", 10002, 300);
        mary.deposit(100);

        accounts.add(larry);
        accounts.add(mary);
        System.out.println(accounts);

        System.out.println("Hello world! Welcome to the Bank of Matt!");
        System.out.println("Are you an existing customer? (-1 to exit)");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int input = Integer.parseInt(scan.nextLine());
        if(input == 2){
            System.out.println("Let's make an account!");
            BankAccount newAccount = new BankAccount();
            System.out.println("What is the name for the account?");
            String inputName = scan.nextLine();
            newAccount.setName(inputName);
            System.out.println("What is the beginning balance for the account?");
            double inputBalance = Double.parseDouble(scan.nextLine());
            newAccount.setBalance(inputBalance);
            accounts.add(newAccount);

            // mainMenu(accounts.get(accounts.size() - 1));
        } else if(input == 1){
            System.out.println("Great what is your account number? ");
            int accountNumber = Integer.parseInt(scan.nextLine());

            boolean isAccountHolder = false;
            int index = -1;

            for(int i = 0; i < accounts.size(); i++){
                BankAccount acc = accounts.get(i);
                if(accountNumber == acc.getAccountNumber()){
                    isAccountHolder = true;
                    index = i;
                }
            }
            if(isAccountHolder){
                mainMenu(accounts.get(index));
            }
            else if(input == -1){
                System.out.println("Good Bye!");
            }else {
                System.out.println("Sorry, we couldn't find your account number.");
            }
        }
    }

    public static void mainMenu(BankAccount account){
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello " + account.getName());
        System.out.println("Welcome to the main menu, what would you like to do?");
        System.out.println("1. Check Account Balanace ");
        System.out.println("2. Make A Withdrawal ");
        System.out.println("3. Make A Deposit");
        System.out.println("4. Transfer funds ");

        int response = Integer.parseInt(scan.nextLine());
        while(response != 0){
            if(response == 1){
                account.getBalance();
            }else if(response == 2){
                double withdrawAmount = Double.parseDouble(scan.nextLine());
                account.withdraw(withdrawAmount);
                System.out.println("The amount: " + withdrawAmount + " has been withdrawn from your account");
            } else if(response ==3 ){
                double depositAmount = Double.parseDouble(scan.nextLine());
                account.deposit(depositAmount);
                System.out.println("The amount: " + depositAmount + " was deposited to your account");
            } else if(response == 4){
                System.out.println("Please enter the account number to transfer to");
                int accountToTransferTo = Integer.parseInt(scan.nextLine());
                BankAccount toTransferTo = new BankAccount();
                boolean isAccountHolder = false;
                int index = -1;

                for(int i = 0; i < accounts.size(); i++){
                    BankAccount accs = accounts.get(i);
                    if(accountToTransferTo == accs.getAccountNumber()){
                        isAccountHolder = true;
                        index = i;
                    }
                }
                if(isAccountHolder){
                    System.out.println("How much would you like to transfer ");
                    double transferAmount = Double.parseDouble(scan.nextLine());

                    account.transfer(toTransferTo, transferAmount);
                    System.out.println(account.getName() + " moved " + transferAmount + " and now has " + account.getBalance());
                    System.out.println(toTransferTo.getName() + " was give " + transferAmount + " and now has " + toTransferTo.getBalance());
                    break;
                } else {
                    System.out.println("Sorry, we couldn't find an account with that account number");
                }
                break;
            }else if(response ==0){
                System.out.println("Good bye!");
                break;
            }
        }
    }

}