package christmas.domain;

import christmas.menu.MenuList;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Order {
    public static final int MAXCOUNT = 20;
    private int totalCount = 0;
    private int beverageCount = 0;
    private int amount = 0;
    private Map<String, Integer> orderedItems;

    public Order(Map<String, Integer> items) {
        orderedItems = new HashMap<>();
        validate(items);
    }

    public Map<String, Integer> getOrderedItems() {
        return orderedItems;
    }

    private void validate(Map<String, Integer> items) {
        for (MenuList menu : MenuList.values()) {
            for (Map.Entry<String, Integer> item : items.entrySet()) {
                existsMenu(item.getKey(), item.getValue(), menu);
            }
        }
        if (beverageCount > 0 && orderedItems.size() == beverageCount) {
            System.out.println("[ERROR] 음료만 주문 시 주문할 수 없습니다.");
            throw new IllegalArgumentException();
        }
        if (orderedItems.size() != items.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void existsMenu(String key, int value, MenuList menu) {
        if (menu.getName().equals(key)) {
            totalCount += value;
            if (totalCount > MAXCOUNT) {
                System.out.println("[ERROR] 메뉴는 한 번에 최대 20개까지 주문할 수 있습니다.");
                throw new IllegalArgumentException();
            }
            if (menu.getType().equals("음료")) {
                beverageCount++;
            }
            orderedItems.put(key, value);
            amount += menu.getPrice() * value;
        }
    }

    public void details() {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> item : orderedItems.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue() + "개");
        }
        System.out.println();
    }

    public int amount() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(decimalFormat.format(amount) + "원");
        System.out.println();
        return amount;
    }
}
