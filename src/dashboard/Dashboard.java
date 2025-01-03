package dashboard;

import javax.swing.*;

import create_component.Create_Component;
import dashboard.labels.Labels;
import dashboard.pc_description.PCDescription;
import dashboard.pc_list.PcList;

import java.awt.*;
import header.*;
import sidebar.SideBar;

public class Dashboard {
    private static JPanel mainPanel;
    private JPanel hr, content;
    private JLabel storeName;

    public Dashboard() {
        initialize();
    }

    public void initialize() {
        mainPanel = new JPanel();
        content = new JPanel();
        storeName = Create_Component.Label(35, 20, 500, 30, "Armonia Internet Cafe", "Arial", Font.BOLD, 25, 36, 37, 42, 255, 255, 255);
        hr = new JPanel();

        mainPanel.setBackground(new Color(36, 37, 42));
        mainPanel.setLayout(null);

        hr.setBounds(0, 100, 975, 10);
        hr.setBackground(new Color(155, 155, 155));

        content.setBounds(75, 115, 900, 615);
        content.setBackground(new Color(36, 37, 42));
        content.setLayout(null);
        
        content.add(storeName);
        content.add(PcList.getPcList());
        content.add(Labels.getLabels());
        content.add(PCDescription.getPCDescription());
        mainPanel.add(content);
        mainPanel.add(Header.getHeader());
        mainPanel.add(hr);
        mainPanel.add(SideBar.getSideBar());
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public void updateContent() {
    content.removeAll();
    content.add(storeName);
    content.add(PcList.getPcList());
    content.add(Labels.getLabels());
    content.add(PCDescription.getPCDescription());
    content.revalidate();
    content.repaint();
    }
}