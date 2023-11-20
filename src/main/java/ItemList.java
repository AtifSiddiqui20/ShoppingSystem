import java.util.ArrayList;
import java.util.List;
import Products.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemList {
    private final String username;
    private final List<Product> items;

    public ItemList(String username) {
        this.username = username;
        this.items = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Product> getItems() {
        return items;
    }

    public void addItem(Product item) {
        items.add(item);
    }

    public void removeItem(Product item) {
        items.remove(item);
    }
}