package header;

import javax.swing.*;
import create_component.Create_Component;
import data.Data;
import pages.PageControl;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

public class Header {
    
    // Method to create the header panel
    public static JPanel getHeader() {
        // Create time and date labels
        JLabel time = Create_Component.Label(150, 0, 100, 100, "", "Arial", Font.BOLD, 30, 255, 255, 255, 255, 255, 255);
        JLabel date = Create_Component.Label(255, 0, 300, 100, "", "Arial", Font.BOLD, 20, 255, 255, 255, 255, 255, 255);

        // Create logo panel
        JPanel armoniaLogo = Create_Component.ImagePanel("public/armonia-logo.png", 5, 0, 100, 100);

        // Create and configure the header panel
        JPanel header = new JPanel();
        JPanel logoPanel = new JPanel();
        header.setBounds(0, 0, 975, 100);
        header.setBackground(new Color(23, 26, 30));
        header.setLayout(null);

        logoPanel.setBounds(0, 0, 115, 100);
        logoPanel.setBackground(new Color(166, 33, 34));
        logoPanel.setLayout(null);
        logoPanel.add(armoniaLogo);

        // Add components to the header panel
        header.add(logoPanel);
        header.add(time);
        header.add(date);

        // Start updating the time and checking session status
        updateTime(time, date);

        return header;
    }

    // Method to update the time and check for session expiration
    public static void updateTime(JLabel time, JLabel date) {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime timeNow = LocalTime.now();
                LocalDate dateNow = LocalDate.now();

                String minute = String.format("%02d", timeNow.getMinute());
                String hour = String.format("%02d", timeNow.getHour());
                String parsedTime = hour + ":" + minute;

                String parsedDate = dateNow.getMonth().toString().toLowerCase() + " " + dateNow.getDayOfMonth() + ", " + dateNow.getYear();
                parsedDate = parsedDate.substring(0, 1).toUpperCase() + parsedDate.substring(1);

                time.setText(parsedTime);
                date.setText(parsedDate);

                checkForSessionEnd(parsedTime);
            }
        });
        timer.start();
    }

    // Method to check for session expiration
    private static void checkForSessionEnd(String parsedTime) {
        for (int i = 0; i < Data.getData().size(); i++) {
            final int currentIndex = i;
            String[] pcData = Data.getData().get(i); // pcnumber, status, timeInMinutes, to-pay, endTime
            String endTime = pcData[4];

            if (parsedTime.equals(endTime)) {
                String[] newData = {
                    (i + 1) + "", // PC number
                    "out-of-time", // Status
                    pcData[2], // Time in minutes
                    pcData[3], // Total to pay
                    pcData[4]  // End time
                };
                // Update the data
                Data.getData().set(i, newData);
                
                Timer task = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        Data.endSession(currentIndex + 1);
                        PageControl.showDashboard(-1);
                        ((Timer) e.getSource()).stop();
                    }
                });
                task.start();;

                PageControl.showDashboard(-1);
            }
        }
    }
}