package dashboard.pc_list;
public class PCSession extends Session{
   private String status;
   
   public PCSession(int sessionLength, String status) {
        super(sessionLength); 
        this.status = status;
    }

   public void updateStatus(String newStatus){
        this.status = newStatus;
   }

   @Override
   public int calculateAmount(){
        int toPay = (int) Math.ceil(getSessionLength() * 0.33);
        setAmountToPay(toPay);
        return toPay;
   }

   public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
