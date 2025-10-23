package pass;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    public Login() {
        setTitle("Bus Pass System - Choose User Type");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Select User Type", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel(new GridLayout(2, 1, 20, 20));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));

        JButton btnStudent = new JButton("Student");
        JButton btnAdmin = new JButton("Admin");

        btnPanel.add(btnStudent);
        btnPanel.add(btnAdmin);
        add(btnPanel, BorderLayout.CENTER);

        btnStudent.addActionListener(e -> {
            dispose();
            new BusPass(); // student bus pass generator
        });

        btnAdmin.addActionListener(e -> {
            dispose();
            new AdminLogin(); // admin login page
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Login::new);
    }
}

//---------- ADMIN LOGIN ----------

class AdminLogin extends JFrame {
 private JTextField tfUsername;
 private JPasswordField pfPassword;
 private JButton btnLogin,btnBack;

 public AdminLogin() {
     setTitle("Admin Login - Bus Pass System");
     setSize(400, 250);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLayout(new BorderLayout(10, 10));
     setLocationRelativeTo(null);

     JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
     panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

     JLabel lblUser = new JLabel("Username:");
     JLabel lblPass = new JLabel("Password:");

     tfUsername = new JTextField();
     pfPassword = new JPasswordField();
     btnLogin = new JButton("Login");
     btnBack=new JButton("Back");

     panel.add(lblUser);
     panel.add(tfUsername);
     panel.add(lblPass);
     panel.add(pfPassword);
     panel.add(new JLabel(""));
     JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
     btnPanel.add(btnLogin);
     btnPanel.add(btnBack);
     panel.add(btnPanel);
    

     add(panel, BorderLayout.CENTER);

     btnLogin.addActionListener(this::handleLogin);
     btnBack.addActionListener(e ->{
    	 dispose();
    	 new Login();
     });

     setVisible(true);
 }

 private void handleLogin(ActionEvent e) {
     String username = tfUsername.getText().trim();
     String password = new String(pfPassword.getPassword());

     if (username.equals("admin") && password.equals("1234")) {
         JOptionPane.showMessageDialog(this, "Login Successful!");
         dispose();
         new AdminDashboard();
     } else {
         JOptionPane.showMessageDialog(this, "Invalid credentials!", "Error", JOptionPane.ERROR_MESSAGE);
     }
 }
}