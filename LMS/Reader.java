package LMS;

import java.util.*;

public class Reader extends Library {
    public String ReaderName;
    public String ReaderID;
    public Account readerAcct;

    Reader() {
    }

    Reader(String ReaderName, String ReaderID) {

        readerAcct = new Account();
        this.ReaderID = ReaderID;
        this.ReaderName = ReaderName;
    }

    public void choice() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Welcome " + ReaderName + "!");
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println(
                    "\n1. Issue a book.\n2. Return a book.\n3. Display Account Details\n4. View Book Database\n5. Logout\n6. Exit");
            System.out.println("Enter your choice:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    borrowedBooks();
                    break;
                case 2:
                    returnBooks();
                    break;
                case 3:
                    getDetails();
                    readerAcct.getAccountDetails();
                    break;
                case 4:
                    BookDatabase.displayDatabase();
                    break;
                case 5:
                    System.out.flush();
                    break;
                case 6:
                    flag = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public void getDetails() {
        System.out.println("Reader Details:");
        System.out.println("Reader ID: " + ReaderID);
        System.out.println("Reader Name: " + ReaderName);
    }

    public void borrowedBooks() {
        Scanner b = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String btitle = b.next();
        String availableBookTitle = BookDatabase.search(btitle);
        if (availableBookTitle != "") {
            readerAcct.borrowedBooksV.add(availableBookTitle);
            for (int i = 0; i < BookDatabase.all_books.size(); i++) {
                if (readerAcct.borrowedBooksV.get(i).equalsIgnoreCase(BookDatabase.all_books.get(i).title)) {
                    BookDatabase.all_books.get(i).quantity--;
                    System.out.println("Book was successfully issued!");
                }
            }
        } else {
            System.out.println("Book is not available in database!");
        }
    }

    public void returnBooks() {
        Scanner b = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String btitle = b.next();
        String availableBookTitle = BookDatabase.search(btitle);
        if (availableBookTitle != "") {
            readerAcct.returnedBooksV.add(availableBookTitle);
            readerAcct.borrowedBooksV.removeElement(availableBookTitle);
            for (int i = 0; i < BookDatabase.all_books.size(); i++) {
                if (readerAcct.returnedBooksV.get(i).equalsIgnoreCase(BookDatabase.all_books.get(i).title)) {
                    BookDatabase.all_books.get(i).quantity++;
                    System.out.println("Book was successfully returned!");
                }
            }
        } else {
            System.out.println("Book was not borrowed!");
        }
    }

}