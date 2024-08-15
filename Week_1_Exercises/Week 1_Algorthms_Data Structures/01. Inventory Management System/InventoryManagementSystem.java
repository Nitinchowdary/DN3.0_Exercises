import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Quantity=" + quantity + ", Price=" + price + "]";
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, String name, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Enter new Product:");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Show Inventory");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            if (choice == -1) {
                break;
            }

            String id, name;
            int quant;
            double price;
            switch (choice) {
                case 1:
                    System.out.println("Enter product id:");
                    id = sc.nextLine();
                    System.out.println("Enter product name:");
                    name = sc.nextLine();
                    System.out.println("Enter product quantity:");
                    quant = sc.nextInt();
                    System.out.println("Enter product price:");
                    price = sc.nextDouble();
                    sc.nextLine(); // Consume the newline character
                    ims.addProduct(new Product(id, name, quant, price));
                    break;
                case 2:
                    System.out.println("Enter the product id you want to update:");
                    id = sc.nextLine();
                    if (ims.inventory.containsKey(id)) {
                        System.out.println("Enter new product name:");
                        name = sc.nextLine();
                        System.out.println("Enter new product quantity:");
                        quant = sc.nextInt();
                        System.out.println("Enter new product price:");
                        price = sc.nextDouble();
                        sc.nextLine(); // Consume the newline character
                        ims.updateProduct(id, name, quant, price);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter product id:");
                    id = sc.nextLine();
                    ims.deleteProduct(id);
                    break;
                case 4:
                    ims.displayInventory();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}


/*
 Analysis
Time Complexity Analysis:

Add Product:
The addProduct method involves adding a product to the HashMap.
Time Complexity: O(1) on average because HashMap provides constant time for insertion.

Update Product:
The updateProduct method involves checking if the product exists and then updating it.
Time Complexity: O(1) on average for the same reason as above.

Delete Product:
The deleteProduct method involves removing a product from the HashMap.
Time Complexity: O(1) on average, as removal also has constant time complexity in HashMap.
*/
