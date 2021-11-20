package forms;

import pages.HomePage;

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

        SignInButton.addActionListener(actionEvent -> new SignInScreen());
        SubmitFormButton.addActionListener(actionEvent -> {
            String email = EmailInput.getText();
            char[] password = PassordInput.getPassword();

            if(validateLogin(email, password)) {
                // TODO, still hardcoded
                new HomePage("admin", "Marco Barreto");
            };
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
