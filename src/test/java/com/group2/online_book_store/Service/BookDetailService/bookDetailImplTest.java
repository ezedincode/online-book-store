package com.group2.online_book_store.Service.BookDetailService;

import com.group2.online_book_store.Entity.bookDetail.BookDetail;
import com.group2.online_book_store.Repository.bookDetailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BookDetailImplTest  {
    @Mock
    private bookDetailRepository repository;

    @InjectMocks
    private bookDetailImpl service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void incrementDownloadCount_whenBookDetailExist_incrementDownloadCount(){
        Integer bookDetailId = 1;

        BookDetail bookDetail = new BookDetail(
                1,
                3,
                "description",
                2.3,
                3,
                null
        );
        when(repository.findById(bookDetailId)).thenReturn(Optional.of(bookDetail));

        Integer actual_downloadCount=bookDetail.getDownloadCount() + 1;

        service.incrementDownloadCount(bookDetailId);

        assertEquals(actual_downloadCount,bookDetail.getDownloadCount());

        verify(repository).save(bookDetail);


    }
    @Test
    void incrementDownloadCount_whenBookDetailDoesNotExist_doNothing(){
        Integer bookDetailId = 1;

        when(repository.findById(bookDetailId)).thenReturn(Optional.empty());

        service.incrementDownloadCount(bookDetailId);

        verify(repository,never()).save(any(BookDetail.class));
    }
}