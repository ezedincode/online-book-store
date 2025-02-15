package com.group2.online_book_store.Entity.bookDetail;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.group2.online_book_store.Entity.book.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int rating;

    private  String  description;

    private  double priority;
    @Column(nullable = false, columnDefinition = "integer default 0")
    @JsonIgnoreProperties("bookDetail")
    private  int downloadCount;

    @OneToOne
    @JsonBackReference
    private Book book;
    @Transient
    public double calculatePriority() {
        return 0.3 * downloadCount + 0.7 * rating; }
}
