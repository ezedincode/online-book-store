package com.group2.online_book_store.Service.confirmation;

import com.group2.online_book_store.Entity.confirmation.ConfirmationToken;
import com.group2.online_book_store.Repository.confirmationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class confirmationServiceImpl {
    private final confirmationRepository repository;

    public void SaveConfirmationToken(ConfirmationToken token) {
        repository.save(token);
    }
    public int setConfirmedAt(String token) {
        return repository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
    public Optional<ConfirmationToken> getToken(String token) {
        return repository.findByToken(token);
    }

}
