package christmas.domain;

import christmas.menu.MenuList;

import java.util.Map;

public class Event {
    DateCalculator dateCalculator = new DateCalculator();
    public static final int GIFTPRICE = 120000;
    public static final int WEEKSALE = 2023;
    public static final int SPECIALSALE = 1000;

    public int xmasSale(int date) {
        int discount = 0;
        if (date <= 25) {
            discount = 1000 + ((date - 1) * 100);
        }
        return discount;
    }

    public int weekdaySale(int date, Map<String, Integer> order) {
        int discount = 0;
        int count = 0;
        String day = dateCalculator.findDay(date);
        for (MenuList menu : MenuList.values()) {
            if (menu.getType().equals("디저트") && order.containsKey(menu.getName())) {
                count += order.get(menu.getName());
            }
        }
        if (!day.equals("금") && !day.equals("토")) {
            discount = WEEKSALE * count;
        }
        return discount;
    }
}
