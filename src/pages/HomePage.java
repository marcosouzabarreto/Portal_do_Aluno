package pages;

import javax.swing.*;

public class HomePage extends JFrame{
    private String role = "role";
    private String username = "username";

    private JPanel MainPanel;
    private JLabel welcomePhraseLabel;
    private JLabel roleInfoLabel;

    public HomePage (String role, String username) {
        this.username = username;
        this.role = role;

        //this.createUIComponents();

        this.setTitle("Portal do Aluno - " + username);
        this.setContentPane(MainPanel);
        this.setBounds(0,0,1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void createUIComponents() {
        //welcomePhraseLabel.setText("Bem vindo ao seu portal, " + this.username);
        //roleInfoLabel.setText("Seu cargo é de " + this.role);
    }
}
