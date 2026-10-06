import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Book {
        int id;
        String title;
        String author;
        boolean available;

        Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.available = true;
        }
    }

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\n----- Book List -----");

        for (Book book : books) {
            System.out.println("ID: " + book.id);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Status: " +
                    (book.available ? "Available" : "Borrowed"));
            System.out.println("---------------------");
        }
    }

    static void searchBook() {
        sc.nextLine();

        System.out.print("Enter book title to search: ");
        String title = sc.nextLine();

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("\nBook Found!");
                System.out.println("ID: " + book.id);
                System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Status: " +
                        (book.available ? "Available" : "Borrowed"));
                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void borrowBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.id == id) {
                if (book.available) {
                    book.available = false;
                    System.out.println("Book borrowed successfully!");
                } else {
                    System.out.println("Book is already borrowed.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.id == id) {
                if (!book.available) {
                    book.available = true;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book is already available.");
                }
                return;
            }
        }

        System.out.println("Book not found.");
    }

    static void deleteBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id == id) {
                books.remove(i);
                System.out.println("Book deleted successfully!");
                return;
            }
        }

        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    System.out.println("Thank you!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
