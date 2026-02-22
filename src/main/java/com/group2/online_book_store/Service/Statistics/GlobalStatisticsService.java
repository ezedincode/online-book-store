package com.group2.online_book_store.Service.Statistics;

import com.group2.online_book_store.Entity.statistics.GlobalStatistics;
import com.group2.online_book_store.Repository.GlobalStatisticsRepository;
import com.group2.online_book_store.Repository.bookRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GlobalStatisticsService {

    private final GlobalStatisticsRepository globalStatisticsRepository;
    private final bookRepository bookRepository;

    @PostConstruct
    public void init() {
        if (globalStatisticsRepository.count() == 0) {
            GlobalStatistics stats = GlobalStatistics.builder()
                    .totalBooks(bookRepository.count())
                    .totalDownloads(0)
                    .totalViews(0)
                    .build();
            globalStatisticsRepository.save(stats);
        } else {
            GlobalStatistics stats = globalStatisticsRepository.findAll().get(0);
            if (stats.getTotalBooks() == 0) {
                stats.setTotalBooks(bookRepository.count());
                globalStatisticsRepository.save(stats);
            }
        }
    }

    public GlobalStatistics getGlobalStatistics() {
        return globalStatisticsRepository.findAll().stream()
                .findFirst()
                .orElse(GlobalStatistics.builder()
                        .totalBooks(0)
                        .totalDownloads(0)
                        .totalViews(0)
                        .build());
    }

    public void incrementBooks() {
        globalStatisticsRepository.incrementBooks();
    }

    public void decrementBooks() {
        globalStatisticsRepository.decrementBooks();
    }

    public void incrementDownloads() {
        globalStatisticsRepository.incrementDownloads();
    }

    public void incrementViews() {
        globalStatisticsRepository.incrementViews();
    }
}
