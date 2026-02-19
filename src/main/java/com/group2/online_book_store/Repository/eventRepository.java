package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.event.book_event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface eventRepository extends JpaRepository<book_event,Long> {

}
