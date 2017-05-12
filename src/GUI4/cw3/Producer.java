package GUI4.cw3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Producer extends Thread {

    public Container container;
    public int count;

    public Producer(Container container) {
        this.container = container;
        this.count = 0;
    }

    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader("towary.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split("\\s");
                Item item = new Item(Integer.valueOf(s[0]), Integer.valueOf(s[1]));
                container.content().add(item);
                count++;
                if (count % 200 == 0) {
                    System.out.println("utworzono " + count + " obiektów");
                }
            }
            container.setEnd(true);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
/*        System.out.println ( "Producer putted " + count + " elements." );
        container.setEnd ( true );*/
    }

}