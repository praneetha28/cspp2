/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for item.
 */
class Item {
    /**.
     * { var_description }
     */
    private String productname;
    /**.
     * { var_description }
     */
    private int quantity;
    /**.
     * { var_description }
     */
    private float price;
    /**.
     * Constructs the object.
     *
     * @param      name   The name
     * @param      qnt    The qnt
     * @param      prce  The price
     */
    Item(final String name, final int qnt, final float prce) {
        this.productname = name;
        this.quantity = qnt;
        this.price = prce;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String getproductname() {
        return productname;
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int getquantity() {
        return quantity;
    }
    /**.
     * { function_description }
     *
     * @param      qnt   The qnt
     */
    public void setquantity(final int qnt) {
        this.quantity = qnt;
    }
    /**.
     * Gets the price.
     *
     * @return     The price.
     */
    public float getPrice() {
        return price;
    }
    /**.
     * Sets the price.
     *
     * @param      prce  The prce
     */
    public void setPrice(final float prce) {
        this.price = prce;
    }
    /**.
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.getproductname() + " " + this.getquantity()
        + " " + this.getPrice();
    }
    /**.
     * { function_description }
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    @Override
    public boolean equals(final Object item) {
        Item myItem = (Item) item;
        return this.getproductname().equals(myItem.getproductname());
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int hashCode() {
        return this.hashCode();
    }
}
/**.
 * { item_description }
 */
public final class ShoppingCart {
    /**.
     * { var_description }
     */
    private List<Item> catalog;
    /**.
     * { var_description }
     */
    private List<Item> cart;
    /**.
     * { var_description }
     */
    private float couponCode;
    /**.
     * { var_description }
     */
    private boolean isCouponApplied;
    /**.
     * Constructs the object.
     */
    ShoppingCart() {
        catalog = new List<Item>();
        cart = new List<Item>();
        isCouponApplied = false;
    }
    /**.
     * Adds to catalog.
     *
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        int index = catalog.indexOf(item);
        if (index == -1) {
            catalog.add(item);
        }
    }
    /**.
     * Adds to cartesian.
     *
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        int index = catalog.indexOf(item);
        Item catalogItem = catalog.get(index);
        index = cart.indexOf(item);

        Item cartItem = cart.get(index);
        if (cartItem != null) {
            cartItem.setquantity(cartItem.getquantity() +
                item.getquantity());
            catalogItem.setquantity(catalogItem.getquantity()
             - item.getquantity());
            return;
        }
        if (catalogItem.getquantity() >= item.getquantity()) {
            item.setPrice(catalogItem.getPrice());
            cart.add(item);
            catalogItem.setquantity(catalogItem.getquantity()
             - item.getquantity());
        }
    }
    /**.
     * Removes a from cartesian.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        int index = catalog.indexOf(item);
        Item catalogItem = catalog.get(index);

        index = cart.indexOf(item);
        Item cartItem = cart.get(index);

        if (cartItem != null) {
            if (cartItem.getquantity() == item.getquantity()) {
                cart.remove(index);
            } else {
                cartItem.setquantity(cartItem.getquantity()
                 - item.getquantity());
                catalogItem.setquantity(catalogItem.getquantity()
                 + item.getquantity());
            }
        }
    }
    /**.
     * Shows the cartesian.
     */
    public void showCart() {
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            // System.out.println(item);
            System.out.println(item.getproductname() + " " +
             item.getquantity());
        }
    }
    /**.
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println(catalog.get(i));
        }
    }
    /**.
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    public float getTotalAmount() {
        float totalAmount = 0.0f;
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            totalAmount = totalAmount + item.getquantity()
             * item.getPrice();
        }
        return totalAmount;
    }
    /**.
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public float getPayableAmount() {
        float totalAmount = getTotalAmount();
        float disc = totalAmount * couponCode;
        totalAmount = totalAmount - disc;
        float payableAmount = totalAmount + (totalAmount * 0.15f);
        return payableAmount;
    }
    /**.
     * { function_description }
     *
     * @param      coupon  The coupon
     */
    public void applyCoupon(final String coupon) {
        if (isCouponApplied == false) {
            if (coupon.equals("IND10")) {
            couponCode = 0.1f;
            } else if (coupon.equals("IND20")) {
                couponCode = 0.2f;
            } else if (coupon.equals("IND30")) {
                couponCode = 0.3f;
            } else if (coupon.equals("IND50")) {
                couponCode = 0.5f;
            } else {
                System.out.println("Invalid coupon");
                return;
            }
            isCouponApplied = true;
        }
    }
    /**.
     * { function_description }
     */
    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i));
        }
        System.out.println("Total:" + getTotalAmount());
        if (isCouponApplied == true) {
            float totalAmount = getTotalAmount();
            float disc = totalAmount * couponCode;
            System.out.println("Disc%:" + disc);
            totalAmount = totalAmount - disc;
            float tax = (totalAmount * 15) / 100;
            System.out.println("Tax:" + tax);
            totalAmount = totalAmount + tax;
            System.out.println("Payable amount: " + totalAmount);
        } else {
            float totalAmount = getTotalAmount();
            System.out.println("Disc%:" + 0.0);
            float tax = (totalAmount * 15) / 100;
            System.out.println("Tax:" + tax);
            totalAmount = totalAmount + tax;
            System.out.println("Payable amount: " + totalAmount);
        }
    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart sc = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String line = scan.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Item":
                String[] c1 = tokens[1].split(",");
                sc.addToCatalog(new Item(c1[0],
                    Integer.parseInt(c1[1]), Float.parseFloat(c1[2])));
                //sc.addToCatalog(it);
                break;

                case "catalog":
                    sc.showCatalog();
                break;

                case "add":
                    String[] c2 = tokens[1].split(",");
                    sc.addToCart(new Item(c2[0],
                        Integer.parseInt(c2[1]), 0.0f));
                    //sc.addToCart(it);
                break;

                case "remove":
                    String[] c3 = tokens[1].split(",");
                    sc.removeFromCart(new Item(c3[0],
                        Integer.parseInt(c3[1]), 0.0f));
                    //sc.remove(it);
                break;
                case "show":
                    sc.showCart();
                break;
                case "totalAmount":
                    System.out.println("totalAmount: " + sc.getTotalAmount());
                break;
                case "payableAmount":
                    System.out.println("Payable amount: " + sc.
                        getPayableAmount());
                break;
                case "print":
                    sc.printInvoice();
                break;
                case "coupon":
                    sc.applyCoupon(tokens[1]);
                break;
                default:
                break;
            }

        }
    }
}

