package Project;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
class NewCustomerLogin extends JFrame
{
    NewCustomerLogin()
    {
        Font f1 = new Font("Calibri",Font.BOLD,40);
        Font f2 = new Font("Calibri",Font.PLAIN,22);
        JLabel l1 = new JLabel("New Costumer Login",JLabel.CENTER);
        l1.setFont(f1);
        JLabel l2 = new JLabel("Enter username",JLabel.CENTER);
        l2.setFont(f2);
        JTextField t1 = new JTextField(10);
        t1.setFont(f2);
        JLabel l3 = new JLabel("Enter password",JLabel.CENTER);
        l3.setFont(f2);
        JTextField t2 = new JTextField(10);
        t2.setFont(f2);
        JLabel l4 = new JLabel("Confirm Passwprd",JLabel.CENTER);
        l4.setFont(f2);
        JTextField t3 = new JTextField(10);
        t3.setFont(f2);
        JButton b1 = new JButton("Save");
        b1.setFont(f2);
        b1.addActionListener(
                a -> {
                    if(t2.getText().equals(t3.getText()))
                    {
                        String url = "jdbc:mysql://localhost:3306/exp10";
                        try(Connection conn = DriverManager.getConnection(url, "", ""))
                        {
                            String sql = "insert into users(username,password) values(?,?)";
                            try(PreparedStatement pst = conn.prepareStatement(sql))
                            {
                                String user = t1.getText();
                                String pass = t2.getText();

                                pst.setString(1,user);
                                pst.setString(2,pass);
                                pst.executeUpdate();

                                JOptionPane.showMessageDialog(null,"Success");
                                new Home();
                                dispose();
                            }
                        }
                        catch (SQLException e)
                        {
                            JOptionPane.showMessageDialog(null,e.getMessage());
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Password should match");
                    }
                }
        );
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(l1);
        c.add(l2);
        c.add(t1);
        c.add(l3);
        c.add(t2);
        c.add(l4);
        c.add(t3);
        c.add(b1);
        setVisible(true);
        setSize(800,450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login");
    }
}
