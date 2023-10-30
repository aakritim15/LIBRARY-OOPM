package LMS;

import java.util.*;

public class Admin extends Library {
    public static String admin_name;
    public static String admin_ID;
    public static BookDatabase db = new BookDatabase();

    Admin(String admin_name1, String admin_ID1) {
        admin_name = admin_name1;
        admin_ID = admin_ID1;
    }

    public static void choice() {
        System.out.flush();
        System.out.println("Welcome Admin!");
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println(
                    "\n1. Add book to database.\n2. Delete book from database.\n3. Display Database\n4. Logout\n5. Exit");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    BookDatabase.displayDatabase();
                    break;
                case 4:
                    System.out.flush();
                    main(null);
                    break;
                case 5:
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String title = sc.next();
        System.out.println("Enter book author: ");
        String author = sc.next();
        System.out.println("Enter book publication: ");
        String publication = sc.next();
        System.out.println("Enter book ISBN: ");
        String ISBN = sc.next();
        System.out.println("Enter book available quantity: ");
        int quantity = sc.nextInt();
        Book b = new Book(title, author, publication, ISBN, quantity);
        BookDatabase.addBook(b);
    }

    public static void deleteBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the title of the book that you want to delete: ");
        String title = sc.next();
        BookDatabase.deleteBook(title);
    }
}
