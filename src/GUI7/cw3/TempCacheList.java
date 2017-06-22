package GUI7.cw3;

import java.util.ArrayList;
import java.util.List;

public class TempCacheList{
    private List<Book> listOfBooks;
    Book book;

    public TempCacheList(List<Book> listOfBooks, Book book) {
        this.listOfBooks = listOfBooks;
        this.book = book;
    }

    public TempCacheList() {
        new ArrayList<>();
    }

    public TempCacheList(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public void addBookToList(Book book){

    }

    public Book getBook(int iteration) {
        return listOfBooks.get(iteration);
    }
}
