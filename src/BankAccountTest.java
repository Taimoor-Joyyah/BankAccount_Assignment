import java.time.LocalDate;
import java.util.Scanner;

public class BankAccountTest {
    public static void main(String[] args) {
        String firstName;
        String lastName;
        double balance;
        boolean smsAlert;
        boolean debitCard;

        LocalDate today = LocalDate.now();

        Scanner read = new Scanner(System.in);

        System.out.println("ACCOUNT OPENING DETAIL");
        System.out.print("Enter your first name : ");
        firstName = read.nextLine();
        System.out.print("Enter your last name : ");
        lastName = read.nextLine();
        System.out.print("Enter Opening Balance : ");
        balance = read.nextDouble();
        System.out.print("Do you want SMS Alert? (true or false) : ");
        smsAlert = read.nextBoolean();
        System.out.print("Do you want Debit Card? (true or false) : ");
        debitCard = read.nextBoolean();


        BankAccount account = new BankAccount(firstName, lastName,
                new Date(today.getDayOfMonth(), today.getMonthValue(), today.getYear()),
                balance, smsAlert, debitCard);

        System.out.println("MENU");
        System.out.println("Press 1: To Deposit an amount\n" +
                           "Press 2: To Withdraw an amount\n" +
                           "Press 3: To View the current balance\n" +
                           "Press 4: To Close this program");

        while (true) {
            System.out.print("Option : ");
            switch (read.nextByte()) {
                case 1:
                    System.out.print("Enter the amount you want to deposit in your account > ");
                    account.depositBalance(read.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter the amount you want to withdraw from your account > ");
                    double withdrawAmount = read.nextDouble();
                    if((account.getBalance() - withdrawAmount) < 50000) {
                        System.out.println("Are you sure you want to withdraw, " +
                                           "it would make your balance below 50,000. " +
                                           "Press 1 to continue and 0 to abort");
                        System.out.print("Option : ");
                        if(read.nextByte() == 1)
                            account.withdrawBalance(withdrawAmount);
                    }
                    break;
                case 3:
                    System.out.println("Your current Balance is " + account.getBalance());
                    break;
                case 4:
                    System.out.println(account.states());
                    System.exit(0);
                default:
                    System.out.println("Invalid Option...");
            }
            if((account.getLastAnnualDeduction() != today.getYear()) && (today.getDayOfMonth() == 31) &&
               (today.getMonthValue() == 12)) {
                System.out.println(account);
                if(account.accountType().equals("STANDARD")) {
                    account.annualDeduction();
                    System.out.println("Your Account Balance : " + account.getBalance());
                }
                account.setLastAnnualDeduction(today.getYear());
            }
        }
    }
}
