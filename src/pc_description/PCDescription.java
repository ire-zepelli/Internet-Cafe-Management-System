package pc_description;

import javax.swing.*;
import java.awt.*;

public class PCDescription {
    public static JPanel getPCDescription () {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(585, 30, 300, 500);
        mainPanel.setBackground(new Color(83, 88, 94));

        JLabel mainLabel = new JLabel("<html><div style='text-align: center;'>Select <br/> a PC <br/> to <br /> preview: </div></html>");
        mainLabel.setFont(new Font("Inter", Font.BOLD, 55));
        mainLabel.setBounds(30,35,300,400);
        mainLabel.setForeground(Color.WHITE);
        mainPanel.add(mainLabel);

        return mainPanel;
    }
}
