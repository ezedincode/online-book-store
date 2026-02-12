package com.group2.online_book_store.Service.BookService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.book.bookDTO;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;

import java.util.List;

public interface bookService {


    boolean removeBook(int id);

    boolean addBook(Book book);

     List<Book> searchBooks(String keyword);

     List<Book> searchByType(Type type);
     String getBookImage(Integer bookId);

     List<Book> getAllBooksInDescendingPriorityOrder();
     bookDTO getBookDTO(Book book);
     boolean updateBook(Book book);
     Book searchById(Integer id);
     String description(Integer id);
}
