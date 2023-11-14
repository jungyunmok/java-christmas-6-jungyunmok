package christmas.domain;

import java.util.List;
import java.util.Map;

public class Order {
    public static final int MAXCOUNT = 20;
    private Map<String, Integer> items;

    public Order(Map<String, Integer> items) {
        this.items = items;
    }

    public Map<String, Integer> getItems() {
        return items;
    }
}
