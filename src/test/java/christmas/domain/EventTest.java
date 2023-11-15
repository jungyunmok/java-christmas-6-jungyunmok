package christmas.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {
    private Event event;

    @BeforeEach
    void setUp() {
        event = new Event();
    }

    @DisplayName("1일 1,000원으로 시작해 매일 100월씩 증가하여 25일에 3,400원 할인")
    @Test
    void 크리스마스_디데이_할인() {
        assertThat(event.xmasSale(25)).isEqualTo(3400);
    }

    @DisplayName("평일 디저트 1개당 2,023원 할인")
    @Test
    void 평일_디저트_할인() {
        Map<String, Integer> input = Map.of(
                "초코케이크", 10,
                "제로콜라", 2,
                "타파스", 2,
                "바비큐립", 5
        );
        assertThat(event.weekdaySale(input)).isEqualTo(20230);
    }

    @DisplayName("휴일 메인 1개당 2,023원 할인")
    @Test
    void 휴일_메인_할인() {
        Map<String, Integer> input = Map.of(
                "초코케이크", 10,
                "제로콜라", 2,
                "타파스", 2,
                "바비큐립", 5
        );
        assertThat(event.weekendSale(input)).isEqualTo(10115);
    }

    @DisplayName("특별 할인 1000원 적용하기.")
    @ValueSource(ints = {3, 10, 17, 24, 25, 31})
    @ParameterizedTest
    void 특별_할인_적용(int input) {
        assertThat(event.specialSale(input)).isEqualTo(1000);
    }

    @DisplayName("2만원 이상 산타 이벤트배지 부여")
    @ValueSource(ints = {20000, 50000, 100000})
    @ParameterizedTest
    void 산타_이벤트_배지(int input) {
        assertThat(event.badge(input)).isEqualTo("산타");
    }

    @DisplayName("1만원 이상 트리 이벤트배지 부여")
    @ValueSource(ints = {10000, 15000, 19999})
    @ParameterizedTest
    void 트리_이벤트_배지(int input) {
        assertThat(event.badge(input)).isEqualTo("트리");
    }

    @DisplayName("5천원 이상 별 이벤트배지 부여")
    @ValueSource(ints = {5000, 7500, 9999})
    @ParameterizedTest
    void 별_이벤트_배지(int input) {
        assertThat(event.badge(input)).isEqualTo("별");
    }

    @DisplayName("5천원 미만 이벤트배지 없음")
    @ValueSource(ints = {4999, 1000, 0})
    @ParameterizedTest
    void 이벤트_배지_없음(int input) {
        assertThat(event.badge(input)).isEqualTo("없음");
    }
}