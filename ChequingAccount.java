import java.text.NumberFormat;

public class ChequingAccount extends Account {

    private static double FEE = 3.00;

    public ChequingAccount(int accountNumber)
    {
        super(accountNumber);
    }

    @Override
    public String deposit(double amount) 
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        String result = "";

        /*
         * Deposit amount as long as (amount - FEE) 
         * is not negative
         */
        if ((amount - FEE) >= 0)
        {
            result += "--------------------------------------------------------\n";
            result += "Current balance:" + " " + fmt.format(balance) + "\n";
            result +="Depositing..." + " " + fmt.format(amount) + "\n";
            balance += amount;

            result += "Applying fee for deposit... " + fmt.format(FEE) + "\n";
            balance -= FEE;
            result += "New Balance:" + " " + fmt.format(balance) + "\n";
            result += "--------------------------------------------------------\n";
        }
        else
        {
            result += "Cannot deposit $0 or a negative amount, or deposit amount with fee ($3) gives a negative amount.\n";
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
             * Withdraw amount as long as (amount + fee) is lower
             * than the current acount balance
             */
            if ((amount + FEE) <= balance)
            {
                result += "--------------------------------------------------------\n";
                result += "Current balance:" + " " + fmt.format(balance) + "\n";
                result += "Withdrawing..." + " " + fmt.format(amount) + "\n";
                balance -= amount;

                result += "Applying fee for withdraw... " + fmt.format(FEE) + "\n";
                balance -= FEE;
                result += "New Balance:" + " " + fmt.format(balance) + "\n";
                result += "--------------------------------------------------------\n";
            }
            else
            {
                result += "--------------------------------------------------------\n";
                result += "Amount to withdraw along with fee is greater than balance. Cannot withdraw\n";
                result += "--------------------------------------------------------\n";
            }
        }
        else
        {
            result += "--------------------------------------------------------\n";
            result += "Cannot deposit $0 or a negative amount\n";
            result += "--------------------------------------------------------\n";
        }

        return result;
    }
    
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String result = super.toString();

        result += "Deposit/Withdrawal Fee: " + fmt.format(FEE) + "\n";
        result += "--------------------------------------------------------\n";

        return result;
    }
}

