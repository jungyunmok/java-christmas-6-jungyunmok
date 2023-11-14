package christmas.menu;

public enum MenuList {
    A1("애피타이저", "양송이수프", 6000),
    A2("애피타이저", "타파스", 5500),
    A3("애피타이저", "시저샐러드", 8000),
    M1("메인", "티본스테이크", 55000),
    M2("메인", "바비큐립", 54000),
    M3("메인", "해산물파스타", 35000),
    M4("메인", "크리스마스파스타", 25000),
    D1("디저트", "초코케이크", 15000),
    D2("디저트", "아이스크림", 5000),
    B1("음료", "제로콜라", 3000),
    B2("음료", "레드와인", 60000),
    B3("음료", "샴페인", 25000);

    final private String type;
    final private String name;
    final private int price;

    MenuList(String type, String name, int price) {
        this.type = type;
        this.price = price;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
