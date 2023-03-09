package com.aston.internship.entity;

import com.aston.internship.dto.AppRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Collection;

@AllArgsConstructor
@Data
@Entity
public class Details implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @Size(min=5, message = "Не меньше 5 знаков")
    private String username;
    @Size(min=5, message = "Не меньше 5 знаков")
    private String password;

    private String phone;
    private String email;
    @Enumerated(EnumType.STRING)
    private AppRole role;

    @OneToOne(mappedBy = "details")
    private Customer customer;

    @OneToOne(mappedBy = "details")
    private Producer producer;

    public Details() {
    }

    public Details(String name, String surname, String username, String password, String phone, String email, AppRole role) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.role = role;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
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
        return true;
    }
}
