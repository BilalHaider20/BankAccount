
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Processing {
    ArrayList <BankAccount> accounts;
    Scanner input;
    public Processing() {
        accounts = new ArrayList<>();
         input = new Scanner(System.in);
    }
    void addAccount(BankAccount obj)
    {
        accounts.add( obj);
    }

    public void verificaion()
    {
        BankAccount account;
            System.out.println("Welcome to ATM");
        while(true) {
            int accountnumber=safeinputInt("Enter your Account Number Here");
            account = findAccount(accountnumber);
            if(account==null){
                System.out.println("Account does not exist. Try with correct account number");
                continue;
            }
            else
                break;
        }
       int attempts;
        int password;
       for(attempts=3; attempts>0; )
        {
                    System.out.println("Enter 4-Digit Pincode \t\t\t Attempts= "+attempts);
            while(true) {
                try {
                    password=input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please write 4-digit Pincode");
                    input.nextLine();
                    continue;
                }
            }

            if (account.getpincode() == password)
                    {
                        System.out.println("Logged In");
                        menu(account);
                        break;
                    }
                    else {
                    System.out.println("Wrong Pincode");
                    attempts--;
                    }
                }
                 if(attempts==0)
                System.out.println("Your Account is Blocked !");
        }

    BankAccount findAccount(int account_num)
    {
        for (BankAccount s : accounts) {
            if (s.account_num == account_num) {
                System.out.println("Account Holder= " + s.accountholder);
                return s;
            }
        }
        return null;
    }
    void changepincode(BankAccount obj)
    {  int changepincode=safeinputInt("Enter Old Pincode");

        if(obj.getpincode()==changepincode)
        {   changepincode=safeinputInt("Enter New Pincode");
            obj.setPincode(changepincode);
            System.out.println("Pincode has been changes successfully");
        }
        else
            System.out.println("Pincode is not matched");

    }
      void menu(BankAccount obj){
        boolean invalid=true;
        int choice;
        do {
            while(true)
            {
                try {
                    System.out.println("\t\t\tMENU\n1==> Cash Deposit\t\t\t2==>Cash Withdraw\n3==>Check Balance\t\t\t4==>Account Information\n5==> Change pincode");
                    choice = input.nextInt();
                    input.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("invalid input! Write Number between 1 to 5");
                    input.nextLine();
                    continue;
                }
            }
            double money ;
            switch (choice) {
                case 1:
                    money=safeinputDouble("Enter Amount you want to deposit");
                    money=Math.abs(money);
                    System.out.println(obj.deposit(money));
                    break;
                case 2:

                    boolean balance=true;
                    do {
                       money=safeinputDouble("Enter amount you want to withdraw");
                       money=Math.abs(money);
                        if (money > obj.getBalance()) {
                            System.out.println("You do not have enough balance");
                            balance=true;
                            continue;
                        } else if (money <= obj.getBalance() && money > 0)
                            balance=false;
                            System.out.println(obj.withdraw(money));
                    }while(balance);
                    break;
                case 3:

                    System.out.println("Your Account Balance is " + obj.getBalance());
                    break;
                case 4:
                    System.out.println(obj);
                    break;
                case 5:
                    changepincode(obj);
                    break;
                default:
                    System.out.println("Invalid Input");

            }

            int exit=safeinputInt("Press 0 to back\t\tPress 1 to exit");
            if(exit==0)
                invalid =true;
            else if(exit==1) {
                System.out.println("Exiting ! Bank Account");
                invalid = false;
            }
        }while(invalid);
    }
    public int safeinputInt(String prompt) {
        int safeinput;
        while (true)
        {
                try {
                    System.out.println(prompt);
                    safeinput=input.nextInt();
                    input.nextLine();
                    break;
                }
                catch(Exception e){
                    System.out.println("Invalid Input! Please enter a valid Integer input");
                    input.nextLine();
                }
        }
        return safeinput;
    }public double safeinputDouble(String prompt) {
        double safeinput;
        while (true)
        {
                try {
                    System.out.println(prompt);
                    safeinput=input.nextInt();
                    input.nextLine();
                    break;
                }
                catch(Exception e){
                    System.out.println("Invalid Input! Please enter a valid Integer input");
                    input.nextLine();
                }
        }
        return safeinput;
    }
    

}
