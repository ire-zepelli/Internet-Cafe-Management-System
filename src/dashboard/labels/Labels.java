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
        
        String text = "<html><div style='text-align: center;'><span style='color: #00FF00; font-size: 14px;'>•</span> AVAILABLE</div></html>";
        availableLabel = createLabel(0, 80, 180, 30, text);
        mainPanel.add(availableLabel);

        text = "<html><div style='text-align: center;'><span style='color: yellow; font-size: 14px;'>•</span> IN-SESSION</div></html>";
        inSessionLabel = createLabel(0, 95, 180, 30, text);
        mainPanel.add(inSessionLabel);

        text = "<html><div style='text-align: center;'><span style='color: red; font-size: 14px;'>•</span> OUT OF TIME</div></html>";
        outOfTimeLabel = createLabel(0, 110, 180, 30, text);
        mainPanel.add(outOfTimeLabel);

        text = "<html><div style='text-align: center;'><span style='color: #FF00DD; font-size: 14px;'>•</span> MAINTENANCE</div></html>";
        maintenanceLabel = createLabel(0, 125, 180, 30, text);
        mainPanel.add(maintenanceLabel);

        return mainPanel;
    }

    public static JLabel createLabel(int x, int y, int w, int h, String text){
        JLabel label = new JLabel();
        label.setText(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Inter", Font.BOLD, 10)); 
        label.setBounds(x,y,w,h);
        return label;
    }
}
