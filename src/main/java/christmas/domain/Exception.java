package christmas.domain;

import java.util.*;

public class Exception {
    Order order = null;
    Map<String, Integer> items;

    public int checkInt(String input, int range) {
        int number;
        try {
            number = Integer.parseInt(input);
            if (number < 1 || number > range) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return number;
    }

    public boolean checkOrder(String input) {
        items = new HashMap<>();
        try {
            String[] items = input.split(",");
            for (String item : items) {
                checkMenu(item);
            }
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException(e);
        }
        return true;
    }

    public void checkMenu(String item) {
        try {
            String[] tempItem = item.split("-");
            if (items.containsKey(tempItem[0])) {
                throw new IllegalArgumentException();
            }
            items.put(tempItem[0], checkInt(tempItem[1], Order.MAXCOUNT));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
        order = new Order(items);
    }
}
