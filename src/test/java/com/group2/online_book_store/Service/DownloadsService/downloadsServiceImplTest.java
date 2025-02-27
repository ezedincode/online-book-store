package com.group2.online_book_store.Service.DownloadsService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.user.Role;
import com.group2.online_book_store.Entity.user.Status;
import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.downloads.Downloads;
import com.group2.online_book_store.Repository.bookRepository;
import com.group2.online_book_store.Repository.downloadsRepository;
import com.group2.online_book_store.Service.UserService.userService;
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

class DownloadsServiceImplTest {

    @Mock
    private  downloadsRepository repository;
    @Mock
    private  bookRepository bookrepository;
    @Mock
    private  userService userService;

    @InjectMocks
    private downloadsServiceImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getDownloadById_WhenDownloadDoesNotExist_ReturnsNewDownload() {
        Integer downloadId = 1;
         when(repository.findById(downloadId)).thenReturn(Optional.empty());

         Downloads download=service.getDownloadById(downloadId);

         assertNotNull(download);

    }
    @Test
    void deleteDownloadById_WhenDownloadExist_CallsDelete() {
        Integer downloadId = 1;

        when(repository.existsById(downloadId)).thenReturn(true);
        service.deleteDownloadById(downloadId);

        verify(repository).deleteById(downloadId);

    }
    @Test
    void deleteDownloadById_WhenDownloadDoesNotExist_DoesNotCallDelete() {
        Integer downloadId = 1;
        when(repository.existsById(downloadId)).thenReturn(false);

        service.deleteDownloadById(downloadId);

        verify(repository, never()).deleteById(any());
    }
    @Test
    void saveDownload_WhenDownloadExist_CallsSave() {
        Integer User_id=1;
        Integer Book_id=1;
        Book book=new Book(
                1,
                "book title",
                "author",
                "url",
                "2/24/2025",
                Type.Academic,
                null,
                null
        );
        User user=new User(
                1,
                "name",
                "password",
                Role.User,
                "email@gmail",
                Status.Active,
                LocalDateTime.now(),
                null
        );
        when(bookrepository.findById(Book_id)).thenReturn(Optional.of(book));
        when(userService.getUserById(User_id)).thenReturn(user);

        service.saveDownload(Book_id,User_id);

        ArgumentCaptor<Downloads> downloadsCaptor = ArgumentCaptor.forClass(Downloads.class);

        verify(repository).save(downloadsCaptor.capture());
        Downloads saveDownloads=downloadsCaptor.getValue();

        assertEquals(book,saveDownloads.getBook());
        assertEquals(user,saveDownloads.getUser());
        assertNotNull(saveDownloads.getDate());
    }
    @Test
    void saveDownload_WhenBookDoesNotExist_ThrowsException() {
        Integer bookId = 1;
        Integer userId = 1;

        when(bookrepository.findById(bookId)).thenReturn(Optional.empty());

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                service.saveDownload(bookId, userId)
        );

        assertEquals("Book not found", exception.getMessage());
        verify(repository, never()).save(any(Downloads.class));
    }


}