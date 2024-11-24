package sidebar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
                System.exit(0);
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

        icon.add(vr);
        icon.add(iconImage);

        return icon;
    }
}
