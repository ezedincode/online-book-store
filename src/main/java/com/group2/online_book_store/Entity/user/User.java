package com.group2.online_book_store.Entity.user;

import com.group2.online_book_store.Entity.downloads.Downloads;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="app_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique=true)
    private String username;

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

            return this.status == Status.Active || this.status == Status.NOTActive; // Allow NOTActive users


    }
}
