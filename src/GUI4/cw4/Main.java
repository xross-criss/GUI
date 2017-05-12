package GUI4.cw4;

public class Main {

    public static void main(String[] args) {
        Teksty t = new Teksty();
        Thread t1 = new Author(t);
        Thread t2 = new Writer(t);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (Exception exc) {
        }
        t2.start();
    }

}
