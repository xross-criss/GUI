package GUI6.cw2;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeSet;

public class Main extends JFrame {

    boolean isChange = false;
    JTextArea textArea;
    String titlePrefix = "Prosty edytor - ", titleSufix,
            titleSufixDefault = "bez tytułu";
    FileManager fileManager;
    Hashtable<String, Color> colors;
    HashMap<Integer, String> fonts;

    {
        colors = new Hashtable<String, Color>();

        colors.put("Blue", Color.BLUE);
        colors.put("Yellow", Color.YELLOW);
        colors.put("Orange", Color.ORANGE);
        colors.put("Red", Color.RED);
        colors.put("White", Color.WHITE);
        colors.put("Black", Color.BLACK);
        colors.put("Green", Color.GREEN);

        fonts = new HashMap<Integer, String>();

        fonts.put(8, "8 pts");
        fonts.put(10, "10 pts");
        fonts.put(12, "12 pts");
        fonts.put(14, "14 pts");
        fonts.put(16, "16 pts");
        fonts.put(18, "18 pts");
        fonts.put(20, "20 pts");
        fonts.put(22, "22 pts");
        fonts.put(24, "24 pts");
    }

    protected void initElements() {

        textArea = new JTextArea();
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                isChange = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            }
        });
        add(new JScrollPane(textArea));

        fileManager = new FileManager(textArea);

        JMenu file = new JMenu("File");

        JMenuItem fileOpen = new JMenuItem("Open");
        fileOpen.setToolTipText("Otwórz plik");
        fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                ActionEvent.CTRL_MASK));
        fileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.read();
                setTitleText(fileManager.getName());
            }
        });

        JMenuItem fileSave = new JMenuItem("Save");
        fileSave.setToolTipText("Zapisz do pliku");
        fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK));
        fileSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.save();
            }
        });

        JMenuItem fileSaveas = new JMenuItem("Save As");
        fileSaveas.setToolTipText("Zapisz do nowego pliku");
        fileSaveas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
                ActionEvent.CTRL_MASK));
        fileSaveas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileManager.saveAs();
                setTitleText(fileManager.getName());
            }
        });

        JMenuItem fileExit = new JMenuItem("Exit");
        fileExit.setToolTipText("Wyjście z edytora");
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                ActionEvent.CTRL_MASK));
        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isChange == false)
                    System.exit(0);

                int choice = JOptionPane.showConfirmDialog(null,
                        "Zakończyć pracę? Niezapisane zmiany zostaną utracone",
                        "Wyjście z programu", 2);
                if (choice == JOptionPane.OK_OPTION) {
                    System.exit(0);
                } else {
                    return;
                }
            }
        });

        file.add(fileOpen);
        file.add(fileSave);
        file.add(fileSaveas);
        file.addSeparator();
        file.add(fileExit);

        JMenu edit = new JMenu("Edit");
        JMenu editAddresses = new JMenu("Adresy");

        JMenuItem editAddressesWork = new JMenuItem("Praca");
        editAddressesWork.setToolTipText("Wstaw adres miejsca zatrudnienia");
        editAddressesWork.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        editAddressesWork.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.insert("Warszawa, Puławska 182", textArea
                        .getCaretPosition());
            }
        });

        JMenuItem editAddressesHome = new JMenuItem("Dom");
        editAddressesHome.setToolTipText("Wstaw adres miejsca zamieszkania");
        editAddressesHome.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        editAddressesHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.insert("Warszawa Gagarina 555", textArea
                        .getCaretPosition());
            }
        });

        JMenuItem editAddressesSchool = new JMenuItem("Szkoła");
        editAddressesSchool.setToolTipText("Wstaw adres uczelni");
        editAddressesSchool.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        editAddressesSchool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.insert("Warszawa, Koszykowa 86", textArea
                        .getCaretPosition());
            }
        });

        editAddresses.add(editAddressesWork);
        editAddresses.add(editAddressesHome);
        editAddresses.add(editAddressesSchool);
        edit.add(editAddresses);

        JMenu options = new JMenu("Options");
        JMenuItem menuItem;

        JMenu optionsForeground = new JMenu("Foreground");
        ListenerForeground listenerForeground = new ListenerForeground(textArea);
        for (String key : colors.keySet()) {
            menuItem = new JMenuItem(key, new Icon(colors.get(key)));
            menuItem.addActionListener(listenerForeground);
            optionsForeground.add(menuItem);
        }

        JMenu optionsBackground = new JMenu("Background");
        ListenerBackground listenerBackground = new ListenerBackground(textArea);
        for (String key : colors.keySet()) {
            menuItem = new JMenuItem(key, new Icon(colors.get(key)));
            menuItem.addActionListener(listenerBackground);
            optionsBackground.add(menuItem);
        }

        JMenu optionsFontsize = new JMenu("Font size");
        TreeSet<Integer> sortedSet = new TreeSet<Integer>(
                new ArrayList<Integer>(fonts.keySet()));
        for (Object key : sortedSet.toArray()) {
            menuItem = new JMenuItem(fonts.get(key));
            menuItem.addActionListener(new ListenerFontSize(textArea,
                    (Integer) key));
            optionsFontsize.add(menuItem);
        }

        options.add(optionsForeground);
        options.add(optionsBackground);
        options.add(optionsFontsize);

        JMenuBar menu = new JMenuBar();
        menu.add(file);
        menu.add(edit);
        menu.add(options);

        setJMenuBar(menu);
    }

    protected void initUI() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(300, 300));
        setLocationRelativeTo(null);
        setTitle(titlePrefix + titleSufixDefault);

        setVisible(true);
    }

    protected void setTitleText(String sufix) {
        titleSufix = sufix;
        setTitle(titlePrefix + titleSufix);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }

    Main() {
        initElements();
        initUI();
    }
}
