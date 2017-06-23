package GUI7.cw3;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.io.File;
import java.util.Objects;

public class MyFrame extends JFrame {

    public static final String DEFAULT_LOC = "E:\\workspace\\privat\\GUI\\resources\\SampleData.dat";

    private final BookRepository bookRepository;
    private final AbstractTableModel tableModel;
    private final JScrollPane scrollPane;
    private final JTable table;

    private final JMenuBar menuBar;
    private final JMenu menu0, menu1;
    private final JMenuItem menuAdd0, menuAdd1, menuFileOpen, menuFileSave;
    private final JPopupMenu popupMenu;
    private final JMenuItem menuEdit, menuDelete;

    private int lastRowPopup = 0;

    public MyFrame() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 1));
        this.bookRepository = new BookRepository();

        this.popupMenu = new JPopupMenu();
        this.popupMenu.addPopupMenuListener(new PopupMouseListener());
        this.menuDelete = new JMenuItem("Delete");
        this.popupMenu.add(this.menuDelete);
        this.menuEdit = new JMenuItem("Edit");
        this.menuEdit.addActionListener(e -> openBookDialog(bookRepository.get(lastRowPopup)));
        this.popupMenu.add(this.menuEdit);
        this.menuAdd0 = new JMenuItem("Add");
        this.menuAdd0.addActionListener(e -> openBookDialog(null));
        this.popupMenu.add(this.menuAdd0);

        this.tableModel = new BookDataModel(this.bookRepository);
        this.table = new JTable(this.tableModel);
        this.table.setRowHeight(64);
        this.table.setComponentPopupMenu(this.popupMenu);
        this.scrollPane = new JScrollPane(this.table);
        this.add(this.scrollPane);

        this.menuBar = new JMenuBar();
        this.menu0 = new JMenu("File");
        this.menuBar.add(this.menu0);
        this.menuFileOpen = new JMenuItem("Open...");
        this.menuFileOpen.addActionListener(e -> openOpenDialog());
        this.menu0.add(this.menuFileOpen);
        this.menuFileSave = new JMenuItem("Save");
        this.menu0.add(this.menuFileSave);
        this.menu1 = new JMenu("Edit");
        this.menuBar.add(this.menu1);
        this.menuAdd1 = new JMenuItem("Add");
        this.menuAdd1.addActionListener(e -> openBookDialog(null));
        this.menu1.add(this.menuAdd1);
        this.setJMenuBar(this.menuBar);
    }

    private void openOpenDialog() {
        final JFileChooser fc = new JFileChooser(DEFAULT_LOC);
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Books data", "dat"));
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            try {
                this.bookRepository.load(file.getPath());
                this.tableModel.fireTableDataChanged();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        this,
                        "Cannot open selected file: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public static String openOpenPictureDialog() {
        final JFileChooser fc = new JFileChooser(DEFAULT_LOC);
        fc.setAcceptAllFileFilterUsed(false);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Image", "jpg"));
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Picture", "png"));
        int returnVal = fc.showOpenDialog(new MyFrame());
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            return file.getPath();
            }
        return null;
    }

    private void openBookDialog(Book book) {
        boolean toSave = false;
        if (Objects.isNull(book)) {
            toSave = true;
            book = new Book();
        }
        BookDialog dialog = new BookDialog(book, this);
        book = dialog.showDialog();
        if (toSave) {
            bookRepository.save(book);
        }
        tableModel.fireTableDataChanged();
        System.out.println(book);
    }

    private class PopupMouseListener implements PopupMenuListener {

        @Override
        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            SwingUtilities.invokeLater(() -> lastRowPopup = table.rowAtPoint(SwingUtilities.convertPoint(popupMenu, new Point(0, 0), table)));
        }

        @Override
        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        }

        @Override
        public void popupMenuCanceled(PopupMenuEvent e) {
        }

    }

}
