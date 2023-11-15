package christmas.domain;

import java.util.*;

public class Exception {
    Order order = null;
    Map<String, Integer> items;

    /**
     * String to int 변환
     *
     * @param input int로 바꾸려는 문자열
     * @param range 해당 int의 허용가능한 최대 값
     * @return int로 변환된 값
     */
    public int checkInt(String input, int range) {
        int number;
        try {
            number = Integer.parseInt(input);
            if (range == Order.MAXCOUNT && number > range) {
                System.out.println("[ERROR] 메뉴는 한 번에 최대 20개까지 주문할 수 있습니다.");
                throw new IllegalArgumentException();
            }
            if (number < 1 || number > range) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return number;
    }

    /**
     * 전체 주문 ","로 끊어서 HashMap에 담은 후 order에 넘기기
     *
     * @param input 총 주문내역(메뉴1-개수,메뉴2-개수)
     * @return order
     */
    public Order checkOrder(String input) {
        items = new HashMap<>();
        try {
            String[] items = input.split(",");
            for (String item : items) {
                checkMenu(item);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
        order = new Order(items);
        return order;
    }

    /**
     * 주문 "-"로 끊어서 메뉴, 개수 HashMap에 담기
     *
     * @param item 주문내역(메뉴1-개수)
     */
    public void checkMenu(String item) {
        try {
            String[] tempItem = item.split("-");
            if (items.containsKey(tempItem[0])) {
                throw new IllegalArgumentException();
            }
            items.put(tempItem[0], checkInt(tempItem[1], Order.MAXCOUNT));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
