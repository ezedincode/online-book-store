package com.group2.online_book_store.Controller;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.user.Status;
import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Service.BookService.bookService;
import com.group2.online_book_store.Service.UserService.userService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/admin")
@RestController
public class admin {

    private final userService userService;
    private final bookService bookService;

    public admin(userService service, bookService bookService) {
        this.userService = service;
        this.bookService = bookService;
    }

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

//    @PutMapping("/setStatus")
//    public ResponseEntity<Map<String, String>> setRole(@RequestBody User user) {
//        if (userService.setAdmin(user)) {
//            return ResponseEntity.ok(Map.of("status", "success", "message", "User promoted to admin!"));
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(Map.of("status", "error", "message", "user not found!"));
//    }

    
    @PutMapping("/editBook")
    public ResponseEntity<String> editBook(@RequestBody Book updatedBook) {
        boolean isUpdated = bookService.updateBook(updatedBook);

        if (isUpdated) {
            return ResponseEntity.ok("Book updated successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to update book");
        }
    }
}
