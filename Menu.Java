public class Menu {
    private String category;
    private double promotionPercentage;
    private String status;
    private String itemName;
    private String itemId;
    private String image;
    private String description;
    private double price;
    private String size;

    // Constructor
    public Menu(String category, double promotionPercentage, String status, String itemName, String itemId,
               String image, String description, double price, String size) {
        this.category = category;
        this.promotionPercentage = promotionPercentage;
        this.status = status;
        this.itemName = itemName;
        this.itemId = itemId;
        this.image = image;
        this.description = description;
        this.price = price;
        this.size = size;
    }

    // Getters and Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPromotionPercentage() {
        return promotionPercentage;
    }

    public void setPromotionPercentage(double promotionPercentage) {
        this.promotionPercentage = promotionPercentage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}