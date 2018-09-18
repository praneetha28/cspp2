public class WaterLog extends Log {
    int amount;
    WaterLog(int amt, String dte, String tme) {
        this.amount = amt;
        this.setDate(dte);
        this.setTime(tme);
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amt) {
        this.amount = amt;
    }
    public String toString() {
        System.out.println("Water");
        return "Date:" +this.getDate() + "\n" + "Quantity:" + this.getAmount() + "ml";
    }
}