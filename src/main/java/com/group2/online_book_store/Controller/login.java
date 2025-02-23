package com.group2.online_book_store.Controller;


import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Service.UserService.userServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true")
@RequestMapping("/api")
@RestController
public class login {
    private final userServiceImpl service;

    public login(userServiceImpl service) {
        this.service = service;
    }

//    @PostMapping("/signup")
//    public ResponseEntity<Map<String, String>> signup(@RequestBody User user) {
//        try {
//            service.registerUser(user.getEmail(), user.getPassword(), user.getUsername());
//            Map<String, String> response = Map.of(
//                    "status", "success",
//                    "message", "User Registered Successfully!"
//            );
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        } catch (IllegalArgumentException e) {
//            Map<String, String> errorResponse = Map.of(
//                    "status", "error",
//                    "message", e.getMessage()
//            );
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
//        }
//    }
//    @PostMapping("/login")
//    public ResponseEntity<Map<String, String>> Login(@RequestBody User user, HttpSession session) {
//        User customer = service.authenticateUser(user);
//
//        if (customer == null) {
//
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("status", "error", "message", "Wrong  user name or password!"));
//
//        }
//
//        session.setAttribute("user", user);
//        String role=customer.getRole().toString();
//        return ResponseEntity.ok(Map.of("status", "success", "message", "Login successful","Role",role));
//    }
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
       // user.setId(currentUser.getId());
        boolean updated = service.updateUserDetails(currentUser, user);

        if (updated) {
            session.setAttribute("user", currentUser);

            return ResponseEntity.ok(Map.of("status", "success", "message", "User details updated successfully"));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("status", "error", "message", "user name or password is empty"));
    }

}
