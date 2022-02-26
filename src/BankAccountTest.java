import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        String firstName;
        String lastName;
        double balance;

        Scanner read = new Scanner(System.in);

        System.out.println("ACCOUNT OPENING DETAIL");
        System.out.print("First Name : ");
        firstName = read.nextLine();
        System.out.print("Last Name : ");
        lastName = read.nextLine();
        System.out.print("Balance : ");
        balance = read.nextDouble();

        BankAccount account1 = new BankAccount(firstName, lastName, balance);

        System.out.println("MENU");
        System.out.println("Press 1: To Deposit an amount\n" +
                           "Press 2: To Withdraw an amount\n" +
                           "Press 3: To View the current balance\n" +
                           "Press 4: To Close this program");

        System.out.print("Option : ");
        switch (read.nextByte()) {
            case 1:
                System.out.println("DEPOSIT BALANCE");
                System.out.print("Enter Amount : ");
                account1.depositBalance(read.nextDouble());
                break;
            case 2:
                System.out.println("WITHDRAW BALANCE");
                System.out.print("Enter Amount : ");
                account1.withdrawBalance(read.nextDouble());
                break;
            case 3:
                System.out.println("CURRENT BALANCE");
                System.out.println("Current Balance : " + account1.getBalance());
                break;
            case 4:
                System.out.print("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid Option");
        }
    }
}
