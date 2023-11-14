package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.DateCalculator;
import christmas.domain.Exception;

public class InputView {
    Exception exception = new Exception();

    public int readDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        int date = 0;
        while (date == 0) {
            date = exception.checkInt(input, DateCalculator.MAXDATE);
            if (date > DateCalculator.MAXDATE) {
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
                date = 0;
            }
        }
        return date;
    }

    public void readOrder() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
    }
}
