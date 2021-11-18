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
        this.setBounds(900, 900, 1366, 768);
        this.pack();
    }

    public void showLoginScreen () {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
