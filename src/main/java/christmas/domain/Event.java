package christmas.domain;

public class Event {
    public int xmasSale(int date) {
        int discount = 0;
        if(date <= 25)
            discount = 1000 + ((date-1)*100);
        return discount;
    }
}
