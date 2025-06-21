import java.util.Scanner;

public class EmployeeMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        // Add employees
        Employee employee1 = new Employee(1, "Nary", "Morning & Afternoon", "012 345 678", "Cashier", "xxxx");
        Employee employee2 = new Employee(2, "Neath", "Morning & Afternoon", "012 345 678", "Waitress", "xxxx");
        restaurant.addEmployee(employee1);
        restaurant.addEmployee(employee2);

        // Add menu items
        Menu menu1 = new Menu("Main course", 10.0, "available", "Fried Rice", "F101", "img1", "Spicy fried rice", 3.0, "M");
        Menu menu2 = new Menu("Side course", 10.0, "available", "Salad", "F102", "img2", "Salad with hard dressing", 2.0, "none");
        restaurant.addMenuItem(menu1);
        restaurant.addMenuItem(menu2);

        // Display menu
        System.out.println("Menu:");
        restaurant.displayMenu();

        // Simulate placing an order
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Table Number: ");
        int tableNumber = scanner.nextInt();
        System.out.print("Enter Item ID: ");
        String itemId = scanner.next();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Remark: ");
        String remark = scanner.next();

        // Find the menu item based on itemId
        Menu selectedItem = null;
        for (Menu item : restaurant.menuItems) {
            if (item.getItemId().equals(itemId)) {
                selectedItem = item;
                break;
            }
        }

        if (selectedItem != null) {
            // Calculate total cost
            double totalCost = selectedItem.getPrice() * quantity;

            // Create an order
            Order newOrder = new Order(Order.generateOrderId(), "Accept", tableNumber, itemId, selectedItem.getPrice(),
                                       quantity, totalCost, "04/05/25-1:02pm", remark, 1);
            restaurant.addOrder(newOrder);

            // Generate receipt
            Receipt newReceipt = new Receipt(1, totalCost, 1); // Assume employee ID is 1
            restaurant.addReceipt(newReceipt);

            System.out.println("Order placed successfully!");
            System.out.println("Receipt ID: " + newReceipt.getReceiptId());
            System.out.println("Total Cost: $" + newReceipt.getTotalCost());
        } else {
            System.out.println("Item not found in the menu.");
        }

        scanner.close();
    }
}
