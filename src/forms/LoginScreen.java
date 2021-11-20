package forms;

import javax.swing.*;

public class LoginScreen extends JFrame{
    private JPanel MainPanel;
    private JPanel EmailPanel;
    private JTextField EmailInput;
    private JPanel EmailName;
    private JLabel EmailLabelName;
    private JPanel PasswordPanel;
    private JPasswordField PassordInput;
    private JPanel PasswordName;
    private JButton SignInButton;
    private JButton SubmitFormButton;

    public LoginScreen() {
        this.setTitle("Portal do Aluno - Login");
        this.setContentPane(MainPanel);
        this.setBounds(0,0,1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
