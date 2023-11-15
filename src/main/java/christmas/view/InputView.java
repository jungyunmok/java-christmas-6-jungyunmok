package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.DateCalculator;
import christmas.domain.Exception;
import christmas.domain.Order;

public class InputView {
    Exception exception;
    Order order;
    OutputView outputView;

    /**
     * 방문 날짜 입력받기
     *
     * @return 날짜
     */
    public int readDate() {
        exception = new Exception();
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int date = 0;
        while (date < 1) {
            try {
                String input = Console.readLine();
                date = exception.checkInt(input, DateCalculator.MAXDATE);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        return date;
    }

    /**
     * 주문 메뉴, 개수 입력받기
     *
     * @param date 날짜
     */
    public void readOrder(int date) {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        boolean orderCompleted = false;
        while (!orderCompleted) {
            try {
                String input = Console.readLine();
                order = exception.checkOrder(input);
                orderCompleted = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        outputView = new OutputView(order);
        outputView.printMenu(date);
    }
}
