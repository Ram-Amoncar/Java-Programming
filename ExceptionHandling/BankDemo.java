package ExceptionHandling;

public class BankDemo { 
    public static void main(String[] args) {
        Account acc = new Account(1000001, "Ram Amoncar");
        acc.displayInfo();
        try {
            acc.deposit(-10000);
        } catch (NegativeAmountException e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }
        System.out.println("Balance: " + acc.getBalance());
        try {
            acc.withdraw(1000);
        } catch (MinimumBalanceException | NegativeAmountException e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }
        System.out.println("Balance: " + acc.getBalance());
    }
}
