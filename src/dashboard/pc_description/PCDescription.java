package dashboard.pc_description;

import javax.swing.*;


import java.awt.*;

public class PCDescription {
    static JLabel mainLabel = new JLabel("<html><div style='text-align: center;'>Select <br/> a PC <br/> to <br /> preview: </div></html>");
    static JPanel mainPanel = new JPanel();

    
    public static JPanel getPCDescription () {
        
        mainPanel.setLayout(null);
        mainPanel.setBounds(585, 30, 300, 500);
        mainPanel.setBackground(new Color(83, 88, 94));

        // mainLabel.setFont(new Font("Inter", Font.BOLD, 55));
        // mainLabel.setBounds(30,35,300,400);
        // mainLabel.setForeground(Color.WHITE);
        // mainPanel.add(mainLabel);

        
        JButton startButton = new JButton("START SESSION");

        startButton.setBounds(0,440,300,60);
        startButton.setBackground(Color.decode("#A62122"));
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Inter",Font.BOLD, 20));
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setLayout(null);
        startButton.setFocusPainted(false);
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(startButton);

        JLabel pcNumber = new JLabel("PC 1");
        pcNumber.setFont(new Font("Inter",Font.BOLD, 18));
        pcNumber.setForeground(Color.WHITE);
        pcNumber.setBounds(130,0,50,50);
        mainPanel.add(pcNumber);
        
        JLabel categoryLabel = new JLabel("CATEGORY");
        categoryLabel.setFont(new Font("Inter",Font.BOLD, 10));
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setBounds(20,15,100,100);
        mainPanel.add(categoryLabel);

        JButton guestButton = new JButton("G");
        guestButton.setFont(new Font("Inter",Font.PLAIN, 15));
        guestButton.setBounds(20,80,65,50);
        guestButton.setBackground(Color.decode("#232529"));
        guestButton.setForeground(Color.WHITE);
        guestButton.setLayout(null);
        guestButton.setFocusPainted(false);
        guestButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(guestButton);
        
        JButton studentButton = new JButton("S");
        studentButton.setFont(new Font("Inter",Font.PLAIN, 15));
        studentButton.setBounds(85,80,65,50);
        studentButton.setBackground(Color.decode("#232529"));
        studentButton.setForeground(Color.WHITE);
        studentButton.setLayout(null);
        studentButton.setFocusPainted(false);
        studentButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(studentButton);

        JButton vipButton = new JButton("VIP");
        vipButton.setFont(new Font("Inter",Font.PLAIN, 15));
        vipButton.setBounds(150,80,65,50);
        vipButton.setBackground(Color.decode("#232529"));
        vipButton.setForeground(Color.WHITE);
        vipButton.setLayout(null);
        vipButton.setFocusPainted(false);
        vipButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(vipButton);

        JButton adminButton = new JButton("A");
        adminButton.setFont(new Font("Inter",Font.PLAIN, 15));
        adminButton.setBounds(215,80,65,50);
        adminButton.setBackground(Color.decode("#232529"));
        adminButton.setForeground(Color.WHITE);
        adminButton.setLayout(null);
        adminButton.setFocusPainted(false);
        adminButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(adminButton);
        
        JLabel sessionLabel = new JLabel("SESSION LENGTH");
        sessionLabel.setFont(new Font("Inter",Font.BOLD, 10));
        sessionLabel.setForeground(Color.WHITE);
        sessionLabel.setBounds(20,125,100,100);
        mainPanel.add(sessionLabel);

        JLabel column = new JLabel(":");
        column.setFont(new Font("Inter",Font.BOLD, 15));
        column.setForeground(Color.WHITE);
        column.setBounds(155,123,100,100);
        mainPanel.add(column);
        
        JTextField hourTimer = new JTextField();
        hourTimer.setBounds(120,165,30,20);
        hourTimer.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(hourTimer);

        JTextField secondTimer = new JTextField();
        secondTimer.setBounds(165,165,30,20);
        secondTimer.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(secondTimer);

        JLabel addOnLabel = new JLabel("ADD ON: ");
        addOnLabel.setFont(new Font("Inter",Font.BOLD, 10));
        addOnLabel.setForeground(Color.WHITE);
        addOnLabel.setBounds(20,160,100,100);
        mainPanel.add(addOnLabel);

        JButton addOn1 = new JButton();
        addOn1.setBounds(20,225,65,80);
        addOn1.setBackground(Color.decode("#232529"));
        addOn1.setForeground(Color.WHITE);
        addOn1.setLayout(null);
        addOn1.setFocusPainted(false);
        addOn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn1);

        JButton addOn2 = new JButton();
        addOn2.setBounds(85,225,65,80);
        addOn2.setBackground(Color.decode("#232529"));
        addOn2.setForeground(Color.WHITE);
        addOn2.setLayout(null);
        addOn2.setFocusPainted(false);
        addOn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn2);

        JButton addOn3 = new JButton();
        addOn3.setBounds(150,225,65,80);
        addOn3.setBackground(Color.decode("#232529"));
        addOn3.setForeground(Color.WHITE);
        addOn3.setLayout(null);
        addOn3.setFocusPainted(false);
        addOn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn3);

        JButton addOn4 = new JButton();
        addOn4.setBounds(215,225,65,80);
        addOn4.setBackground(Color.decode("#232529"));
        addOn4.setForeground(Color.WHITE);
        addOn4.setLayout(null);
        addOn4.setFocusPainted(false);
        addOn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn4);

        JLabel subtotalLabel = new JLabel("Subtotal: ");
        subtotalLabel.setFont(new Font("Inter",Font.BOLD, 25));
        subtotalLabel.setForeground(Color.WHITE);
        subtotalLabel.setBounds(20,300,200,100);
        mainPanel.add(subtotalLabel);

        JLabel cashLabel = new JLabel("P100");
        cashLabel.setFont(new Font("Inter",Font.BOLD, 35));
        cashLabel.setForeground(Color.WHITE);
        cashLabel.setBounds(110,345,200,100);
        mainPanel.add(cashLabel);
        
        return mainPanel;

    }

    public static void startSession(String text){

    }

    public static void viewSession(String pcNumber){
        mainLabel.setText("Oten" + pcNumber + " ");
    }

    public static void outOfOrder(){
        mainLabel.setText("OutOfOrder");
    }
}
