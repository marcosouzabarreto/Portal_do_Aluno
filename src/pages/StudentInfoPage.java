package pages;

import database.User;
import forms.LoginScreen;
import utils.Utils;

import javax.swing.*;
import java.awt.*;

public class StudentInfoPage extends JFrame{
    private final String teacherName;
    private final String studentName;

    private JPanel MainPanel;
    private JLabel studentNameLabel;
    private JPanel studentInfoPanel;
    private JLabel fullNameLabel;
    private JPanel gradesPanel;
    private JTable table1;
    private JButton returnButton;

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

        returnButton.addActionListener(e -> {
            this.dispose();
            new HomePage(teacher);
        });
    }

    public String getStudentName() {
        return studentName;
    }
}
