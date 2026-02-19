package com.group2.online_book_store.Service.Event;

import com.group2.online_book_store.Entity.event.book_event;
import com.group2.online_book_store.Repository.eventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class bookEventService {
    private final eventRepository repository;

    public void save (book_event event) {
        repository.save(event);
    }
}
