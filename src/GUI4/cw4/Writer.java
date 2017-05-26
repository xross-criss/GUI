package GUI4.cw4;

public class Writer implements Runnable {
    Teksty txtArea;

    Writer(Author t) {
        txtArea = t;
    }

    public void run() {
        String txt = txtArea.getTextToWrite();
        while (txt != null) {
            System.out.println(txt);
            txt = txtArea.getTextToWrite();
        }
    }

}
