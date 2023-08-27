public class Savingaccount extends BankAccount{
    private double interest_rate;

    public Savingaccount(String accountHolder,  int account_num,int pincode, double balance,double interest_rate) {
        super("Saving Account",accountHolder, account_num,pincode, balance);
        this.interest_rate=interest_rate;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double interest_rate) {
        this.interest_rate = interest_rate;
    }
    double calculateinterest(){

        return super.getBalance()*(interest_rate/100);
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
    void withdraw(double money) {
            if(money>getBalance()){
                System.out.println("You don not have enough balance in your account");
            }else if(money<=getBalance()&&(money>=0)){
            double rem_bal;
            rem_bal=getBalance()-money;
            setBalance(rem_bal);
            System.out.println(money + " has been deducted successfully");}
            else System.out.println("Invalid input");

        System.out.print("\nYour Current Balance is = "+getBalance());
    }

    @Override
    public String toString() {
        return super.toString()+"\nInterest Rate= "+getInterest_rate()+"%";
    }

    @Override
    public double getBalance() {
        return super.getBalance()+calculateinterest();

    }
}
