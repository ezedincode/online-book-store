package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.statistics.book_event;
import com.group2.online_book_store.dto.DailyDownloadStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface eventRepository extends JpaRepository<book_event,Long> {

    @Query(value = "SELECT CAST(event_time AS date) as event_date, COUNT(*) as count " +
           "FROM book_event " +
           "WHERE event = 'DOWNLOAD' " +
           "GROUP BY CAST(event_time AS date) " +
           "ORDER BY event_date ASC", nativeQuery = true)
    List<Object[]> getDailyDownloads();
}
