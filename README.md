# 📚 Library Management System

A console-based Library Management System developed using **Core Java, OOP, JDBC, and SQLite**. This project allows users to manage book records through a menu-driven interface with persistent database storage.

## 🚀 Features

- Add new books
- View all books
- Search books by ID
- Update book details
- Delete book records
- Store book data persistently using SQLite
- Interactive console menu

## 🛠️ Technologies Used

- **Java:** JDK 21
- **Database:** SQLite
- **Connectivity:** JDBC
- **IDE:** IntelliJ IDEA
- **Concepts:** Core Java, OOP, SQL, CRUD operations

## 📂 Project Structure

```text
LibraryManagementSystem/
├── src/
│   └── com/library/
│       ├── dao/
│       │   └── BookDAO.java
│       ├── model/
│       │   └── Book.java
│       ├── service/
│       ├── util/
│       │   ├── DatabaseConnection.java
│       │   └── DatabaseInitializer.java
│       ├── DatabaseTest.java
│       └── Main.java
├── library.db
└── README.md
```

## ⚙️ Prerequisites

- Java JDK 21
- IntelliJ IDEA
- SQLite JDBC driver

## ▶️ How to Run

1. Clone this repository:

   ```bash
   git clone https://github.com/veersaxena15/LibraryManagementSystem.git
   ```

2. Open the project in IntelliJ IDEA.
3. Add the SQLite JDBC JAR to the project's libraries.
4. Run `Main.java`.
5. Use the console menu to manage books.

## 🗄️ Database

The application uses SQLite to store book records.

### Books Table

| Column | Description |
|---|---|
| `id` | Unique book ID, generated automatically |
| `title` | Title of the book |
| `author` | Author of the book |
| `quantity` | Number of copies |

The database tables are initialized by `DatabaseInitializer.java`.

SQLite JDBC driver: [Xerial SQLite JDBC](https://github.com/xerial/sqlite-jdbc/releases)

## 🧠 Concepts Learned

- Object-Oriented Programming
- Classes, objects, and encapsulation
- JDBC database connectivity
- SQL CRUD operations
- `PreparedStatement` and `ResultSet`
- Exception handling
- Try-with-resources
- Console input with `Scanner`
- Menu-driven programming
- Database persistence

## 🔮 Future Enhancements

- User registration and login
- Admin and student roles
- Member management
- Book issuing and returning
- Fine calculation
- Input validation and improved error handling

## 👨‍💻 Author

**VEER SAXENA**

GitHub: [veersaxena15](https://github.com/veersaxena15)
