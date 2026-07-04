package service;

import entity.Book;
import entity.User;

import java.util.List;

public interface LibraryService {

    List<User> getAllUsers();

    List<Book> getAllBooks();

    void addUser(User user);

    void addBook(Book book);

    void borrowBook(int bookId, int userId);

    void returnBook(int bookId, int userId);

}
