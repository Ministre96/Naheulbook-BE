package be.vans.naheulbook.models.entities;

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
public class Equipment extends BaseEntity<Integer>{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int Price;

    private String description;
}
