package christmas.domain;

import christmas.menu.MenuList;

import java.util.Map;

public class Order {
    public static final int MAXCOUNT = 20;
    private int totalCount;
    private int beverageCount;
    private Map<String, Integer> orderedItems;

    public Order(Map<String, Integer> items) {
        validate(items);
    }

    public Map<String, Integer> getOrderedItems() {
        return orderedItems;
    }

    private void validate(Map<String, Integer> items) {
        totalCount = 0;
        beverageCount = 0;
        for (MenuList menu : MenuList.values()) {
            for (Map.Entry<String, Integer> item : items.entrySet()) {
                existsMenu(item.getKey(), item.getValue(), menu);
            }
        }
        if (orderedItems.size() == beverageCount)
            throwException("[ERROR] 음료만 주문 시 주문할 수 없습니다.");
        if (orderedItems.size() != items.size())
            throwException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private void existsMenu(String key, int value, MenuList menu) {
        if (menu.getName().equals(key)) {
            totalCount += value;
            if (menu.getType().equals("음료")) {
                beverageCount++;
            }
            if (totalCount > MAXCOUNT) {
                throwException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
            }
            orderedItems.put(key, value);
        }
    }

    private void throwException(String message) {
        System.out.println(message);
        throw new IllegalArgumentException();
    }
}
