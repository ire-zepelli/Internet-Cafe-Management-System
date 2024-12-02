package header;

import javax.swing.*;

import create_component.Create_Component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class Header{
    public static JPanel getHeader(){
        JLabel time = Create_Component.Label(150, 0, 100, 100, "00:00", "Arial", Font.BOLD, 30, 255, 255, 255, 255, 255, 255);
        JLabel date = Create_Component.Label(255, 0, 300, 100, "MM:DD:YY", "Arial", Font.BOLD, 20, 255, 255, 255, 255, 255, 255);
        JPanel armoniaLogo = Create_Component.ImagePanel("public/armonia-logo.png", 5, 0, 100, 100);
        JPanel header = new JPanel();
        JPanel logoPanel = new JPanel();

        header.setBounds(0,0,975,100);
        header.setBackground(new Color(23, 26, 30));
        header.setLayout(null);
        
        logoPanel.setBounds(0,0, 115, 100);
        logoPanel.setBackground(new Color(166,33,34));
        logoPanel.setLayout(null);
        logoPanel.add(armoniaLogo);
        
        header.add(logoPanel);
        header.add(time);
        header.add(date);
        
        updateTime(time,date);

        return header;
    }

    public static void updateTime(JLabel time, JLabel date){
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime timeNow = LocalTime.now();
                LocalDate dateNow = LocalDate.now();
                String minute = "" + timeNow.getMinute();
                String hour = "" + timeNow.getHour();
                String parsedTime = (hour.length() == 1 ? "0" + hour : hour ) +":"+ (minute.length() == 1 ? "0" + minute : minute);
                String parsedDate = dateNow.getMonth().toString().toLowerCase() + " " + dateNow.getDayOfMonth() + ", " + dateNow.getYear();
                parsedDate = parsedDate.replace(parsedDate.charAt(0), Character.toUpperCase(parsedDate.charAt(0)));
                time.setText(parsedTime);
                date.setText(parsedDate);
            }});

        timer.start();
    }
}