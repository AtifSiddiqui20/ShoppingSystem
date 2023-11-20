import Products.Product;

import java.util.*;
public class ShoppingCart {
    private static final ShoppingCart instance = new ShoppingCart();
    private final Map<String, List<Product>> cartContents;
    private String currentUser;

    private ShoppingCart() {
        this.cartContents = new HashMap<>();
        this.currentUser = null;
    }
    public void setCurrentUser(String username) {
        this.currentUser = username;
    }

    public void displayCart(List<Product> cartContents) {
        System.out.println("Shopping Cart:");

        for (Product product : cartContents) {
            System.out.println("Product: " + product.getName() + ", Quantity: " + product.getQuantity() + ", Price: $" + product.getPrice());
        }

        double totalCost = calculateTotalCost(cartContents);
        System.out.println("Total Cost: $" + totalCost);
        Logger.log("Cart was displayed by user.");
    }

    public static ShoppingCart getInstance() {
        return instance;
    }


    public boolean isEmpty(String username) {
        List<Product> productList = cartContents.get(username);
        return productList == null || productList.isEmpty();
    }

    public void addItem(String username, Product product) {
        cartContents
                .computeIfAbsent(username, k -> new ArrayList<>())
                .add(product);
        Logger.log("Item was added to " + username + "'s itemList");
    }

    public double calculateTotalCost(List<Product> cartContents) {
        double totalCost = 0.0;

        for (Product product : cartContents) {
            totalCost += product.getPrice() * product.getQuantity();
        }

        return totalCost;
    }

    public void removeItem(String username, int itemIndex) {
        cartContents.computeIfPresent(username, (k, v) -> {
            if (itemIndex >= 0 && itemIndex < v.size()) {
                v.remove(itemIndex);
                System.out.println("Item removed successfully");
                Logger.log("Item was removed from " + username + "'s itemList");
            }
            return v;
        });
    }

    public double displayProducts(String username) {
        List<Product> products = cartContents.get(username);
        if (products != null) {
            int i = 1;
            for (Product product: products) {
                System.out.println("--------------------------------");
                System.out.printf("(%d) %s\n Price/piece = $%.2f\n Amount = %d\n Item Total = $%.2f\n",i, product.getName(), product.getPrice(), product.getQuantity(), product.getPrice()*product.getQuantity());
                System.out.println("--------------------------------");
                i++;
            }
            System.out.println("--------------------------------");
            System.out.printf("\nCart Total(Excluding tax & fees) = $%.2f\n",calculateTotalCost(products));
            System.out.println("--------------------------------");
            Logger.log(username + "'s cart was displayed");
            return calculateTotalCost(products);
        } else {
            System.out.println("User " + username + " has no items in the cart.");
        }
        return 0;
    }

    public void emptyCart(String username) {
        cartContents.remove(username);
        Logger.log(username + "'s cart was emptied");
    }
}
// eager
