package Project;

import javax.swing.*;
import java.awt.*;
class Login extends JFrame
{
    Login()
    {
        Font f1 = new Font("Calibri",Font.BOLD,40);
        Font f2 = new Font("Calibri",Font.PLAIN,22);
        JLabel l1 = new JLabel("Welcome",JLabel.CENTER);
        l1.setFont(f1);
        JButton b1 = new JButton("New Customer");
        JButton b2 = new JButton("Existing Customer");
        JButton b3 = new JButton("Admin");
        b1.addActionListener(
                a-> {
                    new NewCustomerLogin();
                    dispose();
                }

        );
        b2.addActionListener(
                a->{
                    new ExistingCustomerLogin();
                    dispose();
                }
        );
        b3.addActionListener(
                a->{
                    new AdminLogin();
                    dispose();
                }
        );
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l1);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        setVisible(true);
        setSize(800,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");
    }
}
