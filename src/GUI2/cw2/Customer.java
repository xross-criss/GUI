package GUI2.cw2;

public class Customer extends ShoppingCart {
    String imie;
    double portfel;
    private ShoppingCart shoppingCart;

    public Customer(String imie, double portfel) {
        this.imie = imie;
        this.portfel = portfel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public double getPortfel() {
        return portfel;
    }

    public void setPortfel(double portfel) {
        this.portfel = portfel;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void pay() {

    }

    public void pack(Box pudelkoJanka) {

    }

    public String getCash() {
        return String.valueOf(portfel);
    }
}
