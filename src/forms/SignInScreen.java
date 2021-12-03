package forms;

import databaseConnection.ProfessorDAO;

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
    private JComboBox<String> roleSelector;

    private boolean formValidation(String username, String email, String role, char[] password) {

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

        if (role.equals("Selecione o seu cargo:")) {
            errorLabel.setText("Cargo inválido");
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

        roleSelector.addItem("Selecione o seu cargo:");
        roleSelector.addItem("Aluno");
        roleSelector.addItem("Professor");

        button1.addActionListener(actionEvent -> {
            String username = nameInput.getText();
            String email = emailInput.getText();
            String role = String.valueOf(roleSelector.getSelectedItem());
            char[] password = passwordInput.getPassword();
            System.out.println(role);
            if (formValidation(username, email, role, password)) {
                errorLabel.setForeground(Color.BLACK);
                errorLabel.setText("Usuario criado com sucesso!");

                if(role == "admin"){
                    new ProfessorDAO().criar(username, email, password);
                } else if (role == "student") {

                }
                // Use data to create user

            }
        });
    }
}
