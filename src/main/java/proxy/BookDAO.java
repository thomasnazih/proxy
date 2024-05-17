package proxy;
import java.util.List;

import user.Book;
public interface BookDAO {
	 Book getBookById(int bookId);
	 List<Book> searchBooks(String query);
}
