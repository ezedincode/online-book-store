package com.group2.online_book_store.Service.UserService;

import com.group2.online_book_store.Entity.user.Status;
import com.group2.online_book_store.Entity.user.User;

import java.util.List;

public interface userService {
    public List<User> getAllUsers();

    public User getUserByUserName(String username);

    public User getUserById(Integer id);

    public boolean removeUser(User theCustomer);

    public boolean setAdmin(User theuser);

    public boolean setStatus(User theuser, Status status);

    public void registerUser(String email, String password,String userName);

    public User authenticateUser (User user);

    public boolean updateUserDetails(User currentUser, User user);

}
