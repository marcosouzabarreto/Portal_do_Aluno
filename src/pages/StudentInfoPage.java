package pages;

import database.User;
import forms.NewSubjectForm;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentInfoPage extends JFrame{
    private final String teacherName;
    private final String studentName;

    private JPanel MainPanel;
    private JLabel studentNameLabel;
    private JPanel studentInfoPanel;
    private JLabel fullNameLabel;
    private JPanel gradesPanel;
    private JButton returnButton;
    private JButton addSubjectButton;
    private JList<String> subjectsList;

    public StudentInfoPage(User teacher, User student) {
        this.studentName = student.getName();
        this.teacherName = teacher.getName();

        String firstName = new Utils().getFirstName(this.studentName);
        studentNameLabel.setText("Informações sobre " + firstName);
        studentNameLabel.setFont(new Font("SansSerif", Font.PLAIN, 26));

        fullNameLabel.setText("Nome completo: " + studentName);

        this.setContentPane(MainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,1366,768);
        this.pack();
        this.setVisible(true);

        ArrayList<String> subjectsLists = new ArrayList<>(Arrays.asList(student.getSubjects().split(",")));
        DefaultListModel<String> subjectsListModel = new DefaultListModel<>();

        for(int i = 0; i < subjectsLists.size(); i++) {
            subjectsListModel.addElement(subjectsLists.get(i));
        }

        subjectsList.setModel(subjectsListModel);

        addSubjectButton.addActionListener(e -> {
            this.dispose();
            new NewSubjectForm(student, teacher);
        });

        returnButton.addActionListener(e -> {
            this.dispose();
            new HomePage(teacher);
        });
    }

    public String getStudentName() {
        return studentName;
    }
}
