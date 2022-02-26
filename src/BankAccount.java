public class BankAccount {

    //class private attributes
    private String firstName;
    private String lastName;
    private String email;
    private final int accountID;
    private double balance;

    //class static
    private static int counter;

    //class constructors
    public BankAccount(String firstName, String lastName, double balance, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.email = email;
        accountID = counter;
        ++counter;
    }

    public BankAccount(String firstName, String lastName, double balance) {
        this(firstName, lastName, balance, "No Email Provided");
    }

    //class getter & setter
    public int getAccountID() {
        return accountID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //class string output
    public String toString() {
        return "AccountID : " + accountID + "\n" +
                "First Name : " + firstName + "\n" +
                "Last Name : " + lastName + "\n" +
                "Balance : " + balance + "\n" +
               "Email : " + email;
    }

    //class methods
    public void depositBalance(double balance) {
        this.balance += balance;
    }

    public void withdrawBalance(double balance) {
        this.balance -= balance;
    }
}