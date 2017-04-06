package GUI2.cw2;

public class Flower {
    String nazwaKwiatka;
    String kolor;

    public Flower(String nazwaKwiatka, String kolor) {
        this.nazwaKwiatka = nazwaKwiatka;
        this.kolor = kolor;
    }

    public String getNazwaKwiatka() {
        return nazwaKwiatka;
    }

    public void setNazwaKwiatka(String nazwaKwiatka) {
        this.nazwaKwiatka = nazwaKwiatka;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }
}
