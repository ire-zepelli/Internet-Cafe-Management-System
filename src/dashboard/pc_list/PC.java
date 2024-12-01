package dashboard.pc_list;
public class PC implements Payable {
   private int pcNumber;
   private PCSession session;

   public PC(int pcNumber) {
        this.pcNumber = pcNumber;
        this.session = new PCSession(0, "available");
    }

    public void startSession(int sessionLength, int pc) {
        session = new PCSession(sessionLength, "in-session");
        session.startSession(pc);
    }

    public void endSession(int pc) {
        this.session = new PCSession(0, "available");
        session.endSession(pc);
    }

     public void updateStatus(String newStatus) {
        session.updateStatus(newStatus);
    }

    public int calculateAmountToPay() {
        return session.calculateAmount();
    }

    public int getPcNumber() {
        return pcNumber;
    }

    public void setPcNumber(int pcNumber) {
        this.pcNumber = pcNumber;
    }

    public PCSession getSession() {
        return session;
    }

    public void setSession(PCSession session) {
        this.session = session;
    }
}
