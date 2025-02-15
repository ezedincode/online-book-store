package com.group2.online_book_store.Entity.user;

import com.group2.online_book_store.Entity.downloads.Downloads;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="app_user")
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique=true)
    private String userName;

    private String password;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Role role=Role.User;



    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Status status=Status.Active;

    @Column(nullable = false, updatable = false)
    @Builder.Default
    private LocalDateTime created=LocalDateTime.now();


    @OneToMany(mappedBy = "user",orphanRemoval = true)
    private List<Downloads> downloads;

}
