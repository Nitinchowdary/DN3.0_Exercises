import java.util.*;

class CustomerOrder {
    private int orderId;
    private String customerName;
    private double totalAmount;

    public CustomerOrder(int id, String name, double amount) {
        this.orderId = id;
        this.customerName = name;
        this.totalAmount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

class BubbleSort {
    public static void bubbleSort(CustomerOrder[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalAmount() > orders[j + 1].getTotalAmount()) {
                    CustomerOrder temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort {
    public static void quickSort(CustomerOrder[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(CustomerOrder[] orders, int low, int high) {
        double pivot = orders[high].getTotalAmount();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalAmount() <= pivot) {
                i++;
                CustomerOrder temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        CustomerOrder temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

public class sortcustomerorder {
    public static void main(String[] args) {
        CustomerOrder[] orders = {
                new CustomerOrder(3, "Rajesh", 450.00),
                new CustomerOrder(1, "Sai", 300.50),
                new CustomerOrder(4, "Bhanu", 200.00),
                new CustomerOrder(2, "Nitin", 150.75),
        };

        System.out.println("Original Orders:");
        for (CustomerOrder order : orders) {
            System.out.println(order);
        }

        BubbleSort.bubbleSort(orders);
        System.out.println("\nSorted Orders (Bubble Sort):");
        System.out.println(Arrays.toString(orders));

        QuickSort.quickSort(orders, 0, orders.length - 1);
        System.out.println("\nSorted Orders (Quick Sort):");
        System.out.println(Arrays.toString(orders));
    }
}
