package pages;

import forms.*;
import utils.Utils;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame{

    private JPanel MainPanel;
    private JLabel welcomePhraseLabel;
    private JPanel SubjectsPanel;
    private JList<String> subjectsList;
    private JButton studentOrGradeInfoButton;
    private JLabel noSubjectsFoundText;
    private JPanel noSubjectsFoundPanel;
    private JLabel listTitle;
    private JButton returnButton;


    public HomePage(String username, String role) {

        DefaultListModel<String> subjects = new DefaultListModel<>();

        subjects.addElement("Teste");
        subjects.addElement("Teste 2");

        // Align JList elements to center
        new Utils().alignJListElementsToCenter(subjectsList);

        subjectsList.setModel(subjects);

        if (subjects.isEmpty()) {
            subjectsList.setVisible(false);
            studentOrGradeInfoButton.setVisible(false);
        } else {
            noSubjectsFoundPanel.setVisible(false);
        }

        String firstName = new Utils().getFirstName(username);

        welcomePhraseLabel.setText("Bem vindo, " + firstName + "!");
        welcomePhraseLabel.setFont(new Font("SansSerif", Font.BOLD, 26));

        if (role.equals("student")) {
            this.setTitle("Portal do Aluno - " + firstName);
            listTitle.setText("Suas matérias:");

            studentOrGradeInfoButton.setVisible(false);
        } else {
            this.setTitle("Portal do Professor - " + firstName);
            listTitle.setText("Seus alunos:");
            studentOrGradeInfoButton.setText("Informações do aluno:");
        }
        this.setContentPane(MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,1366,768);
        this.pack();
        this.setVisible(true);

        returnButton.addActionListener(e -> {
            this.dispose();
            new LoginScreen();
        });

        studentOrGradeInfoButton.addActionListener(e -> {
            new StudentInfoPage("Marco Aurélio Souza Barreto", username);
        });
    }

    private void createUIComponents() {

    }
}
