package be.vans.naheulbook.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Customer extends BaseEntity<Integer>{
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
}
