package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.statistics.book_metrics;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface bookMetricsRepository extends JpaRepository<book_metrics,Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE book_metrics b SET b.total_downloads = b.total_downloads + 1 WHERE b.book.id = :id")
    void IncrementDownload(@Param("id") Integer bookId);

    @Modifying
    @Transactional
    @Query("UPDATE book_metrics b SET b.total_view = b.total_view + 1 WHERE b.book.id = :id")
    void IncrementView(@Param("id") Integer bookId);


    boolean existsByBookId(Integer bookId);
}
