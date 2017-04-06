package GUI2.cw2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Customer {

    private String name;
    private double cash;
    private List<Flower> flowerList;

    public Customer(String name, double cash) {
        this.name = name;
        this.cash = cash;
        this.flowerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void get(Flower flower) {
        flowerList.add(flower);
    }

    public ShoppingCart getShoppingCart() {
        return new ShoppingCart(this);
    }

    public void pay() {
        PriceList priceList = PriceList.getInstance();
        ListIterator<Flower> iterator = flowerList.listIterator();
        while (iterator.hasNext()) {
            Flower flower = iterator.next();
            double price = priceList.getPrice(flower.getName());
            if (price <= 0) {
                iterator.remove();
            } else {
                double wholePrice = flower.getQuantity() * price;
                if (cash >= wholePrice) {
                    cash -= wholePrice;
                } else {
                    iterator.remove();
                }
            }
        }
    }

    public void pack(Box box) {
        box.addAll(flowerList);
        flowerList.clear();
    }

}
