package christmas.view;

import christmas.domain.DateCalculator;
import christmas.domain.Event;
import christmas.domain.Order;
import christmas.menu.MenuList;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    Order order;
    Event event;
    DateCalculator dateCalculator;
    DecimalFormat decimalFormat;
    private Map<String, Integer> orderedItems;
    private int amount;
    private int totalDiscount;
    private int giftDiscount;
    private int date;

    public OutputView(Order order) {
        event = new Event();
        dateCalculator = new DateCalculator();
        decimalFormat = new DecimalFormat("###,###");
        this.order = order;
        this.orderedItems = order.getOrderedItems();
        this.amount = order.getAmount();
    }

    public void printMenu(int date) {
        this.date = date;
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println("(총 주문 금액 10,000원 이상부터 이벤트가 적용됩니다.)");
        details();
        giftDiscount = gift(amount());
        totalDiscount = saleList();
        totalDiscount();
        afterDiscount();
        printBadge();
    }

    public void details() {
        System.out.println();
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> item : orderedItems.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue() + "개");
        }
    }

    public int amount() {

        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(decimalFormat.format(amount) + "원");
        return amount;
    }

    public int gift(int amount) {
        System.out.println();
        System.out.println("<증정 메뉴>");
        if (amount >= Event.GIFTPRICE) {
            System.out.println("샴페인 1개");
            return MenuList.B3.getPrice();
        }
        System.out.println("없음");
        return 0;
    }

    public int saleList() {
        System.out.println();
        System.out.println("<혜택 내역>");
        int discount = 0;
        if (amount >= Event.MINAMOUNT) {
            discount = repeatSaleList(event.xmasSale(date), "크리스마스 디데이 할인: -");
            String day = dateCalculator.findDay(date);
            String weekSaleMessage = "휴일 할인: -";
            if (!day.equals("금") && !day.equals("토")) weekSaleMessage = "평일 할인: -";
            discount += repeatSaleList(event.whichDay(weekSaleMessage, orderedItems), weekSaleMessage);
            discount += repeatSaleList(event.specialSale(date), "특별 할인: -");
            repeatSaleList(giftDiscount, "증정 이벤트: -");
        }
        if (discount == 0) System.out.println("없음");
        return discount;
    }

    public int repeatSaleList(int discount, String message) {
        if (discount > 0)
            System.out.println(message + decimalFormat.format(discount) + "원");
        return discount;
    }

    public void totalDiscount() {
        System.out.println();
        System.out.println("총혜택 금액");
        if (totalDiscount == 0) {
            System.out.println("0원");
            return;
        }
        System.out.println("-" + decimalFormat.format(totalDiscount + giftDiscount) + "원");
    }

    public void afterDiscount() {
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(decimalFormat.format(amount - totalDiscount) + "원");
    }

    public void printBadge() {
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(event.badge(totalDiscount + giftDiscount));
    }
}
