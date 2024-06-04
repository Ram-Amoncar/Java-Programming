package ExceptionHandling;

public class Account {
    private long accNumber;
    private String accHolder;
    private int balance;
    private final int MINIMUM_BALANCE=1000;
    public Account(){
        this.accNumber=0;
        this.accHolder="";
        this.balance=MINIMUM_BALANCE;
    }

    public Account(long accNumber, String accHolder) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.balance=MINIMUM_BALANCE;
    }
    public void deposit(int amt) throws NegativeAmountException{
        if (amt<0){
            throw new NegativeAmountException();
        }else {
            balance+=amt;
        }
    }
    public void withdraw(int amt)throws NegativeAmountException,MinimumBalanceException{
        if (amt<0){
            throw new NegativeAmountException();
        }else if(balance-amt<MINIMUM_BALANCE){
            throw new MinimumBalanceException();
        }else {
            balance-=amt;
        }
    }
    public int getBalance() {
        return balance;
    }

    public void displayInfo(){
        System.out.println("Account Number: "+accNumber+
                "\nAccount Holder: "+accHolder+
                "\nBalance: "+balance);
    }
}
