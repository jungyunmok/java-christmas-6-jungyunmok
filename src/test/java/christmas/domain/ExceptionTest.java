package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        assertThat(exception.checkInt("1")).isEqualTo(1);
    }

    @DisplayName("숫자가 아닌 문자열 입력시 IllegalArgumentException 발생.")
    @Test
    void 인트_변환_문자_입력() {
         assertThatThrownBy(() -> exception.checkInt("test"))
            .isInstanceOf(IllegalArgumentException.class);
    }


}