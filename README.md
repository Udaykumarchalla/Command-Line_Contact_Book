# Command-Line Personal Contact Book

A simple but robust command-line application built with Core Java to manage personal contacts. This project demonstrates fundamental Java concepts and good software design principles.

## Features

- **Add New Contact:** Add a new contact with a name, phone number, and email address.
- **View All Contacts:** Display a formatted list of all saved contacts.
- **Search for Contact:** Find a specific contact by name (case-insensitive).
- **Delete Contact:** Remove a contact from the address book.
- **Data Persistence:** All contacts are automatically saved to a `contacts.txt` file upon exiting and loaded back upon startup, so data is never lost.

## Technologies Used

- **Java:** The core programming language.
- **Object-Oriented Programming (OOP):** Designed with classes for `Contact` and `ContactService` to ensure modular and maintainable code.
- **Java Collections Framework:** Utilized `ArrayList` to manage the list of contacts in memory.
- **Java I/O:** Implemented file reading and writing to persist contact data locally.

## How to Run

1.  Clone the repository:
    ```bash
    git clone https://github.com/your-username/contact-book-java.git
    ```
2.  Navigate to the project directory:
    ```bash
    cd contact-book-java
    ```
3.  Compile the Java source files:
    ```bash
    javac src/com/yourname/contactbook/*.java
    ```
4.  Run the application:
    ```bash
    java -cp src com.yourname.contactbook.Main
    ```
