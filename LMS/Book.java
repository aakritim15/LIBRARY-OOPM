package LMS;

import java.util.*;

public class Book {
    public String title;
    public String author;
    public String publication;
    public String ISBN;
    public int quantity;

    Book(String title, String author, String publication, String ISBN, int quantity) {
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }

    public void getBookDetails() {
        System.out.print(title + "\t" + author + "\t" + publication + "\t\t" + ISBN + "\t" + quantity + "\t");
    }
}
