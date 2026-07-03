package repository;

import entity.Book;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BookRepository {

    List<Book> findAll();

    Optional<Book> findById(int id);

    void save(Book book) throws SQLException;

    void update(Book book);

    void delete(int id);

}
