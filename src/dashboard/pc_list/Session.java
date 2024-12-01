package dashboard.pc_list;

import data.Data;

public abstract class Session {
    private int sessionLength;
    private int amountToPay;

    public Session(int sessionLength) {
        this.sessionLength = sessionLength;
    }

    public void startSession(int pc){
        Data.startSession(pc, sessionLength, calculateAmount());
    }

    public void endSession(int pc){
        Data.endSession(pc);
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
