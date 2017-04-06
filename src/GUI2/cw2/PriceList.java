package GUI2.cw2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PriceList {

    private static PriceList instance;
    private Map<String, Double> priceMap;

    public PriceList() {
        this.priceMap = new HashMap<>();
    }

    public static PriceList getInstance() {
        if (Objects.isNull(instance)) {
            instance = new PriceList();
        }
        return instance;
    }

    public double getPrice(String name) {
        return priceMap.getOrDefault(name, -1.0);
    }

    public void put(String s, double c) {
        priceMap.put(s, c);
    }

}
