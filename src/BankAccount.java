public class BankAccount {

    //class private attributes
    private String firstName;
    private String lastName;
    private double balance;

    //class constructors
    public BankAccount(String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    //class getter & setter
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

    //class string output
    public String toString() {
        return "First Name : " + firstName + "%n" +
                "Last Name : " + lastName + "%n" +
                "Balance : " + balance;
    }

    //class methods
    public void depositBalance(double balance) {
        this.balance += balance;
    }

    public void withdrawBalance(double balance) {
        this.balance -= balance;
    }
}