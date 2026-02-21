package com.group2.online_book_store.Entity.statistics;

import com.group2.online_book_store.Entity.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class book_metrics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(optional = true)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Builder.Default
    private int total_view = 0 ;

    private int total_downloads = 0;

    @Builder.Default
    private LocalDateTime created_at = LocalDateTime.now();
}
