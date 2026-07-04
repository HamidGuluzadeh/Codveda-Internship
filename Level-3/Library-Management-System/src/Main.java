import entity.Book;
import entity.User;
import repository.BookRepository;
import repository.TransactionRepository;
import repository.UserRepository;
import repository.implement.BookRepositoryImpl;
import repository.implement.TransactionRepositoryImpl;
import repository.implement.UserRepositoryImpl;
import service.LibraryService;
import service.implement.LibraryServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        boolean running = true;

        BookRepository bookRepository = new BookRepositoryImpl();
        UserRepository userRepository = new UserRepositoryImpl();
        TransactionRepository transactionRepository = new TransactionRepositoryImpl();

        LibraryService libraryService = new LibraryServiceImpl(bookRepository,
                userRepository, transactionRepository);

        while (running) {
            System.out.println("LIBRARY MANAGEMENT SYSTEM");
            System.out.println("---------------------------");
            System.out.println("1. Add a user");
            System.out.println("2. Add a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Show all users");
            System.out.println("6. Show all books");
            System.out.println("7. Exit");
            System.out.println(" ");
            System.out.print("Enter a choice: ");

            int choice = scan.nextInt();
            scan.nextLine();

            try {
                switch (choice) {
                    case 1:
                        int userId = random.nextInt(10000);

                        System.out.print("Enter first name: ");
                        String firstName = scan.nextLine();
                        System.out.print("Enter last name: ");
                        String lastName = scan.nextLine();
                        System.out.print("Enter email: ");
                        String email = scan.nextLine();

                        User user = new User(userId, firstName, lastName, email);

                        libraryService.addUser(user);
                        break;

                    case 2:
                        int bookId = random.nextInt(10000);
                        boolean available = true;

                        System.out.print("Enter book title: ");
                        String title = scan.nextLine();
                        System.out.print("Enter book author: ");
                        String author = scan.nextLine();

                        Book book = new Book(bookId, title, author, available);

                        libraryService.addBook(book);
                        break;

                    case 3:
                        System.out.print("Enter borrower user ID: ");
                        int borrowerUserId = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Enter borrowed book ID: ");
                        int borrowedBookId = scan.nextInt();
                        scan.nextLine();

                        libraryService.borrowBook(borrowedBookId, borrowerUserId);
                        break;

                    case 4:
                        System.out.print("Enter returner user ID: ");
                        int returnerUserId = scan.nextInt();
                        scan.nextLine();
                        System.out.print("Enter returned book ID: ");
                        int returnedBookId = scan.nextInt();
                        scan.nextLine();

                        libraryService.returnBook(returnedBookId, returnerUserId);
                        break;

                    case 5:
                        List<User> userList = libraryService.getAllUsers();

                        for (User userData : userList) {
                            System.out.println(userData);
                        }

                        break;

                    case 6:
                        List<Book> bookList = libraryService.getAllBooks();

                        for (Book bookData: bookList) {
                            System.out.println(bookData);
                        }

                        break;

                    case 7:
                        running = false;
                        System.out.println("Logging out...");
                        break;

                    default:
                        System.err.println("Invalid choice!");
                        break;
                }

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
