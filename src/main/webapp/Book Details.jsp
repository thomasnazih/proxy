<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="user.Book" %>
<html>
<head>
    <title>Book Details</title>
</head>
<body>
<h1>Book Details</h1>
<%
    Book book = (Book) request.getAttribute("book");
    if (book != null) {
%>
    <p>Title: <%= book.getTitle() %></p>
    <p>Author: <%= book.getAuthor() %></p>
    <p>ISBN: <%= book.getIsbn() %></p>
    <p>Available: <%= book.isAvailable() ? "Yes" : "No" %></p>
<%
    } else {
%>
    <p>Book not found.</p>
<%
    }
%>
<a href="search.jsp">Back to Search</a>
</body>
</html>

