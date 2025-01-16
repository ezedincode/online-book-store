package com.group2.online_book_store.Service.BookService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import java.util.List;

public interface bookService {


    public boolean removeBook(Book book);

    public boolean addBook(Book book);

    public List<Book> searchBooks(String keyword);

    public List<Book> searchByType(Type type);
    public String getBookImage(Integer bookId);

    public List<Book> getAllBooksInDescendingPriorityOrder();

}
