package christmas.menu;

public enum Beverage {
    B1(3000, "제로콜라"),
    B2(60000, "레드와인"),
    B3(25000, "샴페인");

    final private int price;
    final private String name;

    Beverage(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
