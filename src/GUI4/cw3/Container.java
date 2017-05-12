package GUI4.cw3;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Container {

    public BlockingQueue< Item > content;
    public boolean isEnd;

    public Container () {
        content = new LinkedBlockingDeque<>();
        isEnd = false;
    }

    public synchronized Queue< Item > content () {
        return content;
    }

    public synchronized boolean isEnd () {
        return isEnd;
    }

    public synchronized void setEnd ( boolean end ) {
        isEnd = end;
    }

}
