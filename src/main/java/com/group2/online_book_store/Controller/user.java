package com.group2.online_book_store.Controller;


import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Service.UserService.userServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/api")
@RestController
public class user {
    private final userServiceImpl service;
    @PostMapping("logout")
    public ResponseEntity<Map<String, String>> Logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(Map.of("status", "success", "message", "Logged out successfully"));
    }
    @PutMapping("/update")
    public ResponseEntity<Map<String, String>> updateProfile(@RequestBody User user, HttpSession session) {
        User currentUser = (User) session.getAttribute("user");

        if (currentUser == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("status", "error", "message", "User not logged in"));
        }
        boolean updated = service.updateUserDetails(currentUser, user);

        if (updated) {
            session.setAttribute("user", currentUser);

            return ResponseEntity.ok(Map.of("status", "success", "message", "User details updated successfully"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("status", "error", "message", "user name or password is empty"));
    }

}
