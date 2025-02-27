package com.group2.online_book_store.Service.BookDetailService;

import com.group2.online_book_store.Entity.bookDetail.BookDetail;

public interface bookDetailService {

    void incrementDownloadCount(Integer bookId);
    BookDetail getBookDetail(Integer bookId);
}
