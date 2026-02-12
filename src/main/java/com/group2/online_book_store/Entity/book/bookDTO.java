package com.group2.online_book_store.Entity.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class bookDTO {

        private Integer id;
        private String title;
        private String author;
        private String image;
        private String publishedDate;
        private String description;
        private Type type;


}
