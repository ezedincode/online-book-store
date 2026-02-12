package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface bookDetailRepository extends JpaRepository<BookDetail,Integer> {
    BookDetail findByBookId(Integer bookId);


}
