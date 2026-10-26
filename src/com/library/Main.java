
package com.library;

import com.library.dao.BookDAO;
import com.library.model.Book;
import com.library.util.DatabaseInitializer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initialize();

        BookDAO bookDAO = new BookDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(title, author, quantity);
                    bookDAO.addBook(book);
                    break;

                case 2:
                    bookDAO.getAllBooks();
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();

                    bookDAO.searchBookById(searchId);
                    break;

                case 4:
                    System.out.print("Enter book ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();

                    bookDAO.updateBook(
                            updateId, newTitle, newAuthor, newQuantity
                    );
                    break;

                case 5:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    bookDAO.deleteBook(deleteId);
                    break;

                case 6:
                    System.out.println("Thank you for using the Library Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
