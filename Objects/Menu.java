package Objects;

import java.util.ArrayList; // Import ArrayList for the static list
import java.util.Objects;   // Import Objects for hash and equals utility methods

public class Menu {
    private int id;
    private String name;
    private char size; // Consider an Enum for sizes (e.g., SMALL, MEDIUM, LARGE) in a more complex app
    private String description;
    private double price;
    private String category; // Consider an Enum for categories as well
    private String imageUrl; // URL to an image of the menu item

    // Static counter to ensure unique IDs for each menu item
    private static int idCounter = 1;

    // Static list to keep track of all created Menu objects
    public static final ArrayList<Menu> menuItems = new ArrayList<>();

    public Menu(String name, char size, String description, double price, String category, String imageUrl) {
        // Assign a unique ID using the static counter
        this.id = idCounter++;
        setName(name);           
        setSize(size);        
        setDescription(description);
        setPrice(price);          
        setCategory(category);    
        setImageUrl(imageUrl);    
        menuItems.add(this);    
    }

    // --- Getters and Setters with Validation ---

    public int getId() {
        return id;
    }
    // No public setId() as ID should be set only once by the constructor.
    // If you absolutely needed to change an ID (uncommon for unique identifiers),
    // you'd make this method private or protected for specific internal use.

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim(); // Trim whitespace
        } else {
            System.out.println("Error: Menu item name cannot be null or empty. Name not set.");
            // You might throw an IllegalArgumentException here in a production system
        }
    }

    public char getSize() {
        return size;
    }
    public void setSize(char size) {
        char upperCaseSize = Character.toUpperCase(size); // Normalize size to uppercase
        if (upperCaseSize == 'S' || upperCaseSize == 'M' || upperCaseSize == 'L' || upperCaseSize == 'X') {
            this.size = upperCaseSize;
        } else {
            System.out.println("Error: Invalid size. Please use 'S', 'M', 'L', or 'X'. Size not set.");
        }
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        // Description can be empty, but not null
        if (description != null) {
            this.description = description.trim();
        } else {
            System.out.println("Error: Description cannot be null. Set to empty string.");
            this.description = ""; // Default to empty string if null
        }
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price > 0) { // Price must be positive
            this.price = price;
        } else {
            System.out.println("Error: Price must be a positive value. Price not set.");
        }
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        if (category != null && !category.trim().isEmpty()) {
            this.category = category.trim();
        } else {
            System.out.println("Error: Category cannot be null or empty. Category not set.");
        }
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // --- Overridden Methods for better object handling ---

    @Override
    public String toString() {
        return String.format("Menu Item ID: %d, Name: %s (Size: %s), Price: $%.2f, Category: %s",
                             id, name, size, price, category);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Same object instance
        if (obj == null || getClass() != obj.getClass()) return false; // Null or different class
        Menu menu = (Menu) obj; // Cast to Menu
        return id == menu.id; // Equality based on unique ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Hash code based on unique ID
    }
}
