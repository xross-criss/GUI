package GUI2.cw2;

public abstract class Flower {

    private int quantity;

    public Flower(int quantity) {
        this.quantity = quantity;
    }

    public abstract String getName();

    public abstract String getColor();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return getName() + ", kolor: " + getColor() + ", ilość " + getQuantity() + ", cena " + PriceList.getInstance().getPrice(getName());
    }

}
