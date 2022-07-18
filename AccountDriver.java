import javax.swing.JFrame;

public class AccountDriver 
{
    public static void main (String[] args)
    {
        JFrame frame = new AccountFrame();
        frame.setTitle("Banking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}