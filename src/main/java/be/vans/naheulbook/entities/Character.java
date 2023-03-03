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
public class Character extends BaseEntity<Integer>{
    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexe sexe;

    @Column(nullable = false)
    private int gold;

    @Column(nullable = false)
    private int fate;

    @OneToMany
    private List<Characteristic> stats;

    @ManyToMany()
    private List<Equipment> equipmentList;

    @ManyToOne()
    private Job job;

    @ManyToOne()
    private Origin origin;

    @ManyToMany()
    private List<Skill> skills;

    @ManyToOne()
    private Customer creator;

    @ManyToMany()
    private List<Customer> subsribers;

}
