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
        try {
            String[] items = input.split(",");
            for (String item : items) {
                checkMenu(item);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException(e);
        }
        return true;
    }

    public void checkMenu(String item) {
        Map<String, Integer> items = new HashMap<>();
        try {
            String[] tempItem = item.split("-");
            if (items.containsKey(tempItem[0])) {
                throw new IllegalArgumentException();
            }
            items.put(tempItem[0], checkInt(tempItem[1]));
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            throw new IllegalArgumentException(e);
        }
        order = new Order(items);
    }
}
