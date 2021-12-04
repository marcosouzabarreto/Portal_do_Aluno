package forms;

import database.ReadDatabase;
import database.User;
import pages.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

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

    private boolean validateLogin(String email, char[] password, User user){

        return user.getPasswd().equals(Arrays.toString(password));
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

            User user = new ReadDatabase().getUserByEmail(email);

            if(validateLogin(email, password, user)) {
                this.dispose();
                new HomePage(user);
            }

        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
