package Products;

public class ProductFactory {
    public Product createOPenguinProduct(String name, double price) {
        return new OrnamentalPenguin(name, price);
    }

    public Product createJOPrenguinProduct(String name, double price) {
        return new JumboOrnamentalPenguin(name, price);
    }


}

