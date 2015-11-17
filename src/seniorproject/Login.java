package seniorproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author Santa Cardenas - Team Apollo Fall 2015 
 */
public class Login extends JDialog {
 
    private boolean succeeded;
    private JButton jButtonLogin;
    private JButton jButtonCancel;
    private JLabel jLabelPassword;
    private JLabel jLabelUsername;
    private JLabel jLabelCredentials;
    private JPasswordField jPasswordField;
    private JTextField jTextFieldUsername;
    static JFrame frame = new JFrame("Video GPS Screen");
    
    public Login(Frame parent) {
        super(parent, "Apollo | Driver Login", true);
        setSize(new Dimension(490, 350)); 
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints DriverPanel = new GridBagConstraints();
 
        DriverPanel.fill = GridBagConstraints.HORIZONTAL;
 
        jLabelCredentials = new JLabel ("Enter your login credentials.");
        jLabelCredentials.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        jLabelCredentials.setForeground(Color.WHITE);
        
        jLabelUsername = new JLabel("Username: ");
        jLabelUsername.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
        jLabelUsername.setForeground(Color.WHITE);
        DriverPanel.gridx = 0;
        DriverPanel.gridy = 1;
        DriverPanel.gridwidth = 1;
        panel.add(jLabelUsername, DriverPanel);
 
        jTextFieldUsername = new JTextField(20);
        jTextFieldUsername.setOpaque(true);
        DriverPanel.gridx = 1;
        DriverPanel.gridy = 1;
        DriverPanel.gridwidth = 2;
        panel.add(jTextFieldUsername, DriverPanel);
 
        jLabelPassword= new JLabel("Password: ");
        jLabelPassword.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 16));
        jLabelPassword.setForeground(Color.WHITE);
        DriverPanel.gridx = 0;
        DriverPanel.gridy = 2;
        DriverPanel.gridwidth = 1;
        panel.add(jLabelPassword, DriverPanel);
 
        jPasswordField = new JPasswordField(20);
        jPasswordField.setOpaque(true);
        DriverPanel.gridx = 1;
        DriverPanel.gridy = 2;
        DriverPanel.gridwidth = 2;
        
        setLayout(null);
        setLayout(new BorderLayout());

        setContentPane(new JLabel(new ImageIcon(getClass().getResource("LoginImage.png")))); 
        panel.add(jPasswordField, DriverPanel);
        panel.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
        panel.setBackground(new Color(0, 0, 0, 0) );
        setLayout(new FlowLayout());
        
        
   
        jButtonLogin = new JButton("Login");
        jButtonLogin.setBackground(new Color(0, 0, 0, 0) );
        jButtonLogin.setForeground(Color.black);
        jButtonLogin.addActionListener(new ActionListener() 
        {
 
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (authenticate(getUsername(), getPassword())) 
                {
                    succeeded = true;
                    dispose();
                    MainDisplay.initAndShowGUI();
                } 
                else 
                {
                    JOptionPane.showMessageDialog(Login.this,
                            "Invalid username or password",
                            "Apollo | Driver Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    jTextFieldUsername.setText("");
                    jPasswordField.setText("");
                    succeeded = false;
                }
            }
            
        });
        jButtonCancel = new JButton("Cancel");
        jButtonCancel.setBackground(new Color(0, 0, 0, 0) );
        jButtonCancel.setForeground(Color.black);
        jButtonCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
                frame.setVisible(false);
                WelcomeGUI.createAndShowGUI();
            }
        });
        JPanel DP = new JPanel();
        DP.add(jButtonLogin);
        DP.add(jButtonCancel);
        DP.setBackground(new Color(0, 0, 0, 0) );
        DP.setForeground(new Color(0, 0, 0, 0) );
        DP.setOpaque(false);
        
        jLabelCredentials.setPreferredSize(new Dimension(250,105));
        getContentPane().add(jLabelCredentials, BorderLayout.NORTH);
        
        panel.setPreferredSize(new Dimension(375,115));
        getContentPane().add(panel, BorderLayout.CENTER);
        
        DP.setPreferredSize(new Dimension(200,188));
        getContentPane().add(DP, BorderLayout.SOUTH);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
    
    public static boolean authenticate(String username, String password) 
    {
        // hardcoded username and password
        if (username.equals("Driver") && password.equals("Driver")) 
        {
            return true;
        }
        else 
        {
            if (username.equals("Insurance") && password.equals("Insurance"))   
            {
                return true;
            }
            else
            {
                return username.equals("Legal") && password.equals("Legal");
            }
        }    
    }
    public String getUsername() {
        return jTextFieldUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(jPasswordField.getPassword());
    }
 
    public boolean isSucceeded() {
        return succeeded;
    }
    
    public static void frame()
    {
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main() 
    {
        Login Login = new Login(frame);
        Login.setVisible(true);
        Login.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}