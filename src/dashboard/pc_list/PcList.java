package dashboard.pc_list;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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

        JPanel[] pcPanels = new JPanel[25];

        panelWidth = (mainPanel.getWidth() - (horizontalGap * (totalCols + 1))) / totalCols;
        panelHeight = (mainPanel.getHeight() - (verticalGap * (totalRows + 1))) / totalRows;

        for (int i = 0; i < 25; i++) {
            row = i / totalCols;
            col = i % totalCols;
            xPos = horizontalGap + col * (panelWidth + horizontalGap);
            yPos = verticalGap + row * (panelHeight + verticalGap);

            pcPanels[i] = new JPanel();
            pcPanels[i].setBackground(Color.decode("#232529"));
            pcPanels[i].setBounds(xPos, yPos, panelWidth, panelHeight);
            pcPanels[i].setLayout(null);

            JPanel imagePanel = createPCPanel("C:\\Users\\USER\\Desktop\\Armonia\\Internet-Cafe-Management-System\\public\\red-pc-icon.png", 0, 0, panelWidth, panelHeight);
            pcPanels[i].add(imagePanel);
            mainPanel.add(pcPanels[i]);
        }

        return mainPanel;
    }

    public static JPanel addPc(int pcNumber, Color c) {
        JPanel pcPanel = new JPanel();
        pcPanel.setPreferredSize(new Dimension(100, 100));
        return pcPanel;
    }

    public static JPanel createPCPanel(String imagePath, int x, int y, int w, int h) {
        JPanel panel = new JPanel() {
            Image image;

            {
                try {
                    image = ImageIO.read(new File(imagePath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                if (image != null) {
                    int imgWidth = getWidth() * 7 / 10;
                    int imgHeight = getHeight() * 7 / 10;
                    int imgX = (getWidth() - imgWidth) / 2;
                    int imgY = (getHeight() - imgHeight) / 2;
                    graphics.drawImage(image, imgX, imgY, imgWidth, imgHeight, this);
                }
            }
        };

        panel.setBounds(x, y, w, h);
        panel.setOpaque(false);
        return panel;
    }
}