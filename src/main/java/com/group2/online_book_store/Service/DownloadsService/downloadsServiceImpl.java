package com.group2.online_book_store.Service.DownloadsService;

import com.group2.online_book_store.Entity.book.Book;
import com.group2.online_book_store.Entity.downloads.Downloads;
import com.group2.online_book_store.Entity.user.User;
import com.group2.online_book_store.Repository.bookRepository;
import com.group2.online_book_store.Repository.downloadsRepository;
import com.group2.online_book_store.Service.UserService.userService;
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
    private final com.group2.online_book_store.Service.UserService.userService userService;
    @PersistenceContext
    private EntityManager entityManager;


    public downloadsServiceImpl(downloadsRepository repository , bookRepository bookrepository, userService userService) {
        this.repository = repository;
        this.bookrepository = bookrepository;
        this.userService = userService;
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
    public void saveDownload(Integer id, Integer user_id) {

        Book book = bookrepository.findById(id)
                .orElse(null);

        if (book == null) {
            throw new IllegalArgumentException("Book not found");
        }

//        if (!entityManager.contains(user)) {
//            user = entityManager.merge(user);
//        }

        Downloads newDownload = new Downloads();
        newDownload.setBook(book);
        newDownload.setUser(userService.getUserById(user_id));
        newDownload.setDate(LocalDate.now());

        repository.save(newDownload);
    }

}
