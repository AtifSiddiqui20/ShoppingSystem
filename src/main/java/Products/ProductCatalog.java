package Products;

import java.util.*;
public class ProductCatalog {
    private final List<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
        initializeCatalog();
    }

    private void initializeCatalog() {
        ProductFactory productFactory = new ProductFactory();

        // Create electronics product
        Product defaultPenguin = productFactory.createOPenguinProduct("Base Ornamental Penguin", 15.00);
        products.add(defaultPenguin);

        // Create clothing product
        Product largePenguin = productFactory.createJOPrenguinProduct("Jumbo Ornamental Penguin", 25.00);
        products.add(largePenguin);

        // Add other products as needed
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}

