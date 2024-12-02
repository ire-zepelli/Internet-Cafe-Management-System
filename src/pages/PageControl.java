package pages;

import javax.swing.*;

import auth.Auth;
import dashboard.Dashboard;
import java.awt.*;

public class PageControl {
    JFrame frame = new JFrame("Armonia Internet Cafe");
    static JPanel panelCont = new JPanel();
    static CardLayout pages = new CardLayout();
    static Dashboard dashboard;
    static Auth auth = new Auth();

    public PageControl(){
        initialize();
    }


    public void initialize(){
        panelCont.setLayout(pages);
        panelCont.add(auth.getPanel(), "auth");
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("public/icon.png"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(975, 725));
        frame.getContentPane().setBackground(new Color(36, 37, 42));
        frame.add(panelCont);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    public static void showDashboard() {
    if (dashboard == null) {
        // Initialize and add the dashboard panel to the CardLayout only once
        dashboard = new Dashboard();
        panelCont.add(dashboard.getPanel(), "dashboard");
    } else {
        // Optionally update the dashboard content dynamically
        dashboard.updateContent();
    }
    // Show the dashboard using CardLayout
    pages.show(panelCont, "dashboard");
    }
    
    // public static void showHome(){
    //     home = new Home();
    //     panelCont.add(home.getPanel(), "home");
    //     pages.show(panelCont, "home");
    // }
}