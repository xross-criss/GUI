package GUI2.cw2;

import java.util.ArrayList;

public class PriceList {

    private static PriceList priceList;
    String nazwa;
    double cena;
    ArrayList<Cena> cennik;

    public PriceList(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.cennik = new ArrayList<>();
    }

    public static PriceList getInstance() {
        return null;
    }


    public void put(String nazwa, double cena) {
        cennik.add(new Cena(nazwa, cena));
    }
}
