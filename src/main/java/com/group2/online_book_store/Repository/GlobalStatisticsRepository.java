package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.statistics.GlobalStatistics;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalStatisticsRepository extends JpaRepository<GlobalStatistics, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE GlobalStatistics g SET g.totalBooks = g.totalBooks + 1")
    void incrementBooks();

    @Modifying
    @Transactional
    @Query("UPDATE GlobalStatistics g SET g.totalDownloads = g.totalDownloads + 1")
    void incrementDownloads();

    @Modifying
    @Transactional
    @Query("UPDATE GlobalStatistics g SET g.totalViews = g.totalViews + 1")
    void incrementViews();
}
