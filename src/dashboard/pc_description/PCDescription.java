package dashboard.pc_description;

import javax.swing.*;

import dashboard.pc_list.PcList;
import pages.PageControl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PCDescription {
    static JLabel mainLabel = new JLabel("<html><div style='text-align: center;'>Select <br/> a PC <br/> to <br /> preview: </div></html>");
    static JPanel mainPanel = new JPanel();
    static JButton startButton = new JButton("START SESSION");
    static JLabel pcNumber = new JLabel();

    
    public static JPanel getPCDescription () {
        
        mainPanel.setLayout(null);
        mainPanel.setBounds(585, 30, 300, 500);
        mainPanel.setBackground(new Color(83, 88, 94));

        mainLabel.setFont(new Font("Inter", Font.BOLD, 55));
        mainLabel.setBounds(30,35,300,400);
        mainLabel.setForeground(Color.WHITE);
        mainPanel.add(mainLabel);

        return mainPanel;

    }

    public static void startSession(int pc){
       if (pcNumber.getText().equals("PC " + pc)){
            return;
        }

        mainPanel.removeAll();

        startButton.setText("CALCULATE SESSION");
        startButton.setBounds(0,440,300,60);
        startButton.setBackground(Color.decode("#A62122"));
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Inter",Font.BOLD, 20));
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setLayout(null);
        startButton.setFocusPainted(false);
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(startButton);

        pcNumber.setFont(new Font("Inter",Font.BOLD, 18));
        pcNumber.setForeground(Color.WHITE);
        pcNumber.setBounds(130,0,60,50);
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
        studentButton.setEnabled(false);
        mainPanel.add(studentButton);

        JButton vipButton = new JButton("VIP");
        vipButton.setFont(new Font("Inter",Font.PLAIN, 15));
        vipButton.setBounds(150,80,65,50);
        vipButton.setBackground(Color.decode("#232529"));
        vipButton.setForeground(Color.WHITE);
        vipButton.setLayout(null);
        vipButton.setFocusPainted(false);
        vipButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        vipButton.setEnabled(false);
        mainPanel.add(vipButton);

        JButton adminButton = new JButton("A");
        adminButton.setFont(new Font("Inter",Font.PLAIN, 15));
        adminButton.setBounds(215,80,65,50);
        adminButton.setBackground(Color.decode("#232529"));
        adminButton.setForeground(Color.WHITE);
        adminButton.setLayout(null);
        adminButton.setFocusPainted(false);
        adminButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        adminButton.setEnabled(false);
        mainPanel.add(adminButton);
        
        JLabel sessionLabel = new JLabel("SESSION LENGTH");
        sessionLabel.setFont(new Font("Inter",Font.BOLD, 10));
        sessionLabel.setForeground(Color.WHITE);
        sessionLabel.setBounds(20,125,100,100);
        mainPanel.add(sessionLabel);

        JLabel column = new JLabel(":");
        column.setFont(new Font("Inter",Font.BOLD, 15));
        column.setForeground(Color.WHITE);
        column.setBounds(173,123,100,100);
        mainPanel.add(column);
        
        String[] hours = new String[24];
        for (int i = 0; i < 24; i++)
        {
            hours[i] = String.format("%02d",i);
        }

        JComboBox <String> hourComboBox = new JComboBox<>(hours);
        hourComboBox.setBounds(120,165, 50, 20);
        hourComboBox.setBackground(Color.decode("#232529"));
        hourComboBox.setForeground(Color.WHITE);
        hourComboBox.setFont(new Font("Inter",Font.PLAIN, 12));
        hourComboBox.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(hourComboBox);

        String[] minutes = new String [60];
        for (int i = 0; i < 60; i++)
        {
            minutes[i] = String.format("%02d",i);
        }

        JComboBox <String> minuteComboBox = new JComboBox<>(minutes);
        minuteComboBox.setBounds(180,165, 50, 20);
        minuteComboBox.setBackground(Color.decode("#232529"));
        minuteComboBox.setForeground(Color.WHITE);
        minuteComboBox.setFont(new Font("Inter",Font.PLAIN, 12));
        minuteComboBox.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(minuteComboBox);

        JLabel addOnLabel = new JLabel("ADD ON: ");
        addOnLabel.setFont(new Font("Inter",Font.BOLD, 10));
        addOnLabel.setForeground(Color.WHITE);
        addOnLabel.setBounds(20,160,100,100);
        mainPanel.add(addOnLabel);

        JButton addOn1 = new JButton("Canton");
        addOn1.setBounds(20,225,65,80);
        addOn1.setBackground(Color.decode("#232529"));
        addOn1.setForeground(Color.WHITE);
        addOn1.setFont(new Font("Inter", Font.BOLD, 6));
        addOn1.setLayout(null);
        addOn1.setFocusPainted(false);
        addOn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn1);
        

        JButton addOn2 = new JButton("Coffee");
        addOn2.setBounds(85,225,65,80);
        addOn2.setBackground(Color.decode("#232529"));
        addOn2.setForeground(Color.WHITE);
        addOn2.setFont(new Font("Inter", Font.BOLD, 6));
        addOn2.setLayout(null);
        addOn2.setFocusPainted(false);
        addOn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn2);

        JButton addOn3 = new JButton("Soda");
        addOn3.setBounds(150,225,65,80);
        addOn3.setBackground(Color.decode("#232529"));
        addOn3.setForeground(Color.WHITE);
        addOn3.setFont(new Font("Inter", Font.BOLD, 6));
        addOn3.setLayout(null);
        addOn3.setFocusPainted(false);
        addOn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn3);

        JButton addOn4 = new JButton("Water");
        addOn4.setBounds(215,225,65,80);
        addOn4.setBackground(Color.decode("#232529"));
        addOn4.setForeground(Color.WHITE);
        addOn4.setFont(new Font("Inter", Font.BOLD, 6));
        addOn4.setLayout(null);
        addOn4.setFocusPainted(false);
        addOn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn4);

        JLabel subtotalLabel = new JLabel("Subtotal: ");
        subtotalLabel.setFont(new Font("Inter",Font.BOLD, 25));
        subtotalLabel.setForeground(Color.WHITE);
        subtotalLabel.setBounds(20,300,200,100);
        mainPanel.add(subtotalLabel);

        JLabel cashLabel = new JLabel("P0.00");
        cashLabel.setFont(new Font("Inter",Font.BOLD, 35));
        cashLabel.setForeground(Color.WHITE);
        cashLabel.setBounds(110,345,200,100);
        mainPanel.add(cashLabel);

        pcNumber.setText("PC " + pc);

        addOn1.setEnabled(false);
        addOn2.setEnabled(false);
        addOn3.setEnabled(false);
        addOn4.setEnabled(false);

        addAction(startButton, pc, hourComboBox, minuteComboBox, cashLabel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void viewSession(int pc){
        mainPanel.removeAll();

        int price = PcList.getPC(pc-1).calculateAmountToPay();
        int length = PcList.getPC(pc-1).getSession().getSessionLength();
        String start = PcList.getPC(pc-1).getSession().getStartTime();

        mainLabel = new JLabel("<html> <p style='font-size: 25px; text-align: center;'> Length: "+length+"min/s <br/> Start: "+start+" <br/> Total: P"+price+".00 <br/></p></html>");

        mainLabel.setFont(new Font("Inter", Font.BOLD, 55));
        mainLabel.setBounds(25,20,300,200);
        mainLabel.setForeground(Color.white);

        pcNumber.setFont(new Font("Inter",Font.BOLD, 18));
        pcNumber.setForeground(Color.WHITE);
        pcNumber.setBounds(130,0,60,50);
        pcNumber.setText("PC " + pc);

        startButton.setText("END SESSION");

        JLabel extendLabel = new JLabel("EXTEND TIME:");
        extendLabel.setFont(new Font("Inter", Font.BOLD, 10));
        extendLabel.setForeground(Color.WHITE);
        extendLabel.setBounds(20,200, 100,100);
        
        JButton extend30 = new JButton("+30");
        extend30.setBounds(20,275,65, 80);
        extend30.setBackground(Color.decode("#232529"));
        extend30.setForeground(Color.WHITE);
        extend30.setLayout(null);
        extend30.setFocusPainted(false);
        extend30.setCursor(new Cursor(Cursor.HAND_CURSOR));

        mainPanel.add(pcNumber);
        mainPanel.add(startButton);
        mainPanel.add(extendLabel);
        mainPanel.add(extend30);
        mainPanel.add(mainLabel);

        extendTime(extend30, pc, mainLabel);
        endSession(startButton, pc);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void outOfOrder(int pc){
        if(pcNumber.getText().equals("" + pc)){
            return;
        }

        mainPanel.removeAll();

        pcNumber.setText("" + pc);

        mainLabel.setText("<html> <p style='font-size: 25px; text-align: center;'>OUT<br/>OF<br/>ORDER</p></html>");
        mainPanel.add(mainLabel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    public static void extendTime(JButton btn, int pc, JLabel label){
        if(btn.getActionListeners().length == 0){
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {  
                    int length = PcList.getPC(pc-1).getSession().getSessionLength()+30;
                    PcList.getPC(pc-1).getSession().setSessionLength(length);
                    int price = PcList.getPC(pc-1).calculateAmountToPay(); 
                    String start = PcList.getPC(pc-1).getSession().getStartTime(); 
                    
                    label.setText("<html> <p style='font-size: 25px; text-align: center;'> Length: "+length+"min/s <br/> Start: "+start+" <br/> Total: P"+price+".00 <br/></p></html>");

                    label.repaint();
                    label.revalidate();
                }
            });
        }
    }
    
    public static void endSession(int pc){
                PcList.getPC(pc).endSession(pc);
                    mainPanel.removeAll();

                    System.out.println("Ending session");
                    
                    mainLabel.setText("<html><div style='text-align: center;'>Select <br/> a PC <br/> to <br /> preview: </div></html>");
                    PcList.getPCStatus(pc).setText("<html><span style='color: red; font-size: 14px;'>•</span></html>");
                    
                    Timer changeToGreen = new Timer(2000,new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            PcList.getPCStatus(pc).setText("<html><span style='color: #00FF00; font-size: 14px;'>•</span></html>");
                            pcNumber.setText("");
                        } 
                    });

                    changeToGreen.setRepeats(false);
                    changeToGreen.start();
                    
                    mainPanel.add(mainLabel);   

                    PageControl.showDashboard();      
    }

    public static void endSession(JButton btn, int pc){
            for (ActionListener listener : btn.getActionListeners()) {
                btn.removeActionListener(listener);
            }

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PcList.getPC(pc-1).endSession(pc-1);
                    mainPanel.removeAll();

                    System.out.println("Ending session");
                    
                    mainLabel.setText("<html><div style='text-align: center;'>Select <br/> a PC <br/> to <br /> preview: </div></html>");
                    PcList.getPCStatus(pc-1).setText("<html><span style='color: red; font-size: 14px;'>•</span></html>");
                    
                    Timer changeToGreen = new Timer(2000,new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            PcList.getPCStatus(pc-1).setText("<html><span style='color: #00FF00; font-size: 14px;'>•</span></html>");
                            pcNumber.setText("");
                        } 
                    });

                    changeToGreen.setRepeats(false);
                    changeToGreen.start();
                    
                    mainPanel.add(mainLabel);   

                    PageControl.showDashboard();
                }
            });
}

    public static void addAction(JButton btn, int pc, JComboBox<String> hourComboBox, JComboBox<String> minuteComboBox,JLabel cashLabel){
            for (ActionListener listener : btn.getActionListeners()) {
                btn.removeActionListener(listener);
                }

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String hourText = (String) hourComboBox.getSelectedItem();
                    String minuteText = (String) minuteComboBox.getSelectedItem();
                    if(hourText == null || minuteText == null || hourText.isEmpty() || minuteText.isEmpty()) return;
                    int sessionLength = (Integer.parseInt(hourText) * 60) + Integer.parseInt(minuteText);
                    int subtotal = (int) Math.ceil(sessionLength * 0.33);

                    // System.out.println("PC: "+ pc);
                    // System.out.println("Length: " + sessionLength);
                    // System.out.println("Total: " + subtotal);
                    
                    if(btn.getText().equals("START SESSION")){
                        PcList.getPC(pc - 1).startSession(sessionLength, pc);
                        PcList.getPCStatus(pc - 1).setText("<html><span style='color: yellow; font-size: 14px;'>•</span></html>");
                        PcList.getPCStatus(pc - 1).revalidate();
                        PcList.getPCStatus(pc - 1).repaint();
                        
                        mainLabel.setFont(new Font("Inter", Font.BOLD, 55));
                        mainLabel.setBounds(30,35,300,400);
                        mainLabel.setForeground(Color.WHITE);
                        
                        mainPanel.removeAll();
                        mainPanel.add(mainLabel);

                        mainPanel.repaint();
                        mainPanel.revalidate();

                        PageControl.showDashboard();
                    }

                    cashLabel.setText("P" + subtotal + ".00");
                    cashLabel.revalidate();
                    cashLabel.repaint();

                    btn.setText("START SESSION");
                    btn.revalidate();
                    btn.repaint();
                }
            });
    }
}