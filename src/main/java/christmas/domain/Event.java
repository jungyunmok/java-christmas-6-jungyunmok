package christmas.domain;

import christmas.menu.MenuList;

import java.util.Map;

public class Event {
    DateCalculator dateCalculator;
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

    public int whichDay(int date, Map<String, Integer> order) {
        dateCalculator = new DateCalculator();
        int discount = 0;
        String day = dateCalculator.findDay(date);
        if (!day.equals("금") && !day.equals("토")) {
            discount = weekdaySale(order);
            return discount;
        }
        discount = weekendSale(order);
        return discount;
    }

    public int weekdaySale(Map<String, Integer> order) {
        int discount = 0;
        int count = 0;
        for (MenuList menu : MenuList.values()) {
            if (menu.getType().equals("디저트") && order.containsKey(menu.getName())) {
                count += order.get(menu.getName());
            }
        }
        return discount;
    }
}
