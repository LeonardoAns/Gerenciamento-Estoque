package com.estudoDeCaso.shopp.entities;

import com.estudoDeCaso.shopp.entities.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.bytecode.enhance.spi.EnhancementInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String password;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime birthDate;
    private Double wage;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Sale> sales;

    @Enumerated(EnumType.STRING)
    private List<Roles> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (roles != null && !roles.isEmpty()) {
            if (roles.contains(Roles.MANAGEMENT)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_MANAGEMENT"));
                authorities.add(new SimpleGrantedAuthority("ROLE_SALES"));
                authorities.add(new SimpleGrantedAuthority("ROLE_STOCK"));
            } else if (roles.contains(Roles.SALES)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_SALES"));
            } else if (roles.contains(Roles.STOCK)) {
                authorities.add(new SimpleGrantedAuthority("ROLE_STOCK"));
            }
        }

        return authorities;
    }



    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
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
