package LMS;

import java.util.*;

public class Library {
    public static String userType;
    public static Vector<String> usernames = new Vector<String>();
    public static Vector<String> passwords = new Vector<String>();

    // public String getUserType() {
    // return userType;
    // }
    public static void register(String user_name, String user_password) {
        usernames.addElement(user_name);
        passwords.addElement(user_password);
        System.out.println("User credentials saved!");
    }

    public static boolean login(String type, String name, String password) {
        userType = type;
        if (usernames.contains(name)) {
            int index = usernames.indexOf(name);
            if (password.equals(passwords.get(index))) {
                System.out.println("Login Successful!");
                return true;
            } else {
                System.out.println("Incorrect Password!");
            }
        } else {
            System.out.println("User not registered!");
        }
        return false;
    }

    public static void main(String args[]) {
        usernames.add("AAKRITI");
        passwords.add("AAKRITI");
        Scanner sc = new Scanner(System.in);
        System.out.println("***LIBRARY***");
        boolean flag = true;
        while (flag) {
            System.out.println("1. Existing User? ---> Login.\n2. New User? --->  Register\n3. Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter user type: 1. Admin 2. Reader");
                    int type_ch = sc.nextInt();
                    System.out.println("Enter User ID: ");
                    String ID = sc.next();
                    System.out.println("Enter Username: ");
                    String name = sc.next();
                    System.out.println("Enter Password: ");
                    String password = sc.next();
                    String usertype = (type_ch == 1) ? "Admin" : "Reader";
                    boolean check_login = login(usertype, name, password);
                    if (check_login == true) {
                        if (type_ch == 1) {
                            System.out.flush();
                            Admin.choice();
                        }
                        if (type_ch == 2) {
                            Reader r = new Reader(name, ID);
                            r.choice();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter Username: ");
                    String name2 = sc.next();
                    System.out.println("Enter Password: ");
                    String password2 = sc.next();
                    register(name2, password2);
                    break;
                case 3:
                    flag = false;
                    System.exit(0);
                default:
                    System.out.println("Invalid option selected.");

            }

        }

    }
}