package dashboard.pc_description;

import javax.swing.*;

import data.Data;
import pages.PageControl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.*;
import dashboard.pc_list.*;

public class PCDescription {
    static JPanel mainPanel;

    public static JPanel getPCDescription(int pc) {
        mainPanel = new JPanel();
        if (pc == -1) {
            JLabel mainLabel = new JLabel("<html><div style='text-align: center;'>Select <br/> a PC <br/> to <br /> preview: </div></html>");

            mainPanel.setLayout(null);
            mainPanel.setBounds(585, 30, 300, 500);
            mainPanel.setBackground(new Color(83, 88, 94));

            mainLabel.setFont(new Font("Inter", Font.BOLD, 55));
            mainLabel.setBounds(30, 35, 300, 400);
            mainLabel.setForeground(Color.WHITE);
            mainPanel.add(mainLabel);

            return mainPanel;
        }

        LinkedList data = Data.getData();
        String sessionType = PcList.getPC(pc-1).getSession().getStatus();
        String sessionLength = data.get(pc - 1)[2];
        String toPay = data.get(pc - 1)[3];
        String endTime = data.get(pc-1)[4];

        JButton startButton = new JButton("CALCULATE PAY");

        startButton.setBounds(0, 440, 300, 60);
        startButton.setBackground(Color.decode("#A62122"));
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("Inter", Font.BOLD, 20));
        startButton.setBorder(BorderFactory.createEmptyBorder());
        startButton.setLayout(null);
        startButton.setFocusPainted(false);
        startButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (sessionType.equals("in-session")) {
            JLabel mainLabel = new JLabel("<html><p style='font-size: 25px; text-align: center;'> PC " + pc + "<br/><br/>Length: " + sessionLength + "mins<br/> End Time: "+ endTime  +"<br/>Total: ₱" + toPay + "</p></html>");

            mainPanel.setLayout(null);
            mainPanel.setBounds(585, 30, 300, 500);
            mainPanel.setBackground(new Color(83, 88, 94));

            mainLabel.setFont(new Font("Inter", Font.BOLD, 55));
            mainLabel.setBounds(25, 20, 300, 200);
            mainLabel.setForeground(Color.WHITE);
            mainPanel.add(mainLabel);

            startButton.setText("END SESSION");
            addAction(startButton, pc);

            JLabel extendLabel = new JLabel("EXTEND TIME: ");
            extendLabel.setFont(new Font("Inter", Font.BOLD, 10));
            extendLabel.setForeground(Color.WHITE);
            extendLabel.setBounds(20, 200, 100, 100);
            mainPanel.add(extendLabel);

            JButton extend30 = new JButton("+30");
            extend30.setBounds(20, 275, 65, 80);
            extend30.setBackground(Color.decode("#232529"));
            extend30.setForeground(Color.WHITE);
            extend30.setLayout(null);
            extend30.setFocusPainted(false);
            extend30.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            mainPanel.add(startButton);
            mainPanel.add(extend30);

            extendTime(extend30, mainLabel, pc);

            return mainPanel;
        }

        mainPanel.setLayout(null);
        mainPanel.setBounds(585, 30, 300, 500);
        mainPanel.setBackground(new Color(83, 88, 94));


        mainPanel.add(startButton);

        JLabel pcNumber = new JLabel("PC " + pc);
        pcNumber.setFont(new Font("Inter", Font.BOLD, 18));
        pcNumber.setForeground(Color.WHITE);
        pcNumber.setBounds(130, 0, 55, 50);
        mainPanel.add(pcNumber);

        JLabel categoryLabel = new JLabel("CATEGORY");
        categoryLabel.setFont(new Font("Inter", Font.BOLD, 10));
        categoryLabel.setForeground(Color.WHITE);
        categoryLabel.setBounds(20, 15, 100, 100);
        mainPanel.add(categoryLabel);

        JButton guestButton = new JButton("G");
        guestButton.setFont(new Font("Inter", Font.PLAIN, 15));
        guestButton.setBounds(20, 80, 65, 50);
        guestButton.setBackground(Color.decode("#232529"));
        guestButton.setForeground(Color.WHITE);
        guestButton.setLayout(null);
        guestButton.setFocusPainted(false);
        guestButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        guestButton.setEnabled(false);
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
        sessionLabel.setFont(new Font("Inter", Font.BOLD, 10));
        sessionLabel.setForeground(Color.WHITE);
        sessionLabel.setBounds(20, 125, 100, 100);
        mainPanel.add(sessionLabel);

        JLabel column = new JLabel(":");
        column.setFont(new Font("Inter", Font.BOLD, 15));
        column.setForeground(Color.WHITE);
        column.setBounds(155, 123, 100, 100);
        mainPanel.add(column);

        JTextField hourTimer = new JTextField();
        hourTimer.setBounds(120, 165, 30, 20);
        hourTimer.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(hourTimer);

        JTextField minuteTimer = new JTextField();
        minuteTimer.setBounds(165, 165, 30, 20);
        minuteTimer.setBorder(BorderFactory.createEmptyBorder());
        mainPanel.add(minuteTimer);

        JLabel addOnLabel = new JLabel("ADD ON: ");
        addOnLabel.setFont(new Font("Inter", Font.BOLD, 10));
        addOnLabel.setForeground(Color.WHITE);
        addOnLabel.setBounds(20, 160, 100, 100);
        mainPanel.add(addOnLabel);

        JButton addOn1 = new JButton("Canton");
        addOn1.setBounds(20, 225, 65, 80);
        addOn1.setBackground(Color.decode("#232529"));
        addOn1.setFont(new Font("Inter", Font.BOLD, 6));
        addOn1.setForeground(Color.WHITE);
        addOn1.setLayout(null);
        addOn1.setFocusPainted(false);
        addOn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn1);

        JButton addOn2 = new JButton("Soda");
        addOn2.setBounds(85, 225, 65, 80);
        addOn2.setBackground(Color.decode("#232529"));
        addOn2.setForeground(Color.WHITE);
        addOn2.setFont(new Font("Inter", Font.BOLD, 6));
        addOn2.setLayout(null);
        addOn2.setFocusPainted(false);
        addOn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn2);

        JButton addOn3 = new JButton("Water");
        addOn3.setBounds(150, 225, 65, 80);
        addOn3.setBackground(Color.decode("#232529"));
        addOn3.setForeground(Color.WHITE);
        addOn3.setFont(new Font("Inter", Font.BOLD, 6));
        addOn3.setLayout(null);
        addOn3.setFocusPainted(false);
        addOn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn3);

        JButton addOn4 = new JButton("Coffee");
        addOn4.setBounds(215, 225, 65, 80);
        addOn4.setBackground(Color.decode("#232529"));
        addOn4.setFont(new Font("Inter", Font.BOLD, 6));
        addOn4.setForeground(Color.WHITE);
        addOn4.setLayout(null);
        addOn4.setFocusPainted(false);
        addOn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mainPanel.add(addOn4);

        addOn1.setEnabled(false);
        addOn2.setEnabled(false);
        addOn3.setEnabled(false);
        addOn4.setEnabled(false);

        JLabel subtotalLabel = new JLabel("Subtotal: ");
        subtotalLabel.setFont(new Font("Inter", Font.BOLD, 25));
        subtotalLabel.setForeground(Color.WHITE);
        subtotalLabel.setBounds(20, 300, 200, 100);
        mainPanel.add(subtotalLabel);

        JLabel cashLabel = new JLabel("₱0.00");
        cashLabel.setFont(new Font("Inter", Font.BOLD, 35));
        cashLabel.setForeground(Color.WHITE);
        cashLabel.setBounds(100, 345, 200, 100);
        mainPanel.add(cashLabel);

        addAction(startButton, hourTimer, minuteTimer, cashLabel, pc);

        return mainPanel;
    }

    public static void extendTime(JButton btn, JLabel label, int pc) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)  {
                int sessionLength = PcList.getPC(pc-1).getSession().getSessionLength() + 30;
                int toPay = PcList.getPC(pc-1).getSession().getAmountToPay() + 10;

                
                PcList.getPC(pc-1).updateSession(sessionLength);
                
                Data.updateSession(pc, sessionLength, toPay);
                
                label.setText("<html><p style='font-size: 25px; text-align: center;'> PC " + pc + "<br/><br/>Length: " + sessionLength + "mins<br/> End Time: "+ Data.getData().get(pc-1)[4]  +"<br/>Total: ₱" + toPay + "</p></html>");
            }
        });
    }

    public static void addAction(JButton btn, int pc) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PcList.getPC(pc-1).endSession(pc);
                PageControl.showDashboard(-1);
            }

        });
    }

    public static void addAction(JButton btn, JTextField hourTimer, JTextField minuteTimer, JLabel cashLabel, int pc) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int toPay = 0;
            
                int sessionLength = (Integer.parseInt(hourTimer.getText()) * 60) + Integer.parseInt(minuteTimer.getText());


                if (btn.getText().equals("START SESSION")) {

                    PcList.getPC(pc-1).startSession(sessionLength, pc);
                    PcList.getPC(pc-1).calculateAmountToPay();

                    toPay = PcList.getPC(pc-1).getSession().getAmountToPay();

                    Data.startSession(pc, sessionLength, toPay);

                    PageControl.showDashboard(-1);
                }
                PcList.getPC(pc-1).getSession().setSessionLength(sessionLength);
                PcList.getPC(pc-1).calculateAmountToPay();

                toPay = PcList.getPC(pc-1).getSession().getAmountToPay();

                cashLabel.setText("₱" + toPay + ".00");
                cashLabel.setBounds(85, 345, 200, 100);
                btn.setText("START SESSION");
            }

        });
    }
}