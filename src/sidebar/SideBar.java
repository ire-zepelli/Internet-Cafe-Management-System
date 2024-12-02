package sidebar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import create_component.Create_Component;

public class SideBar {
    public static JPanel getSideBar(){
        JPanel sidebar = new JPanel();
        JButton exit = addIcons(0,500, "public/exit-icon.png", false);

        sidebar.setBounds(0, 110, 75,675);
        sidebar.setBackground(new Color(23, 26, 30));
        sidebar.setLayout(null);

        sidebar.add(addIcons(0,0, "public/red-pc-icon.png", true));
        sidebar.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.UIManager.put("OptionPane.background", new Color(36, 37, 42));
                javax.swing.UIManager.put("Panel.background", new Color(36, 37, 42));
                javax.swing.UIManager.put("OptionPane.messageForeground", Color.WHITE);
                javax.swing.UIManager.put("OptionPane.border", BorderFactory.createLineBorder(new Color(166, 33, 34), 2));
        
                JButton yesButton = new JButton("Yes");
                yesButton.setBackground(new Color(166, 33, 34));
                yesButton.setForeground(Color.WHITE);
                yesButton.setFocusPainted(false);
                yesButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                yesButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
                JButton noButton = new JButton("No");
                noButton.setBackground(new Color(228, 228, 228));
                noButton.setForeground(new Color(36, 37, 42));
                noButton.setFocusPainted(false);
                noButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                noButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
                JPanel buttonPanel = new JPanel();
                buttonPanel.setBackground(new Color(36, 37, 42));
                buttonPanel.add(yesButton);
                buttonPanel.add(noButton);
        
                JOptionPane optionPane = new JOptionPane(
                    "<html><div style='color: white; font-family: Arial, sans-serif; font-size: 16px; line-height: 1.5; text-align: center;'>"
                    + "Are you sure you want to close this application?"
                    + "</div></html>",
                    JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.DEFAULT_OPTION,
                    null,
                    new Object[]{},
                    null
                );
        
                JDialog dialog = optionPane.createDialog(null, "");
                dialog.setContentPane(optionPane);
                optionPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        
                yesButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        System.exit(0);
                    }
                });
        
                noButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e1) {
                        dialog.dispose();
                    }
                });
        
                dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
                dialog.pack();
                dialog.setVisible(true);
            }
        });

        return sidebar;
    }
    
    public static JButton addIcons(int x, int y, String imagePath, boolean isSelected){
        JButton icon = new JButton();

        icon.setBorder(BorderFactory.createEmptyBorder());
        icon.setLayout(null);
        JPanel iconImage = Create_Component.ImagePanel(imagePath, 18, 20, 40, 40);
        icon.setBounds(x,y,75,75);
        
        JPanel vr = new JPanel();
        
        if(isSelected){
            vr.setBounds(0,0,5,75);
            vr.setBackground(new Color(166,33,34));
            icon.setEnabled(false);
            icon.setBackground(new Color(36,37,42));
        }
        
        else{
            icon.setBackground(new Color(23, 26, 30));
        }

        icon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        icon.add(vr);
        icon.add(iconImage);

        return icon;
    }
}
