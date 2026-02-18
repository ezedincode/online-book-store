package com.group2.online_book_store.Controller;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.book.bookDTO;
import com.group2.online_book_store.dto.PageResponse;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import com.group2.online_book_store.Service.BookService.bookService;
import com.group2.online_book_store.Service.storage.StorageService;
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
    private final StorageService storageService;

    public bookDTO toBookDTO(Book book) {
        return bookservice.getBookDTO(book);
    }
    public String getDescription(Integer id) {
        return bookservice.description(id);
    }
    @GetMapping("/bookList")
    public ResponseEntity<PageResponse<bookDTO>> Books(
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
            bookDTOs.add(bookDTO);
        }

        PageResponse<bookDTO> response = PageResponse.<bookDTO>builder()
                .content(bookDTOs)
                .totalPages(books.getTotalPages())
                .totalElements(books.getTotalElements())
                .currentPage(page)
                .pageSize(size)
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/search")
    public ResponseEntity<PageResponse<bookDTO>> searchBooks(
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
                bookDTOs.add(bookDTO);
            }

            PageResponse<bookDTO> response = PageResponse.<bookDTO>builder()
                    .content(bookDTOs)
                    .totalPages(books.getTotalPages())
                    .totalElements(books.getTotalElements())
                    .currentPage(page)
                    .pageSize(size)
                    .build();

            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PostMapping("/type")
    public ResponseEntity<PageResponse<bookDTO>> searchByType(
            @RequestBody Type type,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        if (type != null) {
            Page<Book> books = bookservice.searchByType(type, page, size);
            if (books.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            List<bookDTO> bookDTOs = new ArrayList<>();
            for (Book book : books) {
                bookDTO bookDTO = toBookDTO(book);
                bookDTO.setDescription(getDescription(book.getId()));
                bookDTOs.add(bookDTO);
            }

            PageResponse<bookDTO> response = PageResponse.<bookDTO>builder()
                    .content(bookDTOs)
                    .totalPages(books.getTotalPages())
                    .totalElements(books.getTotalElements())
                    .currentPage(page)
                    .pageSize(size)
                    .build();

            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/searchByTypeAndKeyword")
    public ResponseEntity<PageResponse<bookDTO>> searchByTypeAndKeyword(
            @RequestBody Map<String, Object> request,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        String typeStr = (String) request.get("type");
        String keyword = (String) request.get("keyword");
        
        if (typeStr != null && keyword != null) {
            try {
                Type type = Type.valueOf(typeStr);
                Page<Book> books = bookservice.searchByTypeAndKeyword(type, keyword, page, size);
                
                if (books.isEmpty()) {
                    return ResponseEntity.noContent().build();
                }
                
                List<bookDTO> bookDTOs = new ArrayList<>();
                for (Book book : books) {
                    bookDTO bookDTO = toBookDTO(book);
                    bookDTO.setDescription(getDescription(book.getId()));
                    bookDTOs.add(bookDTO);
                }

                PageResponse<bookDTO> response = PageResponse.<bookDTO>builder()
                        .content(bookDTOs)
                        .totalPages(books.getTotalPages())
                        .totalElements(books.getTotalElements())
                        .currentPage(page)
                        .pageSize(size)
                        .build();

                return ResponseEntity.ok(response);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.badRequest().body(null);
            }
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
    @PostMapping("/download")
    public ResponseEntity<Map<String, String>> downloadBook(@RequestBody Map<String, String> request) {
        String filename = request.get("filename");

        String signedUrl = storageService.generateSignedUrl(filename);

        Map<String, String> response = Map.of("url", signedUrl);
        return ResponseEntity.ok(response);
    }

}





