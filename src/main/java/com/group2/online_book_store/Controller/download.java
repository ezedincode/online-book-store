package com.group2.online_book_store.Controller;

import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Service.BookDetailService.bookDetailService;
import com.group2.online_book_store.Service.BookService.bookService;
import com.group2.online_book_store.Service.DownloadsService.downloadsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/download")
@RestController
public class download {
    private final bookService bookService;
    private final downloadsService downloadsService;
    private final bookDetailService detailService;

    public download(com.group2.online_book_store.Service.BookService.bookService bookService, com.group2.online_book_store.Service.DownloadsService.downloadsService downloadsService, bookDetailService detailService) {
        this.bookService = bookService;
        this.downloadsService = downloadsService;
        this.detailService = detailService;
    }
    @PostMapping("")
    public ResponseEntity<String> downloadBook(@RequestBody Integer id) {
        // Increment download count
        detailService.incrementDownloadCount(id);

        // Get the book image URL
        String bookImage = bookService.getBookImage(id);

        if (bookImage != null) {
            // Return the book image URL as a JSON object
            String jsonResponse = "{\"image\": \"" + bookImage + "\"}";
            return ResponseEntity.ok(jsonResponse);
        }

        // If book is not found, return a JSON error message
        String errorResponse = "{\"error\": \"Book not found\"}";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
