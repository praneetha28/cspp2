import java.util.Scanner;
/**.
 * Class for patron.
 */
final class Item {
	private String productname;
	private int quantity;
	private float price;
	public Item(final String prdtnme, final int qty, final float prce) {
        this.productname = prdtnme;
        this.quantity = qty;
        this.price = prce;
    }
    public String getproductname() {
        return productname;
    }
    public int getquantity() {
        return quantity;
    }
    public float getprice() {
        return price;
    }
    public void setquantity(final int q ) {
        this.quantity = q;
    }
    public String toString() {
        return this.getproductname() + " " + this.getquantity() + " " + this.getprice();
    }
    public void setprice(final float prce) {
        this.price = prce;
    }
    @Override
    public boolean equals(final Object item) {
        Item myItem = (Item)item;
        return this.getproductname().equals(myItem.getproductname());
    }
}
public final class ShoppingCart {
    /**.
     * { var_description }
     */
    private List<Item> catalog;
    /**.
     * { var_description }
     */
    private List<Item> cart;
    private float couponCode;
    private boolean isCouponApplied;
    private static final float value1 = 0.1f;
    private static final float value2 = 0.2f;
    private static final float value3 = 0.3f;
    private static final float value4 = 0.5f;
    public ShoppingCart() {
        catalog = new List<Item>();
        cart = new List<Item>();
        isCouponApplied = false;
    }
	public void addToCatalog(Item i) {
        int index = catalog.indexOf(i);
        if (index == -1) {
            catalog.add(i);
        }
    }
    public void addToCart(Item item) {
        int index = catalog.indexOf(item);
        Item catalogItem = catalog.get(index);
        index = cart.indexOf(item);
        Item cartItem = cart.get(index);
        if (cartItem != null) {
            cartItem.setquantity(cartItem.getquantity() + item.getquantity());
            catalogItem.setquantity(catalogItem.getquantity()
                - item.getquantity());
            return;
        }
        if (catalogItem.getquantity() >= item.getquantity()) {
            item.setprice(catalogItem.getprice());
            cart.add(item);
            catalogItem.setquantity(catalogItem.getquantity()
                - item.getquantity());
        }
    }
    public void removeFromCart(Item item) {
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
    public void showCart() {
        for (int i = 0; i < cart.size(); i++ ) {
            System.out.println(cart.get(i).getproductname() + " " + cart.get(i).getquantity());
        }
    }
    public void showCatalog() {
        for (int i = 0; i < catalog.size(); i++ ) {
            System.out.println(catalog.get(i));
        }
    }
    public float getTotalAmount() {
        float amount = 0.0f;
        for (int i = 0; i < cart.size(); i++ ) {
            amount += cart.get(i).getquantity() * catalog.get(i).getprice();
        }
        return amount;
    }
    public float getPayableAmount() {
        float amount = getTotalAmount();
        float discount = amount * couponCode;
        amount = amount - discount;
        float payableamt = amount + (amount * 0.15f);
        return payableamt;
    }
    public void applyCoupon(final String coupon) {
        if (isCouponApplied) {
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
    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        for (int i = 0; i < cart.size(); i++) {
           System.out.println(cart.get(i));
        }
        System.out.println("Total:" + getTotalAmount());
        if (!isCouponApplied) {
            float amount = getTotalAmount();
            float disc = amount * couponCode;
            System.out.println("Disc%:" + disc);
            float tax = (amount - disc) * 0.5f;
            System.out.println("Tax:" + tax);
            amount = amount + tax;
            System.out.println("Payable amount:" + amount);
        } else {
            float amount = getTotalAmount();
            System.out.println("Disc%:" + 0.0);
            float tax = amount * 0.5f;
            System.out.println("Tax:" + tax);
            amount = amount + tax;
            System.out.println("Payable amount:" + amount);
        }
    }
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