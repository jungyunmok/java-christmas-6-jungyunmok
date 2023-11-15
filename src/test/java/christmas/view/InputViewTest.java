package christmas.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("올바른 날짜 입력과 반환")
    @Test
    void 올바른_날짜_입력() {
        assertSimpleTest(() -> {
            InputStream in = new ByteArrayInputStream("30".getBytes());
            System.setIn(in);
            assertThat(inputView.readDate()).isEqualTo(30);
        });
    }
}