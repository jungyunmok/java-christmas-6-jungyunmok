package christmas.domain;

import java.util.ArrayList;
import java.util.List;

public class DateCalculator {
    public static final int MAXDATE = 31;
    private final String STARTDAY = "금";
    private final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
    private List<String> week;

    public DateCalculator() {
        week = new ArrayList<>();
        int startIndex = findIndex();
        while (week.size() < 7) {
            week.add(DAYS[startIndex]);
            startIndex++;
            if (startIndex == DAYS.length) {
                startIndex = 0;
            }
        }
    }

    /**
     * 시작 요일을 찾기위해 시작 인텍스 구하기
     *
     * @return startIndex 시작인덱스
     */
    private int findIndex() {
        int startIndex = 0;
        for (int i = 0; i < DAYS.length; i++) {
            if (DAYS[i].equals(STARTDAY)) {
                startIndex = i;
                break;
            }
        }
        return startIndex;
    }

    /**
     * 일자에 해당하는 요일 반환
     *
     * @param date
     * @return 해당 요일
     */
    public String findDay(int date) {
        return week.get(date % 7 - 1);
    }
}