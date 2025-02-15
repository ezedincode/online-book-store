package com.group2.online_book_store.Service.BookDetailService;

import com.group2.online_book_store.Entity.bookDetail.BookDetail;

public interface bookDetailService {

    public void incrementDownloadCount(Integer bookId);
    public BookDetail getBookDetail(Integer bookId);
}
