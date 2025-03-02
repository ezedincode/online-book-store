package com.group2.online_book_store.Service.UserService;

import com.group2.online_book_store.Entity.user.Role;
import com.group2.online_book_store.Entity.user.Status;
import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Repository.userRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class userServiceImpl implements userService{
    private final userRepository userRepository;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public User getUserByUserName(String username){
        return userRepository.findByusername(username);
    }
    @Override
    public User getUserById(Integer id){
        return userRepository.findById(id)
                .orElse(new User());
    }


    @Override
    public boolean removeUser(User theUser){
        if(userRepository.existsById(theUser.getId())){
            userRepository.deleteById(theUser.getId());
            return  true;
        }

        return false;
    }
    @Override
    public boolean setAdmin(User theUser){
        Optional<User> optionalUser= userRepository.findById(theUser.getId());
        if(optionalUser.isPresent()){
            User userToUpdate = optionalUser.get();
            userToUpdate.setRole(Role.Admin);
            userRepository.save(userToUpdate);
            return true;
        }
        return false;
    }
    @Override
    public  boolean setStatus(User theuser, Status status){
        Optional<User> optionalUser= userRepository.findById(theuser.getId());

        if(optionalUser.isPresent()){
            User userToUpdate = optionalUser.get();
            userToUpdate.setStatus(status);
            userRepository.save(userToUpdate);
            return true;
        }
        return false;
    }
    @Override
    public void registerUser(String email, String password, String userName) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists. Please use a different one.");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(userName);
        userRepository.save(user);
    }

    @Override
    public User authenticateUser(User user) {

        User existingUser  = userRepository.findByusername(user.getUsername());

        if (existingUser  != null && existingUser .getPassword().equals(user.getPassword())) {

            return existingUser ;
        }
        return null;
    }
    @Override
    public boolean updateUserDetails(User currentUser, User user) {
        if (user.getUsername() != null && !user.getUsername().isEmpty()) {
            currentUser.setUsername(user.getUsername());
        }

        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            currentUser.setPassword(user.getPassword());
        }


        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
           if(!user.getEmail().equals(currentUser.getEmail())){
               if(userRepository.existsByEmail(user.getEmail())){
                   return false;
               }
           }
            currentUser.setEmail(user.getEmail());
        }

        userRepository.save(currentUser);
        return true;
    }
    public int enableAppUser(String email) {
        return userRepository.enableAppUser(email);
    }

}

