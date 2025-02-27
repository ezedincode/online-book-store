package com.group2.online_book_store.Repository;

import com.group2.online_book_store.Entity.downloads.Downloads;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface downloadsRepository extends JpaRepository<Downloads,Integer> {
    Downloads findByBookId(Integer userId);

    Downloads findByUser_Id(Integer userId);
    @Modifying
    @Transactional
    @Query("delete from Downloads d where d.user.id = :userId")
    void deleteByUserId(Integer userId);


}
