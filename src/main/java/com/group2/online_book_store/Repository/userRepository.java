package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface userRepository extends JpaRepository<User,Integer> {
    User findByUsername(String userName);
    boolean existsByEmail(String email);
    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.status = 'Active' WHERE a.email = ?1")
    int enableAppUser(String email);

}
