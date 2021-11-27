package forms;

import pages.*;

import javax.swing.*;
import java.awt.*;

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
    private JLabel mainText;

    private boolean validateLogin(String email, char[] password){
        // see if user exists
        return true;
    }

    public LoginScreen() {
        this.setTitle("Portal do Aluno - Login");
        this.setContentPane(MainPanel);
        this.setBounds(0,0,1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        mainText.setFont(new Font("SansSerif", Font.BOLD, 32));
        // Action Listener for Sign In Button
        SignInButton.addActionListener(actionEvent -> new SignInScreen());

        // If the email and
        SubmitFormButton.addActionListener(actionEvent -> {
            String email = EmailInput.getText();
            char[] password = PassordInput.getPassword();

            if(validateLogin(email, password)) {
                // TODO, still hardcoded
                this.dispose();
                new HomePage("Marco Barreto", "admin");
            };
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
