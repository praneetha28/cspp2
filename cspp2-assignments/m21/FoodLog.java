public class FoodLog extends Log {
    String foodItem;
    float quantity;
    FoodLog(String fdItem, float qty, String dte, String tme) {
        this.foodItem = fdItem;
        this.quantity = qty;
        this.setDate(dte);
        this.setTime(tme);
    }
    public String getFoodItem() {
        return foodItem;
    }
    public float getQuantity() {
        return quantity;
    }
    public void setFoodItem(String fitem) {
        this.foodItem = fitem;
    }
    public void setQuantity(float qty) {
        this.quantity = qty;
    }
    public String toString() {
        System.out.println("Food");
        return "Date:" + this.getDate() +"\n"+ "Time:" + this.getTime() + "\n" +"Name:"+this.getFoodItem() + "\n" + "Quantity:" +this.getQuantity();
    }
}