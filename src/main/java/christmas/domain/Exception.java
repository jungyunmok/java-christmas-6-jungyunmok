package christmas.domain;

public class Exception {
    public int checkInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        return number;
    }
}
