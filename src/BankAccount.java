public class BankAccount {

    //class private attributes
    private String firstName;
    private String lastName;
    private String email;
    private Date openingDate;
    private final int accountID;
    private double balance;
    private int depositeCount;
    private int withdrawCount;

    //class static
    private static int counter;

    //class constructors
    public BankAccount(String firstName, String lastName, Date openingDate, double balance, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.openingDate = openingDate;
        this.balance = balance;
        this.email = email;
        accountID = counter;
        ++counter;
    }

    public BankAccount(String firstName, String lastName, Date openingDate, double balance) {
        this(firstName, lastName, openingDate, balance, "No Email Provided");
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

    public Date getOpeningDate() {
        return openingDate;
    }

    //class string output
    public String toString() {
        return "AccountID : " + accountID + "\n" +
               "First Name : " + firstName + "\n" +
               "Last Name : " + lastName + "\n" +
               "Opening Date : " + openingDate + "\n" +
               "Balance : " + balance + "\n" +
               "Email : " + email;
    }

    //class methods
    public void depositBalance(double balance) {
        this.balance += balance;
        if(balance >= 100000)
            additionalDeposit(balance);
        ++depositeCount;
    }

    public void withdrawBalance(double balance) {
        this.balance -= balance;
        if(this.balance < 50000)
            taxDeduction();
        ++withdrawCount;
    }

    private void additionalDeposit(double balance) {
        this.balance += 0.01 * balance; // additional 1% deposit
    }

    private void taxDeduction() {
        balance -= 0.02 * balance; // 2% tax deduction
    }

    public String states() {
        return "Account Title : " + firstName + " " + lastName + "\n" +
               "Total deposits : " + depositeCount + "\n" +
               "Total withdraws : " + withdrawCount + "\n" +
               "Balance : " + balance;
    }
}