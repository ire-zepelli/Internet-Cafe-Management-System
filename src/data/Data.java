package data;

public class Data {
    static LinkedList data = new LinkedList();

   public Data(){
        initialize();
    }

    public void initialize(){
        for(int i = 1; i <= 25; i++){
            // pcnumber, status, end-time, to-pay
            data.insertFront(new String[]{i+"","available","",""});
        }
    }

     public static LinkedList getData(){
           return data;
   } 

  public static void startSession(int pc, int sessionLength, int toPay){
    data.set(pc-1, new String[]{pc+"", "in-session", sessionLength+"", toPay+""});
  }

  public static void endSession(int pc){
    data.set(pc-1, new String[]{pc+"", "available", "", ""});
  }

  public static void updateSession(int pc, String sessionLength, String toPay){
    data.set(pc-1, new String[]{pc+"", "in-session", sessionLength, toPay+""});
  }
}
