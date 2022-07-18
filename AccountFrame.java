import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class AccountFrame extends JFrame
{
    private static final int FRAME_WIDTH = 750;
    private static final int FRAME_HEIGHT = 500;

    private static final int AREA_ROWS = 25;
    private static final int AREA_COLUMNS = 25;
    
    private JTextArea resultConsole;

    private JLabel savingsDepositLabel, savingsWithdrawLabel;
    private JLabel chequingDepositLabel, chequingWithdrawLabel;

    private JTextField savingsDepositField, savingsWithdrawField;
    private JTextField chequingDepositField, chequingWithdrawField;

    private JButton savingsDepositButton, savingsWithdrawButton, savingsInterestButton, savingsInformationButton;
    private JButton chequingDepositButton, chequingWithdrawButton, chequingInformationButton;

    Account savingsAcc1 = new SavingsAccount(1536251032);
    Account chequingAcc1 = new ChequingAccount(1536255510);

    public AccountFrame()
    {

        resultConsole = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        resultConsole.setEditable(false);

        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
    }

    class doSavingsDeposit implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try 
            {
                resultConsole.append(savingsAcc1.deposit(Double.parseDouble(savingsDepositField.getText())));
            }
            catch (NumberFormatException exception)
            {
                resultConsole.append("--------------------------------------------------------\n");
                resultConsole.append("Amount to deposit is not a value.\n");
                resultConsole.append("--------------------------------------------------------\n");
            }
        }
    }

    class doSavingsWithdraw implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try 
            {
                resultConsole.append(savingsAcc1.withdraw(Double.parseDouble(savingsWithdrawField.getText())));
            }
            catch (NumberFormatException exception)
            {
                resultConsole.append("--------------------------------------------------------\n");
                resultConsole.append("Amount to withdraw is not a value.\n");
                resultConsole.append("--------------------------------------------------------\n");
            }
        }
    }

    class applySavingsInterest implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            resultConsole.append(((SavingsAccount)savingsAcc1).applyInterest());
        }
    }

    class doChequingDeposit implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try 
            {
                resultConsole.append(chequingAcc1.deposit(Double.parseDouble(chequingDepositField.getText())));
            }
            catch (NumberFormatException exception)
            {   
                resultConsole.append("--------------------------------------------------------\n");
                resultConsole.append("Amount to deposit is not a value.\n");
                resultConsole.append("--------------------------------------------------------\n");
            }
        }
    }

    class doChequingWithdraw implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try 
            {
                resultConsole.append(chequingAcc1.withdraw(Double.parseDouble(chequingWithdrawField.getText())));
            }
            catch (NumberFormatException exception)
            {   
                resultConsole.append("--------------------------------------------------------\n");
                resultConsole.append("Amount to withdraw is not a value.\n");
                resultConsole.append("--------------------------------------------------------\n");
            }
        }
    }

    class getSavingsInformation implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            resultConsole.append(savingsAcc1.toString());
        }
    }

    class getChequingInformation implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            resultConsole.append(chequingAcc1.toString());
        }
    }

    private JPanel createSavingsPanel()
    {
        JPanel panel = new JPanel();

        // Savings Account Buttons
        savingsDepositButton = new JButton("Deposit");
        ActionListener savingsDeposit = new doSavingsDeposit();
        savingsDepositButton.addActionListener(savingsDeposit);

        savingsWithdrawButton = new JButton("Withdraw");
        ActionListener savingsWithdraw = new doSavingsWithdraw();
        savingsWithdrawButton.addActionListener(savingsWithdraw);

        // Savings Panel Labels and Fields
        final int FIELD_WIDTH = 10;

        savingsDepositLabel = new JLabel("Enter Amount to Deposit");
        savingsWithdrawLabel = new JLabel("Enter Amount to Withdraw");

        savingsDepositField= new JTextField(FIELD_WIDTH);
        savingsWithdrawField = new JTextField(FIELD_WIDTH);

        // Add Buttons, Labels, and Fields to panel
        panel.add(savingsDepositLabel);
        panel.add(savingsDepositField);
        panel.add(savingsDepositButton);

        panel.add(savingsWithdrawLabel);
        panel.add(savingsWithdrawField);
        panel.add(savingsWithdrawButton);

        panel.setBorder(new TitledBorder(new EtchedBorder(), "Savings Account Options"));
        return panel;
    }

    private JPanel createChequingPanel()
    {
        JPanel panel = new JPanel();

        // Chequing Account Buttons
        chequingDepositButton = new JButton("Deposit");
        ActionListener chequingDeposit = new doChequingDeposit();
        chequingDepositButton.addActionListener(chequingDeposit);

        chequingWithdrawButton = new JButton("Withdraw");
        ActionListener chequingWithdraw = new doChequingWithdraw();
        chequingWithdrawButton.addActionListener(chequingWithdraw);

        chequingDepositLabel = new JLabel("Enter Amount to Deposit");
        chequingWithdrawLabel = new JLabel("Enter Amount to Withdraw");

        // Chequing Panel Labels and Fields
        final int FIELD_WIDTH = 10;
        chequingDepositField= new JTextField(FIELD_WIDTH);
        chequingWithdrawField = new JTextField(FIELD_WIDTH);

        panel.add(chequingDepositLabel);
        panel.add(chequingDepositField);
        panel.add(chequingDepositButton);

        panel.add(chequingWithdrawLabel);
        panel.add(chequingWithdrawField);
        panel.add(chequingWithdrawButton);

        panel.setBorder(new TitledBorder(new EtchedBorder(), "Chequing Account Options"));

        return panel;
    }

    private JPanel createSavingsActionsPanel()
    {
        JPanel panel = new JPanel();

        savingsInformationButton = new JButton("Savings Account Information");
        ActionListener savingsInformation = new getSavingsInformation();
        savingsInformationButton.addActionListener(savingsInformation);

        savingsInterestButton = new JButton("Apply Savings Interest");
        ActionListener applyInterest = new applySavingsInterest();
        savingsInterestButton.addActionListener(applyInterest);

        panel.add(savingsInformationButton);
        panel.add(savingsInterestButton);

        panel.setBorder(new TitledBorder(new EtchedBorder(), "Savings Account Actions"));

        return panel;
    }
    private JPanel createChequingActionsPanel()
    {
        JPanel panel = new JPanel();

        chequingInformationButton = new JButton("Chequing Account Information");
        ActionListener chequingInformation = new getChequingInformation();
        chequingInformationButton.addActionListener(chequingInformation);

        panel.add(chequingInformationButton);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Chequing Account Actions"));

        return panel;
    }

    public void createPanel()
    {
        JPanel savingsAccountPanel = createSavingsPanel();
        JPanel chequingAccountPanel = createChequingPanel();
        JPanel savingsActions = createSavingsActionsPanel();
        JPanel chequingActions = createChequingActionsPanel();

        JPanel panel = new JPanel();
        panel.add(savingsAccountPanel);
        panel.add(savingsActions);
        panel.add(chequingAccountPanel);
        panel.add(chequingActions);

        panel.setLayout(new GridLayout(5, 2));
        

        JScrollPane scrollPane = new JScrollPane(resultConsole);
        panel.add(scrollPane);
        add(panel, BorderLayout.WEST);
    }
}