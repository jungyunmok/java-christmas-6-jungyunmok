package christmas.menu;

public enum Main {
    M1(55000, "티본스테이크"),
    M2(54000, "바비큐립"),
    M3(35000, "해산물파스타"),
    M4(25000, "크리스마스파스타");

    final private int price;
    final private String name;

    Main(int price, String name) {
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
