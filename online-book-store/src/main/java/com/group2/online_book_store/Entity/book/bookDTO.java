package com.group2.online_book_store.Entity.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class bookDTO {

        private Integer id;
        private String title;
        private String author;
        private String image;
        private LocalDate publishedDate;
        private Type type;


}
