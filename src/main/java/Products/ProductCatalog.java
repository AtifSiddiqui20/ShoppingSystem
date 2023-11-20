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


        Product defaultPenguin = productFactory.createOPenguinProduct("Base Ornamental Penguin", 15.00);
        products.add(defaultPenguin);


        Product largePenguin = productFactory.createJOPrenguinProduct("Jumbo Ornamental Penguin", 25.00);
        products.add(largePenguin);

        Product miniPenguin = productFactory.createJOPrenguinProduct("Mini Ornamental Penguin", 5.00);
        products.add(miniPenguin);

        Product hatPenguin = productFactory.createJOPrenguinProduct("Ornamental Penguin with a hat", 1265.00);
        products.add(hatPenguin);



    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}

