package servlets;

import proxy.BookDAO;
import proxy.BookDAOProxy;
import user.Book;
import user.User;
import proxy.BookDAO;
import proxy.BookDAOProxy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;



/**
 * Servlet implementation class BookServlet
 */


public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("id"));
        User currentUser = (User) request.getSession().getAttribute("user");

        BookDAO bookDAO = new BookDAOProxy(currentUser);
        Book book = bookDAO.getBookById(bookId);

        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Book Details.jsp");
        dispatcher.forward(request, response);
    }
}
