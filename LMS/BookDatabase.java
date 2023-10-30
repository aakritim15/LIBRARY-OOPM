package LMS;

import java.util.*;

public class BookDatabase {
    public static Vector<Book> all_books = new Vector<Book>();

    public static void addBook(Book b) {
        all_books.add(b);
        System.out.println("Book successfully added to system.");
    }

    public static void deleteBook(String title) {
        for (int i = 0; i < all_books.size(); i++) {
            if (title.equalsIgnoreCase(all_books.get(i).title)) {
                all_books.remove(i);
                System.out.println("Book successfully deleted from system.");
            }
        }
    }

    public static void displayDatabase() {
        System.out.println("Title\tAuthor\tPublication\tISBN\tQuantity");
        for (int i = 0; i < all_books.size(); i++) {
            all_books.get(i).getBookDetails();
            System.out.println();
        }
    }

    public static String search(String given_title) {
        for (int i = 0; i < all_books.size(); i++) {
            if (given_title.equalsIgnoreCase(all_books.get(i).title)) {
                return given_title;
            }
        }
        return "";
    }
}
