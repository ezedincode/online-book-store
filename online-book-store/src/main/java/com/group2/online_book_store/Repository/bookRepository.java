package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface bookRepository extends JpaRepository<Book,Integer> {
    @Query(value = "SELECT * FROM book WHERE LOWER(title) LIKE LOWER(concat('%',:keyword, '%'))", nativeQuery = true)
    List<Book> findByTitleContaining(String keyword);


    List<Book> findByType(Type type);

    @Query("SELECT b FROM Book b JOIN b.bookDetail c ORDER BY c.priority DESC")
    List<Book> findAllBooksOrderByPriorityDesc();
}
