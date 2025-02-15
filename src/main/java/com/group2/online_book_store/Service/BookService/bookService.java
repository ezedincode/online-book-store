package com.group2.online_book_store.Service.BookService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.book.bookDTO;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;

import java.util.List;

public interface bookService {


    public boolean removeBook(int id);

    public boolean addBook(Book book);

    public List<Book> searchBooks(String keyword);

    public List<Book> searchByType(Type type);
    public String getBookImage(Integer bookId);

    public List<Book> getAllBooksInDescendingPriorityOrder();
    public bookDTO getBookDTO(Book book);
    public boolean updateBook(Book book);
    public Book searchById(Integer id);
}
