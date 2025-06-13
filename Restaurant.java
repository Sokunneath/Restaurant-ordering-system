public class Restaurant {

    public static void main(String[] args) {
        // Simulate QR code scan result
        String qrData = "https://restaurant.com/order?table=5";
        int tableNumber = getTableFromQR(qrData);

        // Welcome message
        System.out.println("Welcome to My Restaurant 🍽️");
        System.out.println("You are seated at Table " + tableNumber);
        System.out.println("Please choose from our menu below:\n");

    }
    }
