package dashboard.pc_list;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Session {
    private int sessionLength;
    private String startTime;
    private int amountToPay;

    public Session(int sessionLength) {
        this.sessionLength = sessionLength;
    }

    public void startSession(int pc){
        LocalTime lt = LocalTime.now();
		DateTimeFormatter formatterLocalTime = DateTimeFormatter.ofPattern("HH:mm");
		startTime = formatterLocalTime.format(lt);

        System.out.println("Session has started...");
        // Data.startSession(pc, sessionLength, calculateAmount());
    }

    public String getStartTime(){
        return startTime;
    }

    public void endSession(int pc){
        System.out.println("Session end session");
        // Data.endSession(pc);
    }

    public abstract int calculateAmount();

    public int getSessionLength() {
        return sessionLength;
    }

    public void setSessionLength(int sessionLength) {
        this.sessionLength = sessionLength;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(int amountToPay){
        this.amountToPay = amountToPay;
    }

}