public class Menu {

    private String category;
    private String status;
    private String name;
    private char size;
    private String description;
    private double price;

// Constructor to ADD stuff to menu
public Menu(String category, String name, double price, char size) {
    this.category = category;
    this.name = name;
    this.price = price;
    this.size = size;
}

// Constructor to ADD stuff to order
public Menu(String category, String name, double price, char size, String description, String status) {
    this.category = category;
    this.name = name;
    this.price = price;
    this.size = size;
    this.description = description;
    this.status = status;
}
}