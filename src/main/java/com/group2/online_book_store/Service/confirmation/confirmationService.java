package com.group2.online_book_store.Service.confirmation;


import com.group2.online_book_store.Entity.confirmation.ConfirmationToken;

import java.util.Optional;

public interface confirmationService  {
    void SaveConfirmationToken(ConfirmationToken token);

    int setConfirmedAt(String token);

    Optional<ConfirmationToken> getToken(String token);
}
