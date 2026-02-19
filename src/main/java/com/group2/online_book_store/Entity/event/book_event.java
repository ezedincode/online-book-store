package com.group2.online_book_store.Entity.event;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class book_event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    private Book book_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private eventType event;

    @Builder.Default
    private LocalDateTime  event_time = LocalDateTime.now();

}
