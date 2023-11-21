package Products;

public class ProductFactory {
    public Product createOPenguinProduct(String name, double price) {
        return new OrnamentalPenguin(name, price);
    }

    public Product createJOPrenguinProduct(String name, double price) {
        return new JumboOrnamentalPenguin(name, price);
    }
    public Product createMiPrenguinProduct(String name, double price) {
        return new MiniOrnamentalPenguin(name, price);
    }
    public Product createHPrenguinProduct(String name, double price) {
        return new OrnamentalPenguinWithaHat(name, price);
    }


}

