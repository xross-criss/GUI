package GUI2.cw1;

public abstract class Pacjent {

    private String nazwisko;

    public Pacjent(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    protected String nazwisko() {
        return nazwisko;
    }

    protected abstract String choroba();

    protected abstract String leczenie();

}
