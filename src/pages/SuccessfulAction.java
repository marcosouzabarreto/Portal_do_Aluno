package pages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessfulAction extends JFrame{
    private JPanel MainPanel;
    private JLabel mainPhrase;

    public SuccessfulAction(String phrase) {
        this.setBounds(0,0,900,500);
        this.setContentPane(MainPanel);

        mainPhrase.setText(phrase);
        mainPhrase.setFont(new Font("SansSerif", Font.BOLD, 32));
        this.setVisible(true);

        Timer tm = new Timer(3000, e -> {
            this.dispose();
        });
        tm.start();
    }
}
