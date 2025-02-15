package com.group2.online_book_store.Service.BookService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import com.group2.online_book_store.Repository.bookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class bookServiceImpl implements bookService {
    private final bookRepository repository;

    public bookServiceImpl(bookRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean removeBook(Book book) {
        if (repository.existsById(book.getId())) {
            repository.deleteById(book.getId());
            return true;
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        try {
            Book newbook = new Book(book);
            repository.save(newbook);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        Optional<Book> newbook = repository.findById(bookId);
        return newbook.map(Book::getImage).orElse(null);
    }

    public List<Book> getAllBooksInDescendingPriorityOrder() {
        return repository.findAllBooksOrderByPriorityDesc();
    }

}