package forms;

import pages.SuccessfulAction;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class SignInScreen extends JFrame{
    private JPanel MainPanel;
    private JLabel signInLabel;
    private JTextField emailInput;
    private JTextField nameInput;
    private JButton button1;
    private JPasswordField passwordInput;
    private JLabel errorLabel;
    private JComboBox<String> roleSelector;
    private JTextField dateInput;
    private JPanel dateSelector;


    private boolean formValidation(String username, String email, String role, char[] password, String date) {

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
        if(!date.contains("-")){
            errorLabel.setText("Data inválida");
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

        dateSelector.setVisible(false);
        roleSelector.addActionListener(e -> {
            dateSelector.setVisible(String.valueOf(roleSelector.getSelectedItem()).equals("Aluno"));
        });

        button1.addActionListener(actionEvent -> {
            String username = nameInput.getText();
            String email = emailInput.getText();
            String role = String.valueOf(roleSelector.getSelectedItem());
            char[] password = passwordInput.getPassword();
            String date= dateInput.getText();
            if (formValidation(username, email, role, password, date)) {
                errorLabel.setText("");

                if(role.equals("Professor")){
                    //new ProfessorDAO().criar(username, email, password);
                    System.out.println("Criando professor com "+ username + email + Arrays.toString(password));

                } else if (role.equals("Aluno")) {
                    System.out.println("Criando aluno com " + username + email + Arrays.toString(password));
                }

                this.dispose();
                new SuccessfulAction("Usuário criado com sucesso!");
                // Use data to create user

            }
        });
    }
}
