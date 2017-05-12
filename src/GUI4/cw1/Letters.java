package GUI4.cw1;

import java.util.ArrayList;

public class Letters extends Thread {
    ArrayList<Thread> threads = new ArrayList<>();

    public Letters(String s) {
        for (int i = 0; i < s.length(); i++) {
            String letter = s.substring(i, i + 1);
            threads.add(new Thread("Thread " + letter) {
                public void run() {
                    while (true) {
                        try {
                            System.out.print(letter);
                            Thread.sleep(1000);
                        } catch (InterruptedException ie) {
                            break;
                        }
                    }
                }
            });
        }
    }

    public ArrayList<Thread> getThreads() {
        return threads;
    }

    public void run() {
        while (true) {
            try {
                System.out.print(this.getName());
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("Wątek przerwany");
            }
        }

    }
}