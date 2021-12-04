package forms;

import database.UpdateDatabase;
import database.User;
import pages.ActionFeedback;
import pages.StudentInfoPage;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Objects;

public class NewSubjectForm extends JFrame {
    private JPanel MainPanel;
    private JComboBox<String> subjectsList;
    private JButton submitButton;

    public NewSubjectForm(User student, User teacher){
        this.setBounds(0, 0, 900, 500);
        this.setContentPane(MainPanel);
        this.setTitle("Adicionar nova matéria");

        subjectsList.addItem("Matemática");
        subjectsList.addItem("Português");
        subjectsList.addItem("Redação");
        subjectsList.addItem("Física");
        subjectsList.addItem("Química");
        subjectsList.addItem("História");
        subjectsList.addItem("Geografia");
        subjectsList.addItem("Artes");

        this.setVisible(true);

        submitButton.addActionListener(e -> {

            String materias = student.getSubjects();
            materias += "," + Objects.requireNonNull(subjectsList.getSelectedItem()).toString();


            try {
                new UpdateDatabase().updateRecord(materias, student.getName());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            this.dispose();
            new ActionFeedback("Matéria adicionada com sucesso", false);
        });
    }
}
