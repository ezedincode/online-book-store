package com.group2.online_book_store.Service.BookService;

import com.group2.online_book_store.Entity.book.*;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import com.group2.online_book_store.Repository.bookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class BookServiceImplTest {
    @Mock
    private bookRepository repository;
    @InjectMocks
    private bookServiceImpl Service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void shouldMapBookToBookDTO() {
        Book book = new Book(
                1,
                "book title",
                "author",
                "url",
                "2/24/2025",
                Type.Academic,
                null,
                null
        );
        bookDTO dto=Service.getBookDTO(book);
        assertEquals(book.getId(),dto.getId());
        assertEquals(book.getTitle(),dto.getTitle());
        assertEquals(book.getAuthor(),dto.getAuthor());
        assertEquals(book.getImage(),dto.getImage());
        assertEquals(book.getType(),dto.getType());
        assertEquals(book.getPublishedDate(),dto.getPublishedDate());

    }

    @Test
    void removeBook_WhenBookExists_ShouldReturnTrue() {
        int bookId = 1;
        when(repository.existsById(bookId)).thenReturn(true);

        boolean result = Service.removeBook(bookId);

        assertTrue(result);
        verify(repository).deleteById(bookId);
    }
    @Test
    void removeBook_WhenBookDoesNotExist_ShouldReturnFalse() {
        int bookId = 1;
        when(repository.existsById(bookId)).thenReturn(false);

        boolean result = Service.removeBook(bookId);
        assertFalse(result);
        verify(repository,never()).deleteById(anyInt());
    }
    @Test
    void addBook_WhenValidBook_ShouldReturnTrue(){
        Book book = new Book();

        book.setBookDetail(new BookDetail());

        when(repository.save(any(Book.class))).thenReturn(book);
        boolean result = Service.addBook(book);

        assertTrue(result);
        verify(repository).save(any(Book.class));

    }
    @Test
    void addBook_WhenBookHasNoDetail_ShouldReturnTrue(){
        Book book = new Book();

        when(repository.save(any(Book.class))).thenReturn(book);
        boolean result = Service.addBook(book);

        assertTrue(result);
        verify(repository).save(any(Book.class));

    }
    @Test
    void getBookImage_whenBookExists_ShouldReturnImage(){
        Integer bookId = 1;
        String expectedImage = "image.png";
        Book newBook = new Book();
        newBook.setImage(expectedImage);
        when(repository.findById(bookId)).thenReturn(Optional.of(newBook));
        String result= Service.getBookImage(bookId);

        assertEquals(expectedImage,result);

        verify(repository).findById(bookId);

    }
    @Test
    void getBookImage_whenBookDoesNotExists_ShouldReturnNull(){
        Integer bookId = 1;

        when(repository.findById(bookId)).thenReturn(Optional.empty());
        String result= Service.getBookImage(bookId);

        assertNull(result);

        verify(repository).findById(bookId);

    }
    @Test
    void updateBook_WhenBookExists_ShouldReturnTrue(){
        Integer bookId = 1;

        Book book = new Book(
                1,
                "book title",
                "author",
                "url",
                "2/24/2025",
                Type.Academic,
                null,
                null
        );

        when(repository.findById(bookId)).thenReturn(Optional.of(book));

        boolean result = Service.updateBook(book);
        assertTrue(result);
        verify(repository).findById(bookId);
        verify(repository).save(book);

    }
    @Test
    void updateBook_WhenBookDoesNotExist_ShouldReturnFalse(){
        Integer bookId = 1;
        Book book = new Book(
                1,
                "book title",
                "author",
                "url",
                "2/24/2025",
                Type.Academic,
                null,
                null
        );
        when(repository.findById(bookId)).thenReturn(Optional.empty());

        boolean result=Service.updateBook(book);
        assertFalse(result);
        verify(repository).findById(bookId);
        verify(repository, never()).save(book);
    }
}