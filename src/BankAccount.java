public abstract class BankAccount {
    String accounttype;
    String accountholder;
    private int pincode;
    int account_num;
   private double balance;
   public int getpincode(){return pincode;}
    public void setPincode(int pincode){this.pincode=pincode;}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(String accounttype,String accountholder, int account_num,int pincode, double balance) {
       this.accounttype=accounttype;
        this.accountholder = accountholder;
        this.pincode = pincode;
        this.account_num = account_num;
        this.balance = balance;
    }

    abstract double deposit(double money);
    abstract void withdraw(double money);
    public String toString(){
        return"Account Type: "+accounttype+"\nAccount Holder= "+accountholder+"\nAccount number= "+account_num+"\nAccount Balance= "+getBalance();
    }
}
