public class Savingaccount extends BankAccount{
   private  double interest_rate;

    public Savingaccount(String accountHolder,  int account_num,int pincode, double balance) {
        super(accountHolder, account_num,pincode, balance);
        //this.interest_rate = interest_rate;
    }

    void setInterest_rate(double interest_rate){
        this.interest_rate=interest_rate;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    @Override
    double deposit(double money) {

        double rem_bal;
        rem_bal=getBalance()+money;
        setBalance(rem_bal);
        System.out.println("Rs."+rem_bal+" has been deposited successfully");
        System.out.print("Your current Balance is ");
        return getBalance();
    }

    @Override
    double withdraw(double money) {
            double rem_bal;
            rem_bal=getBalance()-money;
            setBalance(rem_bal);
            System.out.println(money + " has been deducted successfully");

        System.out.print("\nYour Current Balance is = ");
        return getBalance();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
