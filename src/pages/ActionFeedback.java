package pages;

import javax.swing.*;
import java.awt.*;

public class ActionFeedback extends JFrame{
    private JPanel MainPanel;
    private JLabel mainPhrase;

    public ActionFeedback(String phrase, boolean error) {
        this.setBounds(0,0,900,500);
        this.setContentPane(MainPanel);

        mainPhrase.setText(phrase);
        mainPhrase.setFont(new Font("SansSerif", Font.BOLD, 32));

        if (error){
            mainPhrase.setForeground(Color.RED);
        } else {
            mainPhrase.setForeground(Color.BLACK);
        }
        this.setVisible(true);

        Timer tm = new Timer(3000, e -> {
            this.dispose();
        });
        tm.start();
    }
}
