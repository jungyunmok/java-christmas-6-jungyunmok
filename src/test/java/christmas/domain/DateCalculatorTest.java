package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DateCalculatorTest {
    private DateCalculator dateCalculator;

    @BeforeEach
    void setUp() {
        dateCalculator = new DateCalculator();
    }

    @DisplayName("일자 입력시 해당하는 날짜 반환 - 금요일")
    @ValueSource(ints = {1, 8, 15, 22, 29})
    @ParameterizedTest
    void 금요일_반환(int input) {
        assertThat(dateCalculator.findDay(input)).isEqualTo("금");
    }

    @DisplayName("일자 입력시 해당하는 날짜 반환 - 월요일")
    @ValueSource(ints = {4, 11, 18, 25})
    @ParameterizedTest
    void 월요일_반환(int input) {
        assertThat(dateCalculator.findDay(input)).isEqualTo("월");
    }
}