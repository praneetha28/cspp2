public class PhysicalActivity extends Log {
    String activityName;
    String endTime;
    String notes;
    PhysicalActivity(String actyName, String dte, String tme, String endTme, String ntes) {
        this.activityName = actyName;
        this.setDate(dte);
        this.setTime(tme);
        this.endTime = endTme;
        this.notes = ntes;
    }
    public String getActivityName() {
        return activityName;
    }
    public String getEndTime() {
        return endTime;
    }
    public String getNotes() {
        return notes;
    }
    public void setActivityName(String actyName) {
        this.activityName = actyName;
    }
    public void setEndTime(String endTme) {
        this.endTime = endTme;
    }
    public void setNotes(String ntes) {
        this.notes = ntes;
    }
    public String toString() {
        System.out.println("PhysicalActivity");
        return "Name:" + this.getActivityName() + "\n" +"Notes:"+ this.getNotes()+ " \n" +"Date:" +this.getDate() + "\n" +"Starttime:" +this.getTime() + "\n" + "Endtime:" +this.getEndTime();
    }
}