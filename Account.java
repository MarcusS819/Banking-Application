import java.text.NumberFormat;

public abstract class Account 
{

    private int accountNumber;
    protected double balance;

    public Account(int accountNumber)
    {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public double getBalance()
    {   
        return this.balance;
    }

    public int getAccountNumber()
    {
        return this.accountNumber;
    }

    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String result = "";

        result += "--------------------------------------------------------\n";
        result += "Account Number: " + getAccountNumber() + "\n";
        result += "Balance: " + fmt.format(getBalance()) + "\n";

        return result;
    }

    public abstract String deposit(double amount);

    public abstract String withdraw(double amount);

}