package christmas.menu;

public enum Dessert {
    D1(15000, "초코케이크"),
    D2(5000, "아이스크림");

    final private int price;
    final private String name;

    Dessert(int price, String name) {
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
