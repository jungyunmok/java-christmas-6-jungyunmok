package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class DateCalculator {
    private final ArrayList<String> WEEK = new ArrayList<>(List.of("금", "토", "일", "월", "화", "수", "목"));

    public String findDay(int date) {
        return WEEK.get(date % 7 - 1);
    }
}
