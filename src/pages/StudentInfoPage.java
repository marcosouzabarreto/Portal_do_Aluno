package pages;

import javax.swing.*;

public class StudentInfoPage {
    private final String studentName;

    private JPanel MainPanel;
    private JLabel studentNameLabel;
    private JPanel studentInfoPanel;
    private JLabel fullNameLabel;
    private JPanel gradesPanel;
    private JTable table1;

    public StudentInfoPage(String studentName) {
        this.studentName = studentName;

    }

    public String getStudentName() {
        return studentName;
    }
}
