package GUI4.cw3;

public class Consumer extends Thread {

    public Container container;
    public int size;
    public int count;

    public Consumer(Container container) {
        this.container = container;
        this.count = 0;
        this.size = 0;
    }

    public void run() {
        while (!container.isEnd() || !container.content().isEmpty()) {
            synchronized (container.content()) {
                if (!container.content().isEmpty()) {
                    size += container.content().poll().weight;
                    count++;
                    if (count % 100 == 0) {
                        System.out.println("policzono wage " + count + " towarów");
                    }
                }
            }
        }
        System.out.println(size);
    }
}