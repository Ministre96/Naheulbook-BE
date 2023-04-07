package be.vans.naheulbook.models.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Customer extends BaseEntity<Integer> implements UserDetails {
    @Column(nullable = false, unique = true)
    private String pseudo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String mail;

    @OneToMany()
    private List<Character> characters;

    @ManyToMany(targetEntity = Customer.class)
    private List<Character> subsribe;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return pseudo;
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
