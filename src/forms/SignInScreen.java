package forms;

import javax.swing.*;
import java.awt.*;

public class SignInScreen extends JFrame{
    private JPanel MainPanel;
    private JLabel signInLabel;
    private JTextField emailInput;
    private JTextField nameInput;
    private JButton button1;
    private JPasswordField passwordInput;
    private JLabel errorLabel;

    private boolean formValidation(String username, String email, char[] password) {

        errorLabel.setForeground(Color.RED);

        if (username.equals("")){
            errorLabel.setText("Nome invalido");
            return false;
        }

        if (!email.contains("@") || !email.contains(".com")) {
            errorLabel.setText("Email invalido");
            return false;
        }

        if (password.length < 5) {
            errorLabel.setText("Senha invalida");
            return false;
        }

        return true;

    }

    public SignInScreen() {
        signInLabel.setFont(new Font("SansSerif", Font.BOLD, 26));

        this.setTitle("Portal do Aluno - Login");
        this.setContentPane(MainPanel);
        this.setBounds(0,0,1366,768);
        this.pack();
        this.setVisible(true);

        button1.addActionListener(actionEvent -> {
            String username = nameInput.getText();
            String email = emailInput.getText();
            char[] password = passwordInput.getPassword();

            if (formValidation(username, email, password)) {
                errorLabel.setForeground(Color.BLACK);
                errorLabel.setText("Usuario criado com sucesso!");

                // Use data to create user
            }
        });
    }
}
