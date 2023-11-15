package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // 우테코 12월 이벤트플래너
        InputView inputView = new InputView();
        inputView.readOrder(inputView.readDate());
    }
}