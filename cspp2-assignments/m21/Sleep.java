public class Sleep extends Log {
    String endTime;
    Sleep(String dte, String tme, String endtme) {
        this.setDate(dte);
        this.setTime(tme);
        this.endTime = endtme;
    }
    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endtme) {
        this.endTime = endtme;
    }
    public String toString() {
        System.out.println("Sleep");
        return "Date:"+this.getDate() + "\n" + "Starttime:"+this.getTime() + "\n" +"Endtime:"+this.getEndTime();
    }
}