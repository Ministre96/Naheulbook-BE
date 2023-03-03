package be.vans.naheulbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Job extends BaseEntity<Integer> {

    @Column(nullable = false)
    private String name;

    private String desription;

    @ManyToMany()
    private List<Characteristic> requierement;
}
