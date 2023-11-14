package christmas.domain;

public class Exception {
    public int checkInt(String input , String errorMsg) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(errorMsg);
            throw new IllegalArgumentException(e);
        }
        return number;
    }
}
