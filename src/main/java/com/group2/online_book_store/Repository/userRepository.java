package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Integer> {
    User findByuserName(String userName);
    boolean existsByEmail(String email);

}
