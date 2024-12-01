package data;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Data {
    static LinkedList data = new LinkedList();

   public Data(){
        initialize();
    }

    public void initialize(){
        for(int i = 1; i <= 25; i++){
            // pcnumber, status, timeInMinutes, to-pay, endTime
            data.insertFront(new String[]{i+"","available","","", ""});
        }
    }

     public static LinkedList getData(){
          //pc data here!!!
          data.set(1, new String[]{""+2, "maintenance", "", "", ""});
          data.set(12, new String[]{""+13, "maintenance", "", "", ""});
          data.set(13, new String[]{""+14, "maintenance", "", "", ""});
          data.set(24, new String[]{""+25, "maintenance", "", "", ""});

           return data;
   } 

  public static void startSession(int pc, int sessionLength, int toPay){
    LocalTime currTime = LocalTime.now();
    LocalTime newTime = currTime.plusMinutes(sessionLength);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    String endTime = newTime.format(formatter);

    data.set(pc-1, new String[]{pc+"", "in-session", sessionLength+"", toPay+"", endTime});
  }

  public static void endSession(int pc){
    data.set(pc-1, new String[]{pc+"", "available", "", "", ""});
  }

  public static void updateSession(int pc, int sessionLength, int toPay){
    LocalTime endTime = LocalTime.parse(data.get(pc-1)[4]);
    endTime = endTime.plusMinutes(30);
    System.out.println("End Time: " + endTime.toString());

    data.set(pc-1, new String[]{pc+"", "in-session", sessionLength + "", toPay+"", endTime.toString()});
  }
}