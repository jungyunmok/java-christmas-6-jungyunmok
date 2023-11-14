package christmas.view;

import christmas.domain.Event;
import christmas.domain.Order;

import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    Order order;
    Event event;
    private Map<String, Integer> orderedItems;
    int amount;

    public OutputView(Order order) {
        this.order = order;
        this.orderedItems = order.getOrderedItems();
        this.amount = order.getAmount();
    }

    public void printMenu(int date) {
        event = new Event();
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        details();
        int offPrice = gift(amount());
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

    public int gift(int amount) {
        if (amount >= Event.GIFTPRICE) {
            System.out.println("샴페인 1개");
            return Event.GIFTPRICE;
        }
        System.out.println("없음");
        return 0;
    }
}
