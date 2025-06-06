public class Menu {

    String category;
    String status;
    String name;
    char size;
    String description;
    double price;

// Constructor to ADD stuff to menu
public Menu(String category, String name, double price, char size) {
    this.category = category,
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