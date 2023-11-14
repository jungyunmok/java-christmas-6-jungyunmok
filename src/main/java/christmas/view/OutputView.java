package christmas.view;

import christmas.domain.Event;
import christmas.domain.Order;

import java.util.Map;

public class OutputView {
    Order order;
    Event event;
    private Map<String, Integer> orderedItems;

    public OutputView(Order order) {
        this.order = order;
        this.orderedItems = order.getOrderedItems();
    }

    public void printMenu(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        order.details();
        System.out.println();
        order.amount();
    }
}
