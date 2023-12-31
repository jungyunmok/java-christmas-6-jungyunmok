package christmas.domain;

import christmas.menu.MenuList;

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

    public int getAmount() {
        return amount;
    }

    /**
     * 넘겨받은 메뉴 확인 후 음료만 주문하거나 메뉴가 존재하지 않으면 exception 발생
     *
     * @param items 주문 내역
     */
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

    /**
     * 메뉴가 존재하는지, 총 몇 개 주문하는지 확인
     *
     * @param key   HashMap 키값
     * @param value HashMap 밸류값
     * @param menu  존재하는 메뉴
     */
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
}
