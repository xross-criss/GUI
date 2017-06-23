package GUI7.cw3;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class BookDataModel extends AbstractTableModel {

    private static final Column<?>[] COLUMNS = {
            new Column<>(
                    "Cover",
                    ImageIcon.class,
                    Book::getImageIcon,
                    (book, o) -> {
                    },
                    false
            ),
            new Column<>(
                    "Title",
                    String.class,
                    Book::getTitle,
                    (book, o) -> book.setTitle(o.toString()),
                    true
            ),
            new Column<>(
                    "Author",
                    String.class,
                    Book::getAuthor,
                    (book, o) -> book.setAuthor(o.toString()),
                    true
            ),
            new Column<>(
                    "Price",
                    Double.class,
                    Book::getPrice,
                    (book, o) -> {
                        if (o instanceof Double) {
                            book.setPrice(Double.class.cast(o));
                        } else if (o instanceof String) {
                            book.setPrice(Double.valueOf(o.toString()));
                        } else {
                            book.setPrice(0.0);
                        }
                    },
                    true
            ),
            new Column<>(
                    "Description",
                    String.class,
                    Book::getBookDescription,
                    (book, o) -> book.setBookDescription(o.toString()),
                    true
            )
    };

    private final BookRepository bookRepository;

    public BookDataModel(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return COLUMNS[columnIndex].name;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return COLUMNS[columnIndex].type;
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public int getRowCount() {
        return bookRepository.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        return COLUMNS[col].getData.apply(bookRepository.get(row));
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        COLUMNS[col].setData.accept(bookRepository.get(row), value);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return COLUMNS[column].editable;
    }

    private static class Column<ValueType> {
        private String name;
        private Class type;
        private Function<Book, ValueType> getData;
        private BiConsumer<Book, Object> setData;
        private boolean editable;

        private Column(String name, Class type, Function<Book, ValueType> getData, BiConsumer<Book, Object> setData, boolean editable) {
            this.name = name;
            this.type = type;
            this.getData = getData;
            this.setData = setData;
            this.editable = editable;
        }
    }

}
