package com.group2.online_book_store.Service.BookService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.book.bookDTO;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface bookService {


    boolean removeBook(int id);

    boolean addBook(Book book);

     Page<Book> searchBooks(String keyword, int page , int size);

       Page<Book> searchByType(Type type, int page, int size);

       Page<Book> searchByTypeAndKeyword(Type type, String keyword, int page, int size);

      String getBookImage(Integer bookId);

     Page<Book> getAllBooksInDescendingPriorityOrder(int page,int size);
     bookDTO getBookDTO(Book book);
     boolean updateBook(Book book);
     Book searchById(Integer id);
     String description(Integer id);
}
