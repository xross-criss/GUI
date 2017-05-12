package GUI4.cw3;

public class Item {
    public int id;
    public int weight;

    public Item(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ITEM(" + id + "," + weight + ")";
    }
}