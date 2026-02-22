package com.group2.online_book_store.Controller;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.statistics.book_metrics;
import com.group2.online_book_store.Entity.user.Status;
import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Entity.statistics.GlobalStatistics;
import com.group2.online_book_store.dto.DailyDownloadStats;
import com.group2.online_book_store.Service.BookService.bookService;
import com.group2.online_book_store.Service.Statistics.bookEventService;
import com.group2.online_book_store.Service.PdfThumbnailGenerator.thumbnail;
import com.group2.online_book_store.Service.Statistics.GlobalStatisticsService;
import com.group2.online_book_store.Service.UserService.userService;
import com.group2.online_book_store.Service.storage.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/admin")
@RestController
public class admin {

    private final userService userService;
    private final bookService bookService;
    private final StorageService storageService;
    private final thumbnail thumbnailService;
    private final bookEventService eventService;
    private final GlobalStatisticsService globalStatisticsService;

    @DeleteMapping("/removeUser")
    public ResponseEntity<Map<String, String>> removeUser(@RequestBody User user) {
        if (userService.removeUser(user)) {
            return ResponseEntity.ok(Map.of("status", "success", "message", "User Removed successfully"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("status", "error", "message", "user not found!"));
    }

    @PutMapping("/banUser")
    public ResponseEntity<Map<String, String>> banUser(@RequestBody User user) {
        if (userService.setStatus(user, Status.Banned)) {
            return ResponseEntity.ok(Map.of("status", "success", "message", "User Banned successfully"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("status", "error", "message", "user not found!"));
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping("/addBook")
    public ResponseEntity<Map<String, String>> addBook(@RequestBody Book book) {
        if (bookService.addBook(book)) {
            return ResponseEntity.ok(Map.of("status", "success", "message", "Book Added successfully"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("status", "error", "message", "invalid book"));


    }

    @DeleteMapping("/removeBook")
    public ResponseEntity<Map<String, String>> removeBook(@RequestBody Map<String, Integer> requestBody) {
        int id = requestBody.get("id"); // Extract the "id" from the request JSON

        if (bookService.removeBook(id)) {
            return ResponseEntity.ok(Map.of("status", "success", "message", "Book removed successfully"));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("status", "error", "message", "Book does not exist!"));
    }

    @PutMapping("/setStatus")
    public ResponseEntity<Map<String, String>> setRole(@RequestBody User user) {
        if (userService.setAdmin(user)) {
            return ResponseEntity.ok(Map.of("status", "success", "message", "User promoted to admin!"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("status", "error", "message", "user not found!"));
    }
    @PostMapping("/books/upload")
    public String uploadBook(@RequestParam("file") MultipartFile file) throws IOException {
        return storageService.uploadFile(file);
    }
    @PostMapping("/thumbnail/upload")
    public String uploadThumbnail(@RequestParam("file") MultipartFile file) throws IOException {
       return thumbnailService.generate(file);
    }


    @PutMapping("/editBook")
    public ResponseEntity<String> editBook(@RequestBody Book updatedBook) {
        boolean isUpdated = bookService.updateBook(updatedBook);

        if (isUpdated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/statistics")
    public List<book_metrics> getMetrics (){
        return eventService.getAllBookEvent();
    }

    @GetMapping("/daily-downloads")
    public List<DailyDownloadStats> getDailyDownloads() {
        return eventService.getDailyDownloads();
    }

    @GetMapping("/global-statistics")
    public ResponseEntity<GlobalStatistics> getGlobalStatistics() {
        return ResponseEntity.ok(globalStatisticsService.getGlobalStatistics());
    }
}
