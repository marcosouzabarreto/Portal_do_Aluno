package pages;

import database.ReadDatabase;
import database.User;
import forms.*;
import utils.Utils;
import javax.swing.*;
import java.awt.*;

public class HomePage extends JFrame{

    private JPanel MainPanel;
    private JLabel welcomePhraseLabel;
    private JPanel SubjectsPanel;
    private JList<String> subjectsList;
    private JButton studentInfoButton;
    private JLabel noSubjectsFoundText;
    private JPanel noSubjectsFoundPanel;
    private JLabel listTitle;
    private JButton returnButton;


    public HomePage(User user) {

        DefaultListModel<String> subjects = new DefaultListModel<>();

        if(user.getFunction().equals("student")){
            subjects.addElement(user.getSubjects());

        } else if (user.getFunction().equals("admin")) {
            DefaultListModel<User> students = new ReadDatabase().getAllStudents();
            for(int i = 0; i < students.size(); i++){
                subjects.addElement(students.getElementAt(i).getName());
            }
        }

        subjectsList.setModel(subjects);
        // Align JList elements to center
        new Utils().alignJListElementsToCenter(subjectsList);



        if (subjects.isEmpty()) {
            subjectsList.setVisible(false);
            studentInfoButton.setVisible(false);
        } else {
            noSubjectsFoundPanel.setVisible(false);
        }

        String firstName = new Utils().getFirstName(user.getName());

        welcomePhraseLabel.setText("Bem vindo, " + firstName + "!");
        welcomePhraseLabel.setFont(new Font("SansSerif", Font.BOLD, 26));

        if (user.getFunction().equals("student")) {
            this.setTitle("Portal do Aluno - " + firstName);
            listTitle.setText("Suas matérias:");

            studentInfoButton.setVisible(false);
        } else {
            this.setTitle("Portal do Professor - " + firstName);
            listTitle.setText("Seus alunos:");
            studentInfoButton.setText("Informações do aluno:");
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

        studentInfoButton.addActionListener(e -> {
            User student = new ReadDatabase().getUserByName(subjectsList.getSelectedValue());
            if(student != null){
                new StudentInfoPage(user, student);
            } else {
                new ActionFeedback("Usuário inexistente", true);
            }

        });
    }

    private void createUIComponents() {

    }
}
