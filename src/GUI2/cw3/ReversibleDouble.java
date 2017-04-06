package GUI2.cw3;


public class ReversibleDouble implements Reversible {

    private double value;

    public ReversibleDouble(double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public Reversible reverse() {

        value = 1.0 / value;
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
