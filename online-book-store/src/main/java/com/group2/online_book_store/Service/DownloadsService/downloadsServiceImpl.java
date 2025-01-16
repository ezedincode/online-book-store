package com.group2.online_book_store.Service.DownloadsService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.downloads.Downloads;
import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Repository.bookRepository;
import com.group2.online_book_store.Repository.downloadsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class downloadsServiceImpl implements downloadsService {

    private final downloadsRepository repository;
    private final bookRepository bookrepository;
    @PersistenceContext
    private EntityManager entityManager;


    public downloadsServiceImpl(downloadsRepository repository , bookRepository bookrepository) {
        this.repository = repository;
        this.bookrepository = bookrepository;

    }

    @Override
    public List<Downloads> getAllDownloads() {
        return repository.findAll();
    }

    @Override
    public Downloads getDownloadById(Integer id) {
        return repository.findById(id).orElse(new Downloads());
    }

    @Override
    public Downloads getDownloadByUserId(Integer UserId) {
        return repository.findByUser_Id(UserId);
    }

    @Override
    public void deleteDownloadById(Integer id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
        System.out.println("download not found!");
    }

    @Override
    public void deleteDownloadByUserId(Integer UserId) {
        repository.deleteByUserId(UserId);
    }

    @Override
    @Transactional
    public void saveDownload(User user, Integer bookId) {

        Book book = bookrepository.findById(bookId)
                .orElse(null);

        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

        if (!entityManager.contains(user)) {
            user = entityManager.merge(user);
        }

        Downloads newDownload = new Downloads();
        newDownload.setBook(book);
        newDownload.setUser(user);
        newDownload.setDate(LocalDate.now());

        repository.save(newDownload);
    }

}
