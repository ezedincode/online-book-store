package com.group2.online_book_store.Service.Statistics;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.statistics.book_event;
import com.group2.online_book_store.Entity.statistics.book_metrics;
import com.group2.online_book_store.Entity.statistics.eventType;
import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Repository.bookMetricsRepository;
import com.group2.online_book_store.Repository.bookRepository;
import com.group2.online_book_store.Repository.eventRepository;
import com.group2.online_book_store.Repository.userRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class bookEventService {
    private final eventRepository repository;
    private final userRepository userRepository;
    private final bookRepository bookRepository;
    private final bookMetricsRepository metricsRepository;

    @Transactional
    public void save (Authentication authentication, eventType type, String filename) {

        User user = userRepository.findByUsername(authentication.getName());
        Integer userId = user.getId();
        Book book = bookRepository.findByStorageUrl(filename);
        Integer bookId = book.getId();
       book_event bookEvent= book_event.builder()
                .event(type)
                .book_id(bookId)
                .user_id(userId)
                .build();

       repository.save(bookEvent);
       if(!metricsRepository.existsByBookId(bookId)){
           book_metrics metrics = new book_metrics();
           metrics.setBook(bookRepository.findById(bookId).orElse(null));
           metricsRepository.save(metrics);
       }
       if(type == eventType.DOWNLOAD){
           metricsRepository.IncrementDownload(bookId);
       } else if (type == eventType.VIEW) {
           metricsRepository.IncrementView(bookId);
       }

    }
    public List<book_metrics> getAllBookEvent() {
        List<book_metrics> events = new ArrayList<>();
        events = metricsRepository.findAll();
        return events;
    }
}
