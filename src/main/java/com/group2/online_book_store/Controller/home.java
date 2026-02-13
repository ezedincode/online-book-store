package com.group2.online_book_store.Controller;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.book.bookDTO;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import com.group2.online_book_store.Service.BookService.bookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.http.HttpHeaders;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/home")
@RestController
public class home {


    private final bookService bookservice;

    public bookDTO toBookDTO(Book book) {
        return bookservice.getBookDTO(book);
    }
    public String getDescription(Integer id) {
        return bookservice.description(id);
    }
    @GetMapping("/bookList")
    public ResponseEntity<List<bookDTO>> Books(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Book> books = bookservice.getAllBooksInDescendingPriorityOrder(page,size);
        if (books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<bookDTO> bookDTOs = new ArrayList<>();
        for(Book book : books) {
            bookDTO bookDTO = toBookDTO(book);
            bookDTO.setDescription(getDescription(book.getId()));
            System.out.println();
            bookDTOs.add(bookDTO);
        }

        return ResponseEntity.ok(bookDTOs);
    }

    @PostMapping("/search")
    public ResponseEntity<List<bookDTO>> searchBooks(
            @RequestBody Map<String, String> request,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        String keyword = request.get("keyword");
        if (keyword != null && !keyword.isEmpty()) {
            Page<Book> books = bookservice.searchBooks(keyword,page,size);
            if (books.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            List<bookDTO> bookDTOs = new ArrayList<>();
            for(Book book : books) {
                bookDTO bookDTO = toBookDTO(book);
                bookDTO.setDescription(getDescription(book.getId()));
                System.out.println();
                bookDTOs.add(bookDTO);
            }

            return ResponseEntity.ok(bookDTOs);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping("/type")
    public ResponseEntity<List<bookDTO>> searchByType(@RequestBody Type type) {
        if (type != null) {
            List<Book> books = bookservice.searchByType(type);
            if (books.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            List<bookDTO> bookDTOs= books.stream()
                    .map(this::toBookDTO)
                    .toList();
            return ResponseEntity.ok(bookDTOs);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PostMapping("/getDetail")
    public ResponseEntity<BookDetail> getDetail(@RequestBody Map<String, Integer> request) {
        int id = request.get("id"); // Extract `id` from the request body
        Book newBook= bookservice.searchById(id);
        if (newBook != null) {
            BookDetail detail = newBook.getBookDetail();


            if (detail != null) {
                return ResponseEntity.ok(detail);

            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException {
        String imageDirectory = "C:/Users/HP/Downloads/";
        Path path = Paths.get(imageDirectory).resolve(imageName);
        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists() || !resource.isReadable()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                .body(resource);
    }
    @PostMapping("/searchById")
    public ResponseEntity <Book> searchBooks(@RequestBody Integer id) {
        Book newbook = bookservice.searchById(id);
        if (newbook == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(newbook);

    }
}





