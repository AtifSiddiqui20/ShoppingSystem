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
    }

    public void removeItem(String username, Product product) {
        cartContents
                .computeIfPresent(username, (k, v) -> {
                    v.remove(product);
                    return v;
                });
    }

    public void displayProducts(String username) {
        List<Product> products = cartContents.get(username);
        if (products != null) {
            System.out.println(products);
        } else {
            System.out.println("User " + username + " has no items in the cart.");
        }
    }

    public void emptyCart(String username) {
        cartContents.remove(username);
    }
}
// eager
