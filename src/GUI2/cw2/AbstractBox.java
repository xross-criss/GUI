package GUI2.cw2;

import java.util.List;

public abstract class AbstractBox {

    private Customer owner;
    private List<Flower> flowerList;

    public AbstractBox(Customer owner, List<Flower> flowerList) {
        this.owner = owner;
        this.flowerList = flowerList;
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public abstract String getName();

    @Override
    public String toString() {
        String s = getName()+" własciciel " + owner.getName();
        if (getFlowerList().size() == 0) {
            s += " -- pusto";
        } else {
            for (Flower flower : getFlowerList()) {
                s += "\n" + flower.toString();
            }
        }
        return s;
    }

    public void addAll(List<Flower> flowerList) {
        this.flowerList.addAll(flowerList);
    }

}
