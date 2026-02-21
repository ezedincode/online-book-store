package com.group2.online_book_store.Service.Statistics;

import com.group2.online_book_store.Entity.statistics.book_metrics;
import com.group2.online_book_store.Entity.statistics.GlobalStatistics;
import com.group2.online_book_store.Repository.bookMetricsRepository;
import com.group2.online_book_store.Repository.bookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GlobalStatisticsService {

    private final bookRepository bookRepository;
    private final bookMetricsRepository metricsRepository;

    public GlobalStatistics getGlobalStatistics() {
        long totalBooks = bookRepository.count();
        List<book_metrics> allMetrics = metricsRepository.findAll();

        long totalDownloads = allMetrics.stream()
                .mapToLong(book_metrics::getTotal_downloads)
                .sum();

        long totalViews = allMetrics.stream()
                .mapToLong(book_metrics::getTotal_view)
                .sum();

        return GlobalStatistics.builder()
                .totalBooks(totalBooks)
                .totalDownloads(totalDownloads)
                .totalViews(totalViews)
                .build();
    }
}
