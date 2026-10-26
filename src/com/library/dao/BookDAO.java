
package com.library.dao;

import com.library.model.Book;
import com.library.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

    public void addBook(Book book) {

        String sql = "INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getQuantity());

            statement.executeUpdate();

            System.out.println("Book added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllBooks() {

        String sql = "SELECT * FROM books";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            boolean found = false;

            while (resultSet.next()) {
                found = true;

                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int quantity = resultSet.getInt("quantity");

                System.out.println("-------------------------");
                System.out.println("Book ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Quantity: " + quantity);
            }

            if (!found) {
                System.out.println("No books found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void searchBookById(int bookId) {

        String sql = "SELECT * FROM books WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, bookId);

            try (ResultSet resultSet = statement.executeQuery()) {

                if (resultSet.next()) {

                    System.out.println("-------------------------");
                    System.out.println("Book ID: " + resultSet.getInt("id"));
                    System.out.println("Title: " + resultSet.getString("title"));
                    System.out.println("Author: " + resultSet.getString("author"));
                    System.out.println("Quantity: " + resultSet.getInt("quantity"));

                } else {
                    System.out.println("Book not found!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBook(int bookId, String title, String author, int quantity) {

        String sql = "UPDATE books SET title = ?, author = ?, quantity = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, quantity);
            statement.setInt(4, bookId);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("-------------------------");
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId) {

        String sql = "DELETE FROM books WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, bookId);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("-------------------------");
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
