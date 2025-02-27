package com.group2.online_book_store.Service.BookService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Entity.book.bookDTO;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import com.group2.online_book_store.Repository.bookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class bookServiceImpl implements bookService {
    private final bookRepository repository;

    @Override
    public boolean removeBook(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        try {

            Book newBook = new Book(book);

            if (newBook.getBookDetail() != null) {
                newBook.getBookDetail().setBook(newBook);
            }

            repository.save(newBook);
            return true;
        } catch (Exception e) {
            System.out.println("Error adding book: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        return repository.findByTitleContaining(keyword);
    }

    @Override
    public List<Book> searchByType(Type type) {
        return repository.findByType(type);
    }

    public String getBookImage(Integer bookId) {
        Optional<Book> newBook = repository.findById(bookId);
        return newBook.map(Book::getImage).orElse(null);
    }

    public List<Book> getAllBooksInDescendingPriorityOrder() {
        return repository.findAllBooksOrderByPriorityDesc();
    }

    public bookDTO getBookDTO( Book book) {
        return bookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .image(book.getImage())
                .publishedDate(book.getPublishedDate())
                .type(book.getType())
                .build();
    }



    @Override
    public Book searchById(Integer id) {
        return repository.findById(id).orElse(null);
    }
    public boolean updateBook(Book updatedBook) {
        Optional<Book> existingBookOpt = repository.findById(updatedBook.getId());

        if (existingBookOpt.isPresent()) {
            Book existingBook = existingBookOpt.get();

            // Update book details
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setImage(updatedBook.getImage());
            existingBook.setPublishedDate(updatedBook.getPublishedDate());
            existingBook.setType(updatedBook.getType());

            // Ensure bookDetail is properly updated
            if (updatedBook.getBookDetail() != null) {
                if (existingBook.getBookDetail() == null) {
                    existingBook.setBookDetail(new BookDetail());
                }
                existingBook.getBookDetail().setDescription(updatedBook.getBookDetail().getDescription());
                existingBook.getBookDetail().setRating(updatedBook.getBookDetail().getRating());
            }

            repository.save(existingBook);
            return true;
        }
        return false;
    }
}