package com.group2.online_book_store.Entity.downloads;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Downloads {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate date;

    private int download_count;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    @JsonIgnoreProperties("downloads")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="book_id")
    @JsonBackReference
    private Book book;


}
