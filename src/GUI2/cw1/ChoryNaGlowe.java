package GUI2.cw1;

public class ChoryNaGlowe extends Pacjent {

    public ChoryNaGlowe(String nazwisko) {
        super(nazwisko);
    }

    @Override
    protected String choroba() {
        return "głowa";
    }

    @Override
    protected String leczenie() {
        return "aspiryna";
    }

}
