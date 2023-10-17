package LMS;

import java.util.*;

public class Account {
    public Vector<String> borrowedBooksV = new Vector<String>();
    public Vector<String> returnedBooksV = new Vector<String>();
    public float fine;

    Account() {
        fine = 0;
    }

    public void getAccountDetails() {
        System.out.println("Borrowed Books: ");
        for (int i = 0; i < borrowedBooksV.size(); i++) {
            System.out.println((i + 1) + ". " + borrowedBooksV.get(i));
        }
        System.out.println("Returned Books: ");
        for (int i = 0; i < returnedBooksV.size(); i++) {
            System.out.println((i + 1) + ". " + returnedBooksV.get(i));
        }
        System.out.println("Fine: Rs." + fine);
    }
}
