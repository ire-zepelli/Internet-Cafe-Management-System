package dashboard.pc_list;

import javax.imageio.ImageIO;
import javax.swing.*;

import create_component.Create_Component;
import dashboard.Dashboard;
import dashboard.pc_description.PCDescription;
import pages.PageControl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import data.Data;
import data.LinkedList;

public class PcList {
    public static JPanel getPcList() {
        
        int panelWidth = 70;
        int panelHeight = 60;
        int horizontalGap = 10;
        int verticalGap = 10;
        int totalRows = 5;
        int totalCols = 5;
        
        int row, col, xPos, yPos;
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(35, 75, 500, 400);
        mainPanel.setBackground(new Color(83, 88, 94));
        
        JButton[] pcPanels = new JButton[25];
        JLabel[] pcNumber = new JLabel[25];
        JLabel[] pcStatus = new JLabel[25];

        panelWidth = (mainPanel.getWidth() - (horizontalGap * (totalCols + 1))) / totalCols;
        panelHeight = (mainPanel.getHeight() - (verticalGap * (totalRows + 1))) / totalRows;
                

        for (int i = 0; i < 25; i++) {
            LinkedList data = Data.getData();            


            row = i / totalCols;
            col = i % totalCols;
            xPos = horizontalGap + col * (panelWidth + horizontalGap);
            yPos = verticalGap + row * (panelHeight + verticalGap);


            
            pcPanels[i] = new JButton();
            pcPanels[i].setBackground(Color.decode("#232529"));
            pcPanels[i].setBounds(xPos, yPos, panelWidth, panelHeight);
            pcPanels[i].setLayout(null);


            String status = data.get(i)[1], statusIcon = "";
            
            // if(i < 26) status = "maintenance";
            // if(i < 16) status = "out-of-time";
            // if(i < 11) status = "in-session";
            // if(i < 6) status = "available";


            if(status.equals("available")) statusIcon = "<html><span style='color: #00FF00; font-size: 14px;'>•</span></html>";
            else if(status.equals("in-session")) statusIcon = "<html><span style='color: yellow; font-size: 14px;'>•</span></html>";
            else if(status.equals("out-of-time")) statusIcon = "<html><span style='color: red; font-size: 14px;'>•</span></html>";
            else if(status.equals("maintenance")) statusIcon = "<html><span style='color: #FF00DD; font-size: 14px;'>•</span></html>";


            pcStatus[i] = new JLabel(statusIcon);
            pcStatus[i].setBounds(72,0, 15,15);

            addAction(pcPanels[i], i+1, status);

            pcNumber[i] = new JLabel();
            pcNumber[i].setBounds(31,11,25,30);
            pcNumber[i].setForeground(Color.decode("#A62122"));
            pcNumber[i].setFont(new Font("Comic Sans", Font.BOLD, 18));
            pcNumber[i].setText(""+(i+1));

            pcNumber[i].setHorizontalAlignment(0);
            pcPanels[i].add(pcNumber[i]);

            JPanel imagePanel = Create_Component.ImagePanel("public/red-pc-icon.png", 21,10, 45,45);
            pcPanels[i].add(pcStatus[i]);
            pcPanels[i].add(imagePanel);

            pcPanels[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            

            mainPanel.add(pcPanels[i]);
        }

        return mainPanel;
    }

    public static void addAction(JButton btn, int pcNumber, String status){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (status) {
                    case "available":
                      PageControl.showDashboard(pcNumber);
                        break;
                    case "in-session":
                        PageControl.showDashboard(pcNumber);
                              break;
                    default:
                        break;
                }
            }
        });
    }
}