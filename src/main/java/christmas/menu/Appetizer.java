package christmas.menu;

public enum Appetizer {
    A1(6000, "양송이수프"),
    A2(5500, "타파스"),
    A3(8000, "시저샐러드");

    final private int price;
    final private String name;

    Appetizer(int price, String name) {
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
