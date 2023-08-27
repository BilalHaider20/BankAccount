public class Currentaccount extends BankAccount{

        double transactionlimit;
        public Currentaccount( String accountholder, int account_num, int pincode, double balance) {
            super("Current Account", accountholder, account_num, pincode, balance);
            this.transactionlimit=25000;
        }

        public void setTransactionlimit(double transactionlimit) {
            this.transactionlimit = transactionlimit;
        }

        @Override
        double deposit(double money) {
            double rem_bal;
            rem_bal=getBalance()+money;
            setBalance(rem_bal);
            System.out.println("Rs."+money+" has been deposited successfully");
            System.out.print("Your current Balance is ");
            return getBalance();
        }

        @Override
        void withdraw(double money) {
            if(money>transactionlimit){
                System.out.println("Tansaction limit is: "+transactionlimit);
            }
            else if(money<=transactionlimit) {
                if (money <= getBalance()) {
                    double rem_bal;
                    rem_bal = getBalance() - money;
                    setBalance(rem_bal);
                    System.out.println(money + " has been deducted successfully");
                } else if (money > getBalance()) {
                    System.out.println("You do not have enough balance in account");
                }
                System.out.println("Your account Balance is "+getBalance());
            }
            else
                System.out.println("invalid input");
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


