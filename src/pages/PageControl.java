package pages;

import javax.swing.*;

import auth.Auth;
import dashboard.Dashboard;
import data.Data;

import java.awt.*;

public class PageControl {
    JFrame frame = new JFrame("Armonia Internet Cafe");
    static JPanel panelCont = new JPanel();
    static CardLayout pages = new CardLayout();
    Auth auth = new Auth();
    static Dashboard dashboard;


    public PageControl(){
        initialize();
    }


    public void initialize(){
        new Data();
        panelCont.setLayout(pages);
        panelCont.add(auth.getPanel(), "dashboard");
        
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("public/armonia-logo-red.png"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(new Dimension(975, 725));
        frame.getContentPane().setBackground(new Color(36, 37, 42));
        frame.add(panelCont);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public static void showAuth(){
        pages.show(panelCont, "auth");
    }
    
    public static void showDashboard(int selectedPC){
        dashboard = new Dashboard(selectedPC);
        panelCont.add(dashboard.getPanel(), "dashboard");
        pages.show(panelCont ,"dashboard");
    }

}
