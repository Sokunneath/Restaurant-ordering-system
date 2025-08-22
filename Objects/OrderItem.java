package Objects;

public class OrderItem {
    protected int itemId;
    protected String itemName;
    protected double itemPrice;
    protected int quantity;

//constructor 
    public OrderItem(int itemId, String itemName, double itemPrice, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        
    }
// getter, setter 
    
    public int getItemId() {
        return itemId;
    } 

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalStateException("Item name is not set or empty.");
        }
        return itemName;
    }

    public void setItemName(String itemName) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }
        this.itemName = itemName;
    }

    public double getItemPrice() {
        if (itemPrice < 0) {
            throw new IllegalStateException("Item price is invalid (negative value).");
        }
        return itemPrice;
    }

  public void setItemPrice(double itemPrice) {
        if (itemPrice < 0) {
            throw new IllegalArgumentException("Item price cannot be negative.");
        }
        this.itemPrice = itemPrice;
    }

    public int getQuantity() {
    if (quantity <= 0) {
        throw new IllegalStateException("Quantity is invalid. It must be greater than zero.");
    }
    return quantity;
    }

    public void setQuantity(int quantity) {
    if (quantity <= 0) {
        throw new IllegalArgumentException("Quantity must be greater than zero.");
    }
    this.quantity = quantity;
    } // creates OrderItem objects when the customer actually order
    


    @Override
    public String toString() {
        return getItemName() + " (Qty: " + getQuantity() + ", Price: $" + getItemPrice() + ")";
    }
}
