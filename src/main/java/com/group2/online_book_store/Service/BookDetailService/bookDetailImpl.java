package com.group2.online_book_store.Service.BookDetailService;

import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import com.group2.online_book_store.Repository.bookDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class bookDetailImpl implements bookDetailService{
    private final bookDetailRepository repository;
    public bookDetailImpl(bookDetailRepository repository) {
        this.repository = repository;
    }


    @Override

    public void incrementDownloadCount(Integer bookId) {

        BookDetail bookDetail = repository.findById(bookId).orElse(null);
        if (bookDetail!= null) {
            bookDetail.setDownloadCount(bookDetail.getDownloadCount() + 1);
            bookDetail.setPriority(bookDetail.calculatePriority());
            repository.save(bookDetail);
        }

        }

    @Override
    public BookDetail getBookDetail(Integer bookId) {
        return repository.findById(bookId).orElse(null);
    }

}

