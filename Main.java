

public class Main {
    public static void main(String[] args) {
        BankAccount A1 = new Savingaccount("Bilal", 12345, 1234, 5000);
        BankAccount A2 = new Savingaccount("Ali", 67890, 6789, 15000);
        BankAccount A3 = new Savingaccount("Shahzaib", 54321, 5432, 10000);
        Processing process = new Processing();
        process.addAccount(A1);
        process.addAccount(A2);
        process.addAccount(A3);

        process.verificaion();
    }
}