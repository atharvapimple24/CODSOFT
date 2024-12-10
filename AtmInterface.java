import java.util.Scanner;

class BankAccount{
    private float balance;

    public BankAccount(float initialBalance){
        this.balance = initialBalance;
    }
    public float getBalance(){
        return balance;
    }
    public void deposit(float amount){
        balance += amount;
    }
    public boolean withdraw(float amount){
        if(amount>balance){
            return false;
        }
        balance -= amount;
        return true;
    }
}

class ATM{
//    float balance;
    private  BankAccount account;
    private final int PIN = 2408;

    public  ATM(BankAccount account){
        this.account = account;
    }
    public void checkPin(){
        System.out.println("Enter a Pin: ");
        Scanner scanner = new Scanner(System.in);
        int enteredPin = scanner.nextInt();
        if(enteredPin == PIN){
            menu();
        }
        else{
            System.out.println("Enter a vaild pin");
            checkPin();
        }
    }
    public void menu(){
        System.out.println("Enter a choice:");
        System.out.println("1.Check balance");
        System.out.println("2.Deposit Money");
        System.out.println("3.Withdraw Money");
        System.out.println("4.Exit");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using our services :)");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public void checkBalance(){
        System.out.println("Balance: "+account.getBalance());
        menu();
    }
    public void deposit(){
        System.out.println("Enter amount to deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if(amount<0){
            System.out.println("Enter a valid amount");
        }
        else{
            account.deposit(amount);
            System.out.println("Money deposited successfully");
        }
        menu();
    }
    public void withdraw(){
        System.out.println("Enter amount to withdraw:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if(amount<=0){
            System.out.println("Enter a valid amount");
        } else if (account.withdraw(amount)) {
            System.out.println("Money withdrawed successfully");
        }
        else{
            System.out.println("Enter a valid amount");
        }
        menu();
    }
}

public class AtmInterface {
    public static void main(String[] args){
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        atm.checkPin();
    }
}
