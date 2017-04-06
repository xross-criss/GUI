package GUI2.cw1;

public class ChoryNaDyspepsje extends Pacjent {

    public ChoryNaDyspepsje(String nazwisko) {
        super(nazwisko);
    }

    @Override
    protected String choroba() {
        return "dyspepsja";
    }

    @Override
    protected String leczenie() {
        return "węgiel";
    }

}
