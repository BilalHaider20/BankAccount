public abstract class BankAccount {
    String accountholder;
    int pincode;
    int account_num;
   private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(String accountholder, int account_num,int pincode, double balance) {
        this.accountholder = accountholder;
        this.pincode = pincode;
        this.account_num = account_num;
        this.balance = balance;
    }
    //BankAccount(){}
    abstract double deposit(double money);
    abstract double withdraw(double money);
    public String toString(){
        return"Account Holder= "+accountholder+"\nAccount number= "+account_num+"\nAccount Balance= "+getBalance();
    }
}
