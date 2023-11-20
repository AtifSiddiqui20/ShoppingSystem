import Products.ConcreteProduct;
import Products.JumboOrnamentalPenguin;
import java.io.ByteArrayOutputStream;
import Products.Product;
import Products.ProductCatalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = ShoppingCart.getInstance();
        shoppingCart.setCurrentUser("TestUser");
        UserList userList = new UserList();
        ProductCatalog productCatalog = new ProductCatalog();
        List<Product> allProducts = productCatalog.getAllProducts();
        UserAuthentication userAuthentication = new UserAuthentication(userList);
        ItemList itemList = null;
        ShoppingCart shoppingCart = null;
    }

    @Test
    void setCurrentUser() {
        shoppingCart.setCurrentUser("Test user 1");

    }

    void addItem_ShouldAddItemToCart() {
        Product product = new ConcreteProduct("TestProduct", 10.0);
        product.setQuantity(1);
        shoppingCart.addItem("testUser", product);

        List<Product> cartContents = shoppingCart.getCartContents("testUser");
        assertTrue(cartContents.contains(product));
    }

    @Test
    void removeItem_ShouldRemoveItemFromCart() {
        Product product = new ConcreteProduct("TestProduct", 10.0);
        shoppingCart.addItem("testUser", product);

        shoppingCart.removeItem("testUser", 0);

        List<Product> cartContents = shoppingCart.getCartContents("testUser");
        assertFalse(cartContents.contains(product));
    }

    @Test
    void calculateTotalCost_ShouldCalculateCorrectTotal() {
        Product product1 = new JumboOrnamentalPenguin("Product1", 10.0 );
        Product product2 = new ConcreteProduct("Product2", 5.0);
        shoppingCart.addItem("testUser", product1);
        shoppingCart.addItem("testUser", product2);
        product1.setQuantity(1);
        product2.setQuantity(1);
        List<Product> cartContents = shoppingCart.getCartContents("testUser");
        double totalCost = shoppingCart.calculateTotalCost(cartContents);
        assertEquals(15, totalCost);
    }

    @Test
    public void emptyCartTest() {
        Product product1 = new JumboOrnamentalPenguin("Product1", 10.0 );
        Product product2 = new ConcreteProduct("Product2", 5.0);
        shoppingCart.addItem("testUser", product1);
        shoppingCart.addItem("testUser", product2);
        product1.setQuantity(1);
        product2.setQuantity(1);

        shoppingCart.emptyCart("testUser");

        assertTrue(shoppingCart.isEmpty("testUser"));


    }
    @Test
    public void displayProductsTestFull() {
        Product product1 = new JumboOrnamentalPenguin("Product1", 10.0 );
        Product product2 = new ConcreteProduct("Product2", 5.0);
        shoppingCart.addItem("testUser", product1);
        shoppingCart.addItem("testUser", product2);
        product1.setQuantity(1);
        product2.setQuantity(1);
        List<Product> cartContents = shoppingCart.getCartContents("testUser");
        double totalCost = shoppingCart.displayProducts("testUser");
        assertEquals(15, shoppingCart.displayProducts("testUser"));
    }
    public void displayProductsTestEmpty() {

        assertEquals(0, shoppingCart.displayProducts("testUser"));
    }

    @Test
    void displayProducts_ShouldPrintCorrectOutput() {

        Product product1 = new ConcreteProduct("Product1", 10.0);
        Product product2 = new ConcreteProduct("Product2", 5.0);
        shoppingCart.addItem("testUser", product1);
        shoppingCart.addItem("testUser", product2);


        double totalCost = shoppingCart.displayProducts("testUser");
        AssertionFailedError outputStreamCaptor = new AssertionFailedError();
        String printedOutput = outputStreamCaptor.toString().trim();


        assertTrue(printedOutput.contains("Product: Product1, Quantity: 2, Price: $10.0"));
        assertTrue(printedOutput.contains("Product: Product2, Quantity: 3, Price: $5.0"));
        assertTrue(printedOutput.contains("Cart Total(Excluding tax & fees) = $40.0"));
        assertEquals(40.0, totalCost);
    }
    @Test
    void displayProducts_ShouldPrintNoItemsMessage() {

        double totalCost = shoppingCart.displayProducts("testUser");
        AssertionFailedError outputStreamCaptor = new AssertionFailedError();
        String printedOutput = outputStreamCaptor.toString().trim();

        assertTrue(printedOutput.contains("User testUser has no items in the cart."));
        assertEquals(0.0, totalCost);
    }
}
