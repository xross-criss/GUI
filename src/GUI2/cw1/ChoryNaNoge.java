package GUI2.cw1;

public class ChoryNaNoge extends Pacjent {

    public ChoryNaNoge(String nazwisko) {
        super(nazwisko);
    }

    @Override
    protected String choroba() {
        return "noga";
    }

    @Override
    protected String leczenie() {
        return "gips";
    }

}
