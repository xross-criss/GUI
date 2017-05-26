package GUI4.cw4;

import static java.lang.Thread.sleep;

public class Author implements Runnable {
    Teksty txtArea;
    private String textToWrite;

    /*Author(String[] t) {
        txtArea = t;
    }*/

    public void run() {

        String[] s = {"Pies", "Kot", "Zebra", "Lew", "Owca", "Słoń", null};
        for (int i = 0; i < s.length; i++) {
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException exc) {
            }
            txtArea.setTextToWrite(s[i]);
        }
    }
}
