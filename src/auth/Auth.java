package auth;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import create_component.Create_Component;
import pages.PageControl;

public class Auth {
    private boolean isUserAuthenticated = false; 
    private JPanel mainPanel, authSection_1, inputPanel_1, inputPanel_2, logo;
    private JLabel titleText;
    private TextField userField;
    private JPasswordField passwordField;
    private JButton login_btn;

    public Auth(){
        initialize();
    }

    private void initialize(){
        int defaultWidth = 975;
        int defaultHeight = 725;

        mainPanel = new JPanel();
        authSection_1 = new JPanel();
        inputPanel_1 = new JPanel();
        inputPanel_2 = new JPanel();
        logo = Create_Component.ImagePanel("public/armonia-logo-red.png", 355, 25, 250, 250);

        userField = new TextField();
        passwordField = new JPasswordField();

        login_btn = new JButton("Login");
        
        titleText = new JLabel("<html>"+
        " <h1 style=\"font-size:80px\">Armo" + 
        "<span style=\"color:#A62122\">nia</span>" + 
        "</h1>" +
         "</html>");
        
        mainPanel.setBackground(new Color(20, 23, 29));
        mainPanel.setBounds(0,0,defaultWidth, defaultHeight);
        mainPanel.setLayout(null);

        authSection_1.setBounds(0,0, defaultWidth, defaultHeight);
        authSection_1.setBackground(new Color(20, 23, 29));
        authSection_1.setLayout(null);

        inputPanel_1.setBounds(290,400, 350, 30);
        inputPanel_1.setLayout(null);

        login_btn.setBounds(415, 500, 100, 30);
        login_btn.setForeground(new Color(255,255,255));
        login_btn.setFont(new Font(null, Font.PLAIN, 20));
        login_btn.setBackground(Color.decode("#A62122"));
        login_btn.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        login_btn.setFocusPainted(false);
        login_btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        inputPanel_2.setBounds(290,450, 350, 30);
        inputPanel_2.setLayout(null);
        

        userField.setBounds(0, 0, 350, 30);
        userField.setFont(new Font(null, Font.PLAIN, 25));
        
        passwordField.setBounds(0, 0, 350, 30);
        passwordField.setFont(new Font(null, Font.PLAIN, 25));
        
        titleText.setForeground(new Color(255, 255, 255));
        titleText.setBounds(255 , 250, 500, 150);

        inputPanel_1.add(userField);
        inputPanel_2.add(passwordField);

        mainPanel.add(authSection_1);

        authSection_1.add(titleText);
        authSection_1.add(inputPanel_1);
        authSection_1.add(inputPanel_2);
        authSection_1.add(login_btn);
        authSection_1.add(logo);

        
        login_btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(ControlAccess.Authenticate(userField.getText(), String.valueOf(passwordField.getPassword()))){
                    PageControl.showDashboard(-1);
                }
            }
        });

    }

    public boolean AuthStatus(){
        return isUserAuthenticated;
    }

    public JPanel getPanel(){
        return mainPanel;
    }
}