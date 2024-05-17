package proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.Book;
import user.User;
public class BookDAOProxy implements BookDAO{
	private BookDAOImpl bookDAO;
    private Map<Integer, Book> bookCache;
    private User currentUser;

    public BookDAOProxy(User user) {
        this.bookDAO = new BookDAOImpl();
        this.bookCache = new HashMap<>();
        this.currentUser = user;
    }

    @Override
    public Book getBookById(int bookId) {
        if (bookCache.containsKey(bookId)) {
            return bookCache.get(bookId);
        }

        if (!currentUser.hasPermission("VIEW_BOOK")) {
            throw new SecurityException("User does not have permission to view books");
        }

        Book book = bookDAO.getBookById(bookId);
        bookCache.put(bookId, book);
        return book;
    }

    @Override
    public List<Book> searchBooks(String query) {
        if (!currentUser.hasPermission("SEARCH_BOOKS")) {
            throw new SecurityException("User does not have permission to search books");
        }

        return bookDAO.searchBooks(query);
    }
}
