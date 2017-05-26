package GUI5.cw2;

import java.io.File;
import java.util.ArrayList;

public class Main {
    Text text = new Text();

    public void main(String[] args) {
        // H:\17_03_2017\tapety

        File[] files = new File(args[0]).listFiles();
        ArrayList<String> path = new ArrayList<>();

        Panel panel = new Panel(path, args[1], args[2]);

        for (int i = 0; i < files.length; i++) {
            if (accept(files[i].getAbsolutePath())) {
                path.add(files[i].getAbsolutePath());
            } else {
                text.setText("Brak obrazka");
                panel.end(Integer.parseInt(args[2]));
            }
        }
    }

    public static boolean accept(String fname) {
        if (fname.lastIndexOf('.') > 0) {
            int lastIndex = fname.lastIndexOf('.');
            String str = fname.substring(lastIndex);

            if (str.equals(".gif") || str.equals(".jpg") || str.equals(".png"))
                return true;
        }
        return false;
    }

}