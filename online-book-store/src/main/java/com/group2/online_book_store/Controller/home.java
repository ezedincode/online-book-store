package com.group2.online_book_store.Controller;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.book.bookDTO;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import com.group2.online_book_store.Service.BookDetailService.bookDetailService;
import com.group2.online_book_store.Service.BookService.bookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/home")
@RestController
public class home {

    private final bookService bookservice;
    private final bookDetailService bookdetailservice;

    public home(bookService service, bookDetailService bookdetailservice) {
        this.bookservice = service;
        this.bookdetailservice = bookdetailservice;
    }
    @GetMapping("")
    public ResponseEntity<List<bookDTO>> Books() {
        List<Book> books = bookservice.getAllBooksInDescendingPriorityOrder();
        List<bookDTO> bookDTOs = books.stream()
                .map(book -> bookDTO.builder()
                        .id(book.getId())
                        .title(book.getTitle())
                        .author(book.getAuthor())
                        .image(book.getImage())
                        .publishedDate(book.getPublishedDate())
                        .type(book.getType())
                        .build())
                .toList();
        return ResponseEntity.ok(bookDTOs);
    }

    @PostMapping("/search")
    public ResponseEntity<List<bookDTO>> searchBooks(@RequestBody String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            List<Book> books = bookservice.searchBooks(keyword);
            if (books.isEmpty()) {
                return ResponseEntity.noContent().build(); // No content if no books found
            }
            List<bookDTO> bookDTOs = books.stream()
                    .map(book -> bookDTO.builder()
                            .id(book.getId())
                            .title(book.getTitle())
                            .author(book.getAuthor())
                            .image(book.getImage())
                            .publishedDate(book.getPublishedDate())
                            .type(book.getType())
                            .build())
                    .toList();

            return ResponseEntity.ok(bookDTOs); // Return list of books in JSON format
        }
        return ResponseEntity.badRequest().body(null); // Bad request if empty keyword
    }
    @GetMapping("/type")
    public ResponseEntity<List<Book>> searchByType(@RequestBody Type type) {
        if (type != null) {
            List<Book> books = bookservice.searchByType(type);
            if (books.isEmpty()) {
                return ResponseEntity.noContent().build(); // No content if no books found
            }
            return ResponseEntity.ok(books); // Return list of books in JSON format
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping("/getDetail")
    public ResponseEntity<BookDetail> getDetail(@RequestBody int id) {
        BookDetail detail=bookdetailservice.getBookDetail(id);
        if(detail==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detail);
    }
}



