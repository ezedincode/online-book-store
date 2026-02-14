package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.book.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface bookRepository extends JpaRepository<Book,Integer> {

    Page<Book> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);



    List<Book> findByType(Type type);

    @Query("SELECT b FROM Book b JOIN b.bookDetail c ORDER BY c.priority DESC, b.id ASC")
    Page<Book> findAllBooksOrderByPriorityDesc(Pageable pageable);
}
