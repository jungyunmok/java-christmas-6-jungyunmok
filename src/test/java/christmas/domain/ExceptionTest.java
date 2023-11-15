package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExceptionTest {
    private Exception exception;

    @BeforeEach
    void setUp() {
        exception = new Exception();
    }

    @DisplayName("양수 문자열 입력시 정상적으로 int 변환한다.")
    @Test
    void 인트_변환_양수_입력() {
        assertThat(exception.checkInt("1", 31)).isEqualTo(1);
    }

    @DisplayName("문자열, 범위 초과, 0, 음수 입력시 IllegalArgumentException 발생.")
    @ValueSource(strings = {"test", "99", "0", "-50"})
    @ParameterizedTest
    void 인트_변환_잘못된_입력(String input) {
        assertThatThrownBy(() -> exception.checkInt(input, 31))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복 메뉴, 잘못된 개수 입력하기")
    @ValueSource(strings = {"타파스-1,타파스-1", "해산물파스타-0,레드와인-1,초코케이크-1", "바비큐립-99"})
    @ParameterizedTest
    void 잘못된_메뉴_입력(String input) {
        assertThatThrownBy(() -> exception.checkOrder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}