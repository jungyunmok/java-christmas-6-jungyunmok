package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    private Order order;

    @DisplayName("존재하지 않는 메뉴 주문하기")
    @Test
    void 존재하지_않는_메뉴_주문() {
        Map<String, Integer> input = Map.of(
                "양송이볶음", 1,
                "바비큐립", 2
        );
        assertThatThrownBy(() -> order = new Order(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("20개 초과하는 메뉴 주문하기")
    @Test
    void 개수_초과_주문() {
        Map<String, Integer> input = Map.of(
                "초코케이크", 20,
                "바비큐립", 2
        );
        assertThatThrownBy(() -> order = new Order(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음료수만 주문하기")
    @Test
    void 음료수_주문() {
        Map<String, Integer> input = Map.of(
                "제로콜라", 10,
                "레드와인", 5,
                "샴페인", 5
        );
        assertThatThrownBy(() -> order = new Order(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}