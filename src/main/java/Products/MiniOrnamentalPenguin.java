package Products;

public class MiniOrnamentalPenguin implements Product {
    private final String name;
    private final double price;
    private int quantity;

    public MiniOrnamentalPenguin(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }


    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return
                " name='" + name +
                        " \nprice/piece=" + price +
                        " \nquantity= " + quantity +
                        "\nprice=" + price * quantity;
    }
}
