package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.statistics.GlobalStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GlobalStatisticsRepository extends JpaRepository<GlobalStatistics, Long> {
}
