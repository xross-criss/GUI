package GUI2.cw3;

public class ReversibleString implements Reversible {

    private String string;

    public ReversibleString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public Reversible reverse() {

        string = new StringBuilder(string).reverse().toString();
        return this;
    }

}
