package be.vans.naheulbook.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany(targetEntity = Skill.class)
    private List<Skill> heritatedSkill;

    @ManyToMany(targetEntity = Skill.class)
    private List<Skill> skillToChose;

    @ManyToMany()
    private List<Origin> bannedOrigin;
}
