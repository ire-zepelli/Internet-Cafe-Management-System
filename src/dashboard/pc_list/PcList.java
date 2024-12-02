package dashboard.pc_list;

import javax.swing.*;
import create_component.Create_Component;
import dashboard.pc_description.PCDescription;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PcList {
    private static PC[] pcs = new PC[25];
    private static JButton[] pcPanels = new JButton[25];
    private static JLabel[] pcNumber = new JLabel[25];
    private static JLabel[] pcStatus = new JLabel[25];
    private static JPanel mainPanel;

    static {
        // Initialize PCs
        for (int i = 0; i < pcs.length; i++) {
            pcs[i] = new PC(i);
        }
    }

    public static JPanel getPcList() {
        if (mainPanel == null) {
            initializePcList();
        }
        return mainPanel;
    }

    private static void initializePcList() {
        int panelWidth = 70;
        int panelHeight = 60;
        int horizontalGap = 10;
        int verticalGap = 10;
        int totalRows = 5;
        int totalCols = 5;

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(35, 75, 500, 400);
        mainPanel.setBackground(new Color(83, 88, 94));

        panelWidth = (mainPanel.getWidth() - (horizontalGap * (totalCols + 1))) / totalCols;
        panelHeight = (mainPanel.getHeight() - (verticalGap * (totalRows + 1))) / totalRows;

        for (int i = 0; i < pcs.length; i++) {
            int row = i / totalCols;
            int col = i % totalCols;
            int xPos = horizontalGap + col * (panelWidth + horizontalGap);
            int yPos = verticalGap + row * (panelHeight + verticalGap);

            pcPanels[i] = new JButton();
            pcPanels[i].setBackground(Color.decode("#232529"));
            pcPanels[i].setBounds(xPos, yPos, panelWidth, panelHeight);
            pcPanels[i].setLayout(null);

            pcStatus[i] = new JLabel();
            pcStatus[i].setBounds(72, 0, 15, 15);

            pcNumber[i] = new JLabel();
            pcNumber[i].setBounds(31, 11, 25, 30);
            pcNumber[i].setForeground(Color.decode("#A62122"));
            pcNumber[i].setFont(new Font("Comic Sans", Font.BOLD, 18));
            pcNumber[i].setText("" + (i + 1));
            pcNumber[i].setHorizontalAlignment(SwingConstants.CENTER);

            JPanel imagePanel = Create_Component.ImagePanel("public/red-pc-icon.png", 21, 10, 45, 45);
            pcPanels[i].add(pcNumber[i]);
            pcPanels[i].add(pcStatus[i]);
            pcPanels[i].add(imagePanel);

            addAction(pcPanels[i], i + 1);

            pcPanels[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            mainPanel.add(pcPanels[i]);
        }
        updatePcList(); // Ensure the UI reflects the latest state
    }

    public static void updatePcList() {
        for (int i = 0; i < pcs.length; i++) {
            String status = pcs[i].getSession().getStatus();
            String statusIcon;

            switch (status) {
                case "available":
                    statusIcon = "<html><span style='color: #00FF00; font-size: 14px;'>•</span></html>";
                    break;
                case "in-session":
                    statusIcon = "<html><span style='color: yellow; font-size: 14px;'>•</span></html>";
                    break;
                case "out-of-time":
                    statusIcon = "<html><span style='color: red; font-size: 14px;'>•</span></html>";
                    break;
                case "maintenance":
                    statusIcon = "<html><span style='color: #FF00DD; font-size: 14px;'>•</span></html>";
                    break;
                default:
                    statusIcon = "<html><span style='color: gray; font-size: 14px;'>•</span></html>";
            }

            pcStatus[i].setText(statusIcon);
            pcStatus[i].revalidate();
            pcStatus[i].repaint();
        }
    }

    private static void addAction(JButton btn, int pcNumber) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String status = pcs[pcNumber - 1].getSession().getStatus();
                System.out.println(status);
                switch (status) {
                    case "available":
                        PCDescription.startSession(pcNumber);
                        break;
                    case "maintenance":
                        PCDescription.outOfOrder(pcNumber);
                        break;
                    case "in-session":
                        PCDescription.viewSession(pcNumber);
                        break;
                }
            }
        });
    }

    public static PC getPC(int pcNumber) {
        return pcs[pcNumber];
    }

    public static JLabel getPCStatus(int pcNumber) {
        return pcStatus[pcNumber];
    }
}
