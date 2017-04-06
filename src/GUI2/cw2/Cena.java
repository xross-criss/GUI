package GUI2.cw2;

public class Cena extends PriceList {
    String nazwa;
    double cena;

    public Cena(String nazwa, double cena) {
        super(nazwa, cena);
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
