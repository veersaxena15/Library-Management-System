package com.library.util;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer
{
    public static void initialize()
    {
        String usersTable = """
                CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL UNIQUE,
                password TEXT NOT NULL,
                role TEXT NOT NULL
                )
                """;

        String booksTable = """
                CREATE TABLE IF NOT EXISTS books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                author TEXT NOT NULL,
                quantity INTEGER NOT NULL
                )
                """;

        String membersTable = """
                CREATE TABLE IF NOT EXISTS members (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                use_id INTEGER,
                name TEXT NOT NULL
                )
                """;

        String issuedBooksTable = """
                CREATE TABLE IF NOT EXISTS issued_books (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                book_id INTEGER NOT NULL,
                member_id INTEGER NOT NULL,
                issued_date TEXT NOT NULL,
                return_date TEXT
                )
                """;

        try(Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement())
        {
            statement.execute(usersTable);
            statement.execute(booksTable);
            statement.execute(membersTable);
            statement.execute(issuedBooksTable);

            System.out.println("Database Table created successfully! ");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
