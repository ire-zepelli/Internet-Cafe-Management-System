package pages;

import javax.swing.*;
import dashboard.Dashboard;
import java.awt.*;

public class PageControl {
    JFrame frame = new JFrame("Armonia Internet Cafe");
    static JPanel panelCont = new JPanel();
    static CardLayout pages = new CardLayout();
    Dashboard dashboard = new Dashboard();


    public PageControl(){
        initialize();
    }


    public void initialize(){
        panelCont.setLayout(pages);
        panelCont.add(dashboard.getPanel(), "dashboard");
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("public/icon.png"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(975, 725));
        frame.getContentPane().setBackground(new Color(36, 37, 42));
        frame.add(panelCont);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void showDashboard(){
        pages.show(panelCont, "dashboard");
    }
    
    // public static void showHome(){
    //     home = new Home();
    //     panelCont.add(home.getPanel(), "home");
    //     pages.show(panelCont, "home");
    // }
}
