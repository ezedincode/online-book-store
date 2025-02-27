package com.group2.online_book_store.Service.UserService;

import com.group2.online_book_store.Entity.downloads.Downloads;
import com.group2.online_book_store.Entity.user.Role;
import com.group2.online_book_store.Entity.user.Status;
import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Repository.userRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    @Mock
    private  userRepository repository;

    @InjectMocks
    private  userServiceImpl service;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void removeUser_WhenUserExist_ReturnTrue() {
        User user = new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        when(repository.existsById(user.getId())).thenReturn(true);

        boolean result = service.removeUser(user);
        assertTrue(result);
        verify(repository).deleteById(user.getId());

    }
    @Test
    void removeUser_WhenUserDoesNotExist_ReturnFalse() {
        User user = new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        when(repository.existsById(user.getId())).thenReturn(false);

        boolean result = service.removeUser(user);
        assertFalse(result);
        verify(repository,never()).deleteById(user.getId());

    }
    @Test
    void setAdmin_userExist_ReturnTrue() {
        User user = new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        when(repository.findById(user.getId())).thenReturn(Optional.of(user));

        boolean result=service.setAdmin(user);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        assertTrue(result);

        verify(repository).save(userCaptor.capture());

        User savedUser =userCaptor.getValue();

        assertEquals(Role.Admin, savedUser.getRole());
    }
    @Test
    void setAdmin_userDoesNotExist_ReturnFalse() {
        User user = new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        when(repository.findById(user.getId())).thenReturn(Optional.empty());

        boolean result=service.setAdmin(user);

        assertFalse(result);

        verify(repository,never()).save(any(User.class));
    }

    @Test
    void setStatus_userExist_ReturnTrue() {
        User user = new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        Status status = Status.Active;
        when(repository.findById(user.getId())).thenReturn(Optional.of(user));

        boolean result=service.setStatus(user,status);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);

        assertTrue(result);

        verify(repository).save(userCaptor.capture());

        User savedUser =userCaptor.getValue();

        assertEquals(status, savedUser.getStatus());
    }
    @Test
    void setStatus_userDoesNotExist_ReturnFalse() {
        User user = new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        Status status = Status.Active;
        when(repository.findById(user.getId())).thenReturn(Optional.empty());

        boolean result=service.setStatus(user,status);

        assertFalse(result);

        verify(repository,never()).save(any(User.class));
    }

    @Test
    void updateUserDetails_WhenUserNameAndPasswordExistsAndEmailIsUniq_ReturnTrue() {
        User currentUser = new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        User user = new User(
                1,
                "updateName",
                "updatePassword",
                Role.User,
                "updatedemail@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );

        when(repository.existsByEmail(user.getEmail())).thenReturn(false);
        boolean result = service.updateUserDetails(currentUser,user);
        assertTrue(result);
        assertEquals(user.getUsername(),currentUser.getUsername());
        assertEquals(user.getPassword(),currentUser.getPassword());
        assertEquals( user.getEmail(),currentUser.getEmail());

        verify(repository).save(currentUser);

    }
    @Test
    void updateUserDetails_WhenUserNameAndPasswordExistsAndEmailIsNotUniq_ReturnFalse() {
        User currentUser = new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        User user = new User(
                1,
                "updateName",
                "updatePassword",
                Role.User,
                "updatedemail@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );

        when(repository.existsByEmail(user.getEmail())).thenReturn(true);
        boolean result = service.updateUserDetails(currentUser,user);
        assertFalse(result);

        verify(repository,never()).save(currentUser);

    }
}