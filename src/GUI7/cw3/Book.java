package GUI7.cw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {

    private String author;
    private String title;
    private double price;
    private String bookDescription;
    private String pictureURL;


/*    */

    /**
     * Konstruktor tworzący
     *
     * @param author autor
     * @param title  tutył książki
     * @param price  cena książki
     *//*
    public Book(String author, String title, double price) {
        super();
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public Book() {
        super();
        this.author = "";
        this.title = "";
        this.price = 0;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }*/
    public Book(String author, String title, double price, String bookDescription, String pictureURL) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.bookDescription = bookDescription;
        this.pictureURL = pictureURL;
    }

    public Book() {
        super();
        this.author = "";
        this.title = "";
        this.price = 0;
        this.bookDescription = "";
        this.pictureURL = "";
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public static String formatDescription(String bookDescription, int maxlimit) {
        List<String> bookDescList = new ArrayList<>(Arrays.asList(bookDescription.split(" ")));
        List<String> cp = new ArrayList<>();
        StringBuilder sb;
        int counter = 0;

        for (int i = 0; i < bookDescList.size(); i++) {
            if (counter == maxlimit) {
                sb = new StringBuilder(bookDescList.get(i));
                sb.append("/\n");
                cp.add(sb.toString());
                counter = 0;
            } else {
                cp.add(bookDescList.get(i));
                counter++;
            }
        }

        sb = new StringBuilder();

        for (String s : cp) {
            sb.append(s);
        }

        return sb.toString();
    }
}
