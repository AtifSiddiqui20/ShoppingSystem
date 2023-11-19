import Products.Product;

import java.util.*;
public class ShoppingCartBuilder {
    private String currentUser;
    private final List<Product> cartContents;

    public ShoppingCartBuilder() {
        this.cartContents = new ArrayList<>();
    }

    public ShoppingCartBuilder setCurrentUser(String username) {
        this.currentUser = username;
        return this;
    }

    public ShoppingCartBuilder addItem(Product product) {
        cartContents.add(product);
        return this;
    }

    public ShoppingCart build(User user) {
        if (user.isLoggedIn()) {
            ShoppingCart shoppingCart = ShoppingCart.getInstance();
            shoppingCart.setCurrentUser(currentUser);
            for (Product product : cartContents) {
                //shoppingCart.addItem(product);
            }
            return shoppingCart;
        } else {
            System.out.println("User " + currentUser + " is not logged in. Cannot build the cart.");
            return null;
        }
    }
}
