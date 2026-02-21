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


    private Integer book_id;


    private Integer user_id;

    @Enumerated(EnumType.STRING)
    private eventType event;

    @Builder.Default
    private LocalDateTime  event_time = LocalDateTime.now();

}
