package com.group2.online_book_store.Service.UserService;

import com.group2.online_book_store.Entity.user.Status;
import com.group2.online_book_store.Entity.user.User;

import java.util.List;

public interface userService {
     List<User> getAllUsers();

     User getUserByUserName(String username);

     User getUserById(Integer id);

     boolean removeUser(User theCustomer);

     boolean setAdmin(User theuser);

     boolean setStatus(User theuser, Status status);

     void registerUser(String email, String password,String userName);

     User authenticateUser (User user);

     boolean updateUserDetails(User currentUser, User user);

}
