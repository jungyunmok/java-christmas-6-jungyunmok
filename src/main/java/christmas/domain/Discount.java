package christmas.domain;

import java.util.Map;

public class Discount {
    private Map<String, Integer> saleDetails;

    public void setSalesDetails(Map<String, Integer> salesDetails) {
        this.saleDetails = salesDetails;
    }

    public Map<String, Integer> getSalesDetails() {
        return saleDetails;
    }
}
