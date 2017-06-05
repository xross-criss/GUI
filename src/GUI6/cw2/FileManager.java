package GUI6.cw2;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 * FileManager
 */
public class FileManager {

    JFileChooser chooser;
    JPanel panel;
    JTextArea textArea;
    String name;
    File storage;

    /**
     * @param textArea
     */
    public FileManager(JTextArea textArea) {

        this.textArea = textArea;

        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(
                "pliki tekstowe", "txt"));
        panel = new JPanel();
    }

    /**
     * @return
     */
    public String getName() {
        return storage.getName();
    }

    /**
     *
     */
    public void read() {

        int ret = chooser.showDialog(panel, "Otwórz plik");
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
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     *
     */
    public void save() {

        if (storage == null) {
            this.saveAs();
            return;
        } else {
            _save(storage);
        }
    }

    /**
     *
     */
    public void saveAs() {

        int ret = chooser.showDialog(panel, "Zapisz jako");
        if (ret == JFileChooser.APPROVE_OPTION) {
            storage = chooser.getSelectedFile();
            _save(chooser.getSelectedFile());
        }
    }

    /**
     * @param file
     */
    private void _save(File file) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(storage));
            bw.write(textArea.getText());
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}