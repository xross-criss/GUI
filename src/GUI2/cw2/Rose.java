package GUI2.cw2;

public class Rose extends Flower {

    public Rose(int quantity) {
        super(quantity);
    }

    @Override
    public String getName() {
        return "róża";
    }

    @Override
    public String getColor() {
        return "czerwony";
    }

}
