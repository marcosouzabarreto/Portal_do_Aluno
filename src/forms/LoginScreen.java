package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        SignInButton.addActionListener(actionEvent -> {
            new SignInScreen();
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
