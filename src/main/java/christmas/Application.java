package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.readOrder(inputView.readDate());
    }
}