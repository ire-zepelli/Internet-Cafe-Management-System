package dashboard.labels;

import javax.swing.*;
import java.awt.*;

public class Labels {
    public static JPanel getLabels() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBounds(35,400,200,160);
        mainPanel.setBackground(Color.decode("#232529"));
        mainPanel.setLayout(null);
        JLabel availableLabel, inSessionLabel, outOfTimeLabel, maintenanceLabel;
    
        availableLabel = new JLabel();
        availableLabel.setText("<html><div style='text-align: center;'><span style='color: #00FF00; font-size: 14px;'>•</span> AVAILABLE</div></html>");
        availableLabel.setForeground(Color.WHITE);
        availableLabel.setFont(new Font("Inter", Font.BOLD, 10)); 
        availableLabel.setBounds(0, 80, 180, 30);
        mainPanel.add(availableLabel);

        inSessionLabel = new JLabel();
        inSessionLabel.setText("<html><div style='text-align: center;'><span style='color: yellow; font-size: 14px;'>•</span> IN-SESSION</div></html>");
        inSessionLabel.setForeground(Color.WHITE);
        inSessionLabel.setFont(new Font("Inter", Font.BOLD, 10));
        inSessionLabel.setBounds(0, 95, 180, 30);
        mainPanel.add(inSessionLabel);

        outOfTimeLabel = new JLabel();
        outOfTimeLabel.setText("<html><div style='text-align: center;'><span style='color: red; font-size: 14px;'>•</span> OUT OF TIME</div></html>");
        outOfTimeLabel.setForeground(Color.WHITE);
        outOfTimeLabel.setFont(new Font("Inter", Font.BOLD, 10));
        outOfTimeLabel.setBounds(0, 110, 180, 30);
        mainPanel.add(outOfTimeLabel);

        maintenanceLabel = new JLabel();
        maintenanceLabel.setText("<html><div style='text-align: center;'><span style='color: #FFC0CB; font-size: 14px;'>•</span> MAINTENANCE</div></html>");
        maintenanceLabel.setForeground(Color.WHITE);
        maintenanceLabel.setFont(new Font("Inter", Font.BOLD, 10));
        maintenanceLabel.setBounds(0, 125, 180, 30);
        mainPanel.add(maintenanceLabel);

        return mainPanel;
    }
}
