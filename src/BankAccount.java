public class BankAccount {
    //class private attributes
    private String firstName;
    private String lastName;
    private String email;
    private Date openingDate;
    private int accountID;
    private double balance;
    private int depositeCount;
    private int withdrawCount;
    private boolean smsAlert;
    private boolean debitCard;
    private int lastAnnualDeduction = 0;

    //class static
    private static int counter;

    //class constructors
    public BankAccount(String firstName, String lastName, Date openingDate, double balance,
                       String email, boolean smsAlert, boolean debitCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.openingDate = openingDate;
        if(balance >= 0)
            this.balance = balance;
        this.email = email;
        accountID = counter;
        ++counter;
    }

    public BankAccount(String firstName, String lastName, Date openingDate, double balance,
                       boolean smsAlert, boolean debitCard) {
        this(firstName, lastName, openingDate, balance, "No Email Provided", smsAlert, debitCard);
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
        if(balance >= 0)
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

    public boolean isSmsAlert() {
        return smsAlert;
    }

    public void setSmsAlert(boolean smsAlert) {
        this.smsAlert = smsAlert;
    }

    public boolean isDebitCard() {
        return debitCard;
    }

    public void setDebitCard(boolean debitCard) {
        this.debitCard = debitCard;
    }

    public int getDepositeCount() {
        return depositeCount;
    }

    public int getWithdrawCount() {
        return withdrawCount;
    }

    public int getLastAnnualDeduction() {
        return lastAnnualDeduction;
    }

    public void setLastAnnualDeduction(int lastAnnualDeduction) {
        this.lastAnnualDeduction = lastAnnualDeduction;
    }

    //class string output
    public String toString() {
        return "AccountID : " + accountID + "\n" +
               "First Name : " + firstName + "\n" +
               "Last Name : " + lastName + "\n" +
               "Opening Date : " + openingDate + "\n" +
               "Balance : " + balance + "\n" +
               "Email : " + email + "\n" +
               "Account Type : " + accountType() +
               "SMS Alert Subscribed : " + smsAlert + "\n" +
               "Debit Card Subscribed : " + debitCard + "\n" +
               "Deposit Count : " + depositeCount + "\n" +
               "Withdraw Count : " + withdrawCount;
    }

    //class methods
    public void depositBalance(double balance) {
        this.balance += balance;
        if (balance >= 100000)
            additionalDeposit(balance);
        ++depositeCount;
    }

    public void withdrawBalance(double balance) {
        if((this.balance - balance) >= 0) {
            this.balance -= balance;
            if (this.balance < 50000)
                taxDeduction();
            ++withdrawCount;
        }
    }

    public void annualDeduction() {
        if (smsAlert)
            smsAlertDeduction();
        if (debitCard)
            debitCardDeduction();
    }

    public String states() {
        return "Account Title : " + firstName + " " + lastName + "\n" +
               "Total deposits : " + depositeCount + "\n" +
               "Total withdraws : " + withdrawCount + "\n" +
               "Balance : " + balance;
    }

    private void additionalDeposit(double balance) {
        this.balance += 0.01 * balance; // additional 1% deposit
    }

    private void taxDeduction() {
        balance -= 0.02 * balance; // 2% tax deduction
    }

    private void smsAlertDeduction() {
        balance -= 2000;
    }

    private void debitCardDeduction() {
        balance -= 5000;
    }

    public String accountType() {
        if (balance >= 3000000)
            return "PREMIUM";
        else
            return "STANDARD";
    }
}