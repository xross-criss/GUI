package GUI6.cw2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileManager {

    JFileChooser chooser;
    JPanel panel;
    JTextArea textArea;
    File storage;

    public FileManager(JTextArea textArea) {

        this.textArea = textArea;

        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Text files", "txt"));
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Data files", "dat"));
        panel = new JPanel();
    }

    public String getName() {
        return storage.getName();
    }

    public void read() {

        int ret = chooser.showDialog(panel, "Open file");
        if (ret == JFileChooser.APPROVE_OPTION) {
            try {
                storage = chooser.getSelectedFile();

                BufferedReader br = new BufferedReader(new FileReader(chooser
                        .getSelectedFile()));
                String line;
                textArea.setText("");

                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }

                br.close();
            } catch (NullPointerException e) {

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void save() {

        if (storage == null) {
            this.saveAs();
            return;
        } else {
            saveIn(storage);
        }
    }

    public void saveAs() {

        int ret = chooser.showDialog(panel, "Save as...");
        if (ret == JFileChooser.APPROVE_OPTION) {
            storage = chooser.getSelectedFile();
            saveIn(chooser.getSelectedFile());
        }
    }

    private void saveIn(File file) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(storage));
            bw.write(textArea.getText());
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}