public class Weight extends Log {
    String weight;
    String fat;
    Weight(String dte, String tme, String wght, String ft) {
        this.setDate(dte);
        this.setTime(tme);
        this.weight = wght;
        this.fat = ft;
    }
    public String getWeight() {
        return weight;
    }
    public String getFat() {
        return fat;
    }
    public void setWeight(String wght) {
        this.weight = wght;
    }
    public void setFat(String ft) {
        this.fat = ft;
    }
    public String toString() {
        System.out.println("Weight");
        return  "Date:" +this.getDate() + "\n" + "Time:" +this.getTime()+"\n"+ "Weight:" +this.getWeight() + "\n" + "Fat:"+ this.getFat();
    }
}