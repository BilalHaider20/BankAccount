public class Savingaccount extends BankAccount{
   private  double interest_rate;

    public Savingaccount(String accountHolder,  int account_num,int pincode, double balance) {
        super(accountHolder, account_num,pincode, balance);
        //this.interest_rate = interest_rate;
    }
    //Savingaccount(){}
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
        System.out.println(rem_bal+"Rs has been deposited successfully");
        System.out.println("Your current Balance is ");
        return getBalance();
    }

    @Override
    double withdraw(double money) {

        if(money>getBalance())
        {
            System.out.println("Insufficient Balance");
        }
        else if(money<=getBalance() && money>0)
        {
            double rem_bal;
            rem_bal=getBalance()-money;
            setBalance(rem_bal);
            System.out.println(money + " has been deducted successfully");
        }
        System.out.print("\nYour Current Balance is = ");
        return getBalance();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
