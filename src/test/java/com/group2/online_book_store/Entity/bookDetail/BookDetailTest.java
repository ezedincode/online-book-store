package com.group2.online_book_store.Entity.bookDetail;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookDetailTest {

    @Test
    void calculatePriority_ShouldReturnCorrectValue() {
        BookDetail bookDetail = BookDetail.builder()
                .rating(5)
                .downloadCount(10)
                .build();

        System.out.println("Download Count: " + bookDetail.getDownloadCount());
        System.out.println("Rating: " + bookDetail.getRating());

        double expectedPriority = 0.3 * 10 + 0.7 * 5; // 6.5
        assertEquals(expectedPriority, bookDetail.calculatePriority(), 0.01);
    }

}