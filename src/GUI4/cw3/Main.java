package GUI4.cw3;

public class Main {

    public static void main ( String[] args ) {
        Container c = new Container ();
        Producer p1 = new Producer ( c );
        Consumer c1 = new Consumer ( c );
        p1.start ();
        c1.start ();
    }
}