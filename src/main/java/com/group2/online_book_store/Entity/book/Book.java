package com.group2.online_book_store.Entity.book;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import com.group2.online_book_store.Entity.downloads.Downloads;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "book",schema = "public")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    private String author;
    @Column(length=11500)
    private String image;

    private String publishedDate;

    @Enumerated(EnumType.STRING)
    private Type type;

    public Book(Book oldBook){
        this.id = oldBook.getId();
        this.title = oldBook.getTitle();
        this.author = oldBook.getAuthor();
        this.image = oldBook.getImage();
        this.publishedDate = oldBook.getPublishedDate();
        this.type = oldBook.getType();
        this.bookDetail=oldBook.getBookDetail();
        this.downloads=oldBook.getDownloads();

    }

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Downloads> downloads;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book_Detail_id")
    @JsonManagedReference
    private BookDetail bookDetail;


}
