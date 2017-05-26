package GUI5.cw2;

import java.io.File;
import java.util.ArrayList;

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