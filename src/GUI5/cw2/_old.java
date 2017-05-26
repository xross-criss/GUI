package GUI5.cw2;

public class _old {

/*
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;

    public class Main {
        public static void main(String[] args){
            File[] files = new File("C:/Eclipse/Grafika").listFiles();
            ArrayList<String> path = new ArrayList<>();

            for(int i=0; i<files.length; i++){
                if(accept(files[i].getAbsolutePath()))
                    path.add(files[i].getAbsolutePath());
            }

            new Panel(path,1,20);
        }

        public static boolean accept(String fname) {
            if(fname.lastIndexOf('.')>0){
                int lastIndex = fname.lastIndexOf('.');
                String str = fname.substring(lastIndex);

                if(str.equals(".gif") || str.equals(".jpg") || str.equals(".png") )
                    return true;
            }
            return false;
        }

    }


import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

    public class Panel extends JFrame{
        ImageIcon icon;
        JLabel label;

        public Panel(ArrayList<String> path, int wait, int size){
            wait*=1000;

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setLayout(new FlowLayout());
            setResizable(false);
            craftImage(path, wait);
            end(size);
        }

        public void craftImage(ArrayList<String> path, int wait){
            for(int i=0; i<path.size(); i++){
                icon = new ImageIcon(path.get(i));
                label = new JLabel(icon);
                add(label);
                pack();
                setLocationRelativeTo(null);
                try {
                    Thread.sleep(wait);
                }catch (InterruptedException e){}
                remove(label);
                revalidate();
                repaint();
            }
        }
        public void end(int size){
            label = new JLabel("Zakończenie Prezentacji ",JLabel.CENTER);
            Rectangle r = getBounds();
            int h = r.height;
            int w = r.width;
            label.setBounds(w/2 - 200, h/2-150,300,200);
            label.setFont(new Font(null, Font.BOLD, size));
            add(label);
        }
    }*/
}
