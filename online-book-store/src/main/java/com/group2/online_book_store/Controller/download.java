package com.group2.online_book_store.Controller;

import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Service.BookDetailService.bookDetailService;
import com.group2.online_book_store.Service.BookService.bookService;
import com.group2.online_book_store.Service.DownloadsService.downloadsService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> downloadBook(@RequestBody Integer bookId, HttpSession session) {
        User user = (User)session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        }

        downloadsService.saveDownload(user, bookId);

        detailService.incrementDownloadCount(bookId);

        String bookImage = bookService.getBookImage(bookId);
        if (bookImage != null) {
            return ResponseEntity.ok(bookImage);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");

    }
}
