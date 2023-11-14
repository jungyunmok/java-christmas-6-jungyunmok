package christmas.domain;

import java.util.*;

public class Exception {
    Order order = null;

    public int checkInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return number;
    }

    public boolean checkOrder(String input) {
        Map<String, Integer> items = new HashMap<>();
        String[] tempInputs = input.split(",");
        for (String tempItems : tempInputs) {
            String[] tempItem = tempItems.split("-");
            if (items.containsKey(tempItem[0])) {
                return false;
            }
            items.put(tempItem[0], checkInt(tempItem[1]));
        }
        order = new Order(items);
        return true;
    }
}
