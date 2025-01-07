package amazontech;
import java.util.*;

public class Main {
    private static HashMap<Integer, Product> productMap;

    public static void main(String[] args) {
        productMap = DataManager.mockProducts();
        startOrder();
    }

    public static void startOrder() {
        Scanner scanner = new Scanner(System.in);
        Buyer buyer = new Buyer();

        System.out.println("Enter your name:");
        buyer.setName(scanner.nextLine());

        while (true) {
            System.out.println("\nWhich product would you like to purchase?");
            productMap.forEach((key, product) ->
                    System.out.println(key + ". " + product.toString()));
            System.out.println("-1. Finish order");

            int choice = scanner.nextInt();
            if (choice == -1) break;

            if (productMap.containsKey(choice)) {
                Product selectedProduct = productMap.get(choice);
                Product productCopy;

                if (selectedProduct instanceof TV) {
                    productCopy = new TV((TV) selectedProduct);
                } else if (selectedProduct instanceof Smartphone) {
                    productCopy = new Smartphone((Smartphone) selectedProduct);
                } else if (selectedProduct instanceof Laptop) {
                    productCopy = new Laptop((Laptop) selectedProduct);
                } else if (selectedProduct instanceof PC) {
                    productCopy = new PC((PC) selectedProduct);
                } else {
                    productCopy = selectedProduct; // Shouldn't happen
                }

                buyer.addProduct(productCopy);
                System.out.println("Product added to cart!");
            }
        }

        // Apply coupon if applicable
        System.out.println("Enter coupon code (or press Enter to skip):");
        scanner.nextLine(); // Clear buffer
        String coupon = scanner.nextLine();

        if (coupon.equals("HOLIDAY30")) {
            Set<String> processedProducts = new HashSet<>();

            for (Product product : buyer.getProducts()) {
                String productType = product.getClass().getSimpleName();
                if (!processedProducts.contains(productType)) {
                    product.setPrice(product.getPrice() * 0.7); // Apply 30% discount
                    processedProducts.add(productType);
                }
            }
        }

        // Print receipt
        printReceipt(buyer);
    }

    private static void printReceipt(Buyer buyer) {
        System.out.println("\n=== Receipt ===");
        System.out.println("Customer: " + buyer.getName());
        System.out.println("\nPurchased items:");

        for (Product product : buyer.getProducts()) {
            System.out.println("\n" + product.toString());
            product.warranty();
            if (product instanceof Portable) {
                ((Portable) product).weight();
            }
        }

        System.out.println("\nTotal amount: $" + Buyer.calculateTotal(buyer.getProducts()));
    }
}