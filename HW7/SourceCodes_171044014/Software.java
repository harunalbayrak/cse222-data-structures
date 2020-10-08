/**
 * The type Software.
 */
public class Software implements Comparable<Software> {
    private String name;
    private int quantity;
    private String price;

    /**
     * Instantiates a new Software.
     *
     * @param name the name
     */
    public Software(String name){
        this.name = name;
        this.price = "0";
        this.quantity = 1;
    }

    /**
     * Instantiates a new Software.
     *
     * @param name  the name
     * @param price the price
     */
    public Software(String name, String price){
        this.name = name;
        this.price = price;
        this.quantity = 1;
    }

    /**
     * Instantiates a new Software.
     *
     * @param name     the name
     * @param quantity the quantity
     * @param price    the price
     */
    public Software(String name,int quantity, String price){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Increment quantity.
     */
    public void incrementQuantity() {
        this.quantity++;
    }

    /**
     * Decrement quantity.
     */
    public void decrementQuantity() {
        this.quantity--;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - Quantity: " + quantity + " - Price: " + price + "\n";
    }

    @Override
    public int compareTo(Software o) {
        if(o == null)
            return -1;
        return name.compareTo(o.getName());
    }
}
