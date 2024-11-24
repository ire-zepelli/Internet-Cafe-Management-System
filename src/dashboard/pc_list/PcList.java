package dashboard.pc_list;

import javax.swing.*;
import java.awt.*;

public class PcList {
   public static JPanel getPcList(){
        JPanel mainPanel;

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        mainPanel.setBounds(35,75,500,400);
        mainPanel.setBackground(new Color(83,88,94));

        return mainPanel;
   } 

   public static JPanel addPc(int pcNumber, Color c){
        JPanel pcPanel = new JPanel();
        
        pcPanel.setPreferredSize(new Dimension(100,100));
           
        return pcPanel;
   }
}
