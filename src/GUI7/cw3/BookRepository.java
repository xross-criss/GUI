package GUI7.cw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private List<Book> bookList;

    public BookRepository() {
        this.bookList = new ArrayList<>();
    }

    public void load(String path) throws IOException {
        bookList.clear();
        File file;
        try (BufferedReader br = new BufferedReader(new FileReader(file = new File(path)))) {
            String folder = file.getParent();
            for (String line; (line = br.readLine()) != null; ) {
                String[] data = line.split("\\|");
                System.out.println(data.length);
                bookList.add(
                        new Book(
                                data[0],
                                data[1],
                                Double.parseDouble(data[2]),
                                data[3],
                                folder + File.separator + data[4]
                        )
                );
            }
        }
    }

    public int size() {
        return bookList.size();
    }

    public Book get(int row) {
        return bookList.get(row);
    }

    public void save(Book book) {
        bookList.add(book);
    }

}
