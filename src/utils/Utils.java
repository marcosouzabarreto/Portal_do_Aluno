package utils;

import javax.swing.*;


public class Utils {
    public void setLookAndFeel(){
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName(String text) {
        int index = text.indexOf(' ');

        if (index > -1) {
            return text.substring(0, index).trim();
        } else {
            return text;
        }
    }

    public void alignJListElementsToCenter(JList<String> list){
        DefaultListCellRenderer renderer = (DefaultListCellRenderer)list.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
    }
}
