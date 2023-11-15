package christmas.domain;

import christmas.menu.MenuList;

import java.util.Map;

public class Event {
    public static final int MINAMOUNT = 10000;
    public static final int GIFTPRICE = 120000;
    public static final int WEEKSALE = 2023;
    public static final int SPECIALSALE = 1000;
    public static final int STAR = 5000;
    public static final int TREE = 10000;
    public static final int SANTA = 20000;

    /**
     * 크리스마스 디데이 할인(12.1~12.25) - 1,000원으로 시작해 매일 100원씩 할인금액 증가
     *
     * @param date
     * @return discount 할인 금액
     */
    public int xmasSale(int date) {
        int discount = 0;
        if (date <= 25) {
            discount = 1000 + ((date - 1) * 100);
        }
        return discount;
    }

    /**
     * 평일, 휴일 판단 후 메서드 선택
     *
     * @param weekSaleMessage 평일 할인 or 휴일 할인
     * @param order           주문 내역
     * @return discount 할인 금액
     */
    public int whichDay(String weekSaleMessage, Map<String, Integer> order) {
        int discount = 0;
        if (weekSaleMessage.contains("평일")) {
            discount = weekdaySale(order);
            return discount;
        }
        discount = weekendSale(order);
        return discount;
    }

    /**
     * 평일(일~목) 할인 - 디저트 메뉴 1개당 2,023원 할인
     *
     * @param order 주문 내역
     * @return discount 할인 금액
     */
    public int weekdaySale(Map<String, Integer> order) {
        int count = 0;
        for (MenuList menu : MenuList.values()) {
            if (menu.getType().equals("디저트") && order.containsKey(menu.getName())) {
                count += order.get(menu.getName());
            }
        }
        return WEEKSALE * count;
    }

    /**
     * 휴일(금,토) 할인 - 메인 메뉴 1개당 2,023원 할인
     *
     * @param order 주문 내역
     * @return discount 할인 금액
     */
    public int weekendSale(Map<String, Integer> order) {
        int count = 0;
        for (MenuList menu : MenuList.values()) {
            if (menu.getType().equals("메인") && order.containsKey(menu.getName())) {
                count += order.get(menu.getName());
            }
        }
        return WEEKSALE * count;
    }

    /**
     * 특별(별) 할인(3, 10, 17, 24, 25, 31일) - 총 주문금액에서 1,000원 할인
     *
     * @param date
     * @return discount 할인 금액
     */
    public int specialSale(int date) {
        int discount = 0;
        if (date % 7 == 3 || date == 25) {
            discount = SPECIALSALE;
        }
        return discount;
    }

    /**
     * 해당하는 이벤트 배지 반환
     *
     * @param totalDiscount 총 혜택 금액
     * @return 이벤트배지
     */
    public String badge(int totalDiscount) {
        if (totalDiscount >= SANTA) {
            return "산타";
        }
        if (totalDiscount >= TREE) {
            return "트리";
        }
        if (totalDiscount >= STAR) {
            return "별";
        }
        return "없음";
    }
}
