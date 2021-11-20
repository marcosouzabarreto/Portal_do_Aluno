package pages;

import javax.swing.*;

public class HomePage extends JFrame{

    private JPanel MainPanel;
    private JLabel welcomePhraseLabel;
    private JLabel roleInfoLabel;

    private String getFirstName(String text) {
        int index = text.indexOf(' ');

        if (index > -1) {
            return text.substring(0, index).trim();
        } else {
            return text;
        }
    }

    public HomePage (String role, String username) {

        String firstName = getFirstName(username);

        welcomePhraseLabel.setText("Ola, "+ firstName);
        roleInfoLabel.setText("Seu cargo é de " + role);
        this.setTitle("Portal do Aluno - " + firstName);
        this.setContentPane(MainPanel);
        this.setBounds(0,0,1366,768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    private void createUIComponents() {

    }
}
