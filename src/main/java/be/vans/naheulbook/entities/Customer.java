package be.vans.naheulbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class User extends BaseEntity<Integer>{
    @Column(nullable = false, unique = true)
    private String pseudo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String mail;
}
