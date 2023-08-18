

import java.util.ArrayList;
import java.util.Scanner;
public class Processing {
    ArrayList <Savingaccount> accounts;
    Scanner input;
    public Processing() {
        accounts = new ArrayList<>();
         input = new Scanner(System.in);
    }
    void addAccount(BankAccount obj)
    {
        accounts.add((Savingaccount) obj);
    }

    public void verificaion()
    {
        Savingaccount account;
        while(true) {
            System.out.println("Welcome to ATM");
            Scanner userinput = new Scanner(System.in);
            System.out.println("Enter your Account Number Here");
            int accountnumber = userinput.nextInt();
           // input.nextLine();
            account = findAccount(accountnumber);
            if(account==null){
                System.out.println("Account does not exist");
                continue;
            }
            else
                break;
        }
       int attempts;
        int password;
       for(attempts=3; attempts>0; attempts--)
        {
                System.out.println("Enter 4-Digit Pincode \t\t\t Attempts= "+attempts);
                password=input.nextInt();
                input.nextLine();
            if (account.pincode == password)
                    {
                        System.out.println("Logged In");
                        menu(account);
                        break;
                    }
                    else
                     System.out.println("Wrong Pincode");
                }
                 if(attempts==0)
                System.out.println("Your Account is Blocked !");
        }

    Savingaccount findAccount(int account_num)
    {
        for (Savingaccount s : accounts) {
            if (s.account_num == account_num) {
                System.out.println("Account Holder= " + s.accountholder);
                return s;
            }
        }
        return null;
    }
      void menu(BankAccount obj){
        boolean invalid;
        do {
            System.out.println("1==> Cash Deposit\t\t\t2==>Cash Withdraw\n3==>Check Balance\t\t\t4==>Account Information");
            int choice = input.nextInt();
            input.nextLine();
            double money ;
            switch (choice) {
                case 1:
                    invalid=false;
                    System.out.println("Enter Amount you want to deposit");
                    money = input.nextDouble();
                    input.nextLine();
                    System.out.println(obj.deposit(money));
                    break;
                case 2:
                    invalid=false;
                    System.out.println("Enter Amount you want to withdraw");
                    money = input.nextDouble();
                    input.nextLine();
                    System.out.println(obj.withdraw(money));
                    break;
                case 3:
                    invalid=false;
                    System.out.println("Your Account Balance is " + obj.getBalance());
                    break;
                case 4:
                    invalid=false;
                    System.out.println(obj);
                    break;
                default:
                    System.out.println("Invalid Input");
                    invalid =true;
            }
        }while(invalid);
    }
    

}
