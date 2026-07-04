package service.implement;

import entity.Book;
import entity.Transaction;
import entity.User;
import exception.AlreadyExistsException;
import exception.BookNotAvailableException;
import exception.NotFoundException;
import repository.BookRepository;
import repository.TransactionRepository;
import repository.UserRepository;
import service.LibraryService;
import util.ActionType;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;
import java.util.Random;

public class LibraryServiceImpl implements LibraryService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public LibraryServiceImpl(BookRepository bookRepository, UserRepository userRepository,
                              TransactionRepository transactionRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            throw new AlreadyExistsException("User already exists!");
        }

        userRepository.save(user);

        System.out.println("User successfully added!");
    }

    @Override
    public void addBook(Book book) {
        if (bookRepository.findById(book.getId()).isPresent()) {
            throw new AlreadyExistsException("Book already exists!");
        }

        bookRepository.save(book);

        System.out.println("Book successfully added!");
    }

    @Override
    public void borrowBook(int bookId, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found!"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found!"));

        if (!book.getAvailable()) {
            throw new BookNotAvailableException("Book not available!");
        }

        book.setAvailable(false);
        bookRepository.update(book);

        Transaction transaction = new Transaction();

        Random random = new Random();

        transaction.setId(random.nextInt(10000));
        transaction.setBookId(bookId);
        transaction.setUserId(userId);
        transaction.setActionType(ActionType.BORROW);
        transaction.setTransactionDate(Instant.now());

        transactionRepository.save(transaction);

        System.out.println("Book was successfully borrowed!");
    }

    @Override
    public void returnBook(int bookId, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User not found!"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException("Book not found!"));

        if (book.getAvailable()) {
            throw new AlreadyExistsException("Book is already in library!");
        }

        book.setAvailable(true);
        bookRepository.update(book);

        Transaction transaction = new Transaction();

        Random random = new Random();

        transaction.setId(random.nextInt(10000));
        transaction.setBookId(bookId);
        transaction.setUserId(userId);
        transaction.setActionType(ActionType.RETURN);
        transaction.setTransactionDate(Instant.now());

        transactionRepository.save(transaction);

        System.out.println("Book was successfully returned!");
    }
}
