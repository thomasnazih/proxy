package servlets;

import proxy.BookDAO;
import proxy.BookDAOProxy;
import user.Book;
import user.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getParameter("query");
        User currentUser = (User) request.getSession().getAttribute("user");

        BookDAO bookDAO = new BookDAOProxy(currentUser);
        List<Book> books = bookDAO.searchBooks(query);

        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("searchResults.jsp");
        dispatcher.forward(request, response);
    }
}
