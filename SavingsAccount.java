import java.text.NumberFormat;

public class SavingsAccount extends Account
{

    private static double INTEREST_RATE = 1.025;

    public SavingsAccount(int accountNumber)
    {
        super(accountNumber);
    }

    public double getInterestRate()
    {
        return INTEREST_RATE;
    }

    public String applyInterest()
    {   
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String result = "";

        // Apply Interest
        result += "--------------------------------------------------------\n";
        result += "Current balance:" + " " + fmt.format(balance) + "\n";
        result += "Applying interest...\n";
        balance = balance * getInterestRate();
        result +=("New Balance:" + " " + fmt.format(balance)) + "\n";
        result += "--------------------------------------------------------\n";

        return result;
    }

    @Override
    public String deposit(double amount) {
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String result = "";

         /*
         * Deposit amount as long as amount is not negative or 0
         */
        if (amount > 0)
        {
            result += "--------------------------------------------------------\n";
            result += "Current balance:" + " " + fmt.format(balance) + "\n";
            result += "Depositing" + " " + fmt.format(amount) + "...\n";
            balance += amount;
            result +=("New Balance:" + " " + fmt.format(balance)) + "\n";
            result += "--------------------------------------------------------\n";
        }
        else
        {
            result += "--------------------------------------------------------\n";
            result += "Cannot deposit $0 or a negative amount\n";
            result += "--------------------------------------------------------\n";
        }

        return result;
    }

    @Override
    public String withdraw(double amount) 
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String result = "";
         /*
         * Withdraw amount as long as amount is not 0
         * or negative
         */
        if (amount > 0)
        {
             /*
             * Withdraw amount as long as amount lower than the blaance
             */
            if (amount <= balance)
            {
                result += "--------------------------------------------------------\n";
                result += "Current balance:" + " " + fmt.format(balance) + "\n";
                result += "Withdrawing" + " " + fmt.format(amount) + "...\n";
                balance -= amount;
                result += "New Balance:" + " " + fmt.format(balance) + "\n";
                result += "--------------------------------------------------------\n";
            }
            else
            {
                result += "--------------------------------------------------------\n";
                result += "Amount to withdraw is greater than balance. Cannot withdraw\n";
                result += "--------------------------------------------------------\n";
            }
        }
        else
        {
            result += "--------------------------------------------------------\n";
            result += "Cannot withdraw $0 or a negative amount\n";
            result += "--------------------------------------------------------\n";
        }

        return result;
    }

    public String toString()
    {
        String result = super.toString();

        result += "Savings Account Interest Rate: " + INTEREST_RATE + "\n";
        result += "--------------------------------------------------------\n";

        return result;
    }
}
