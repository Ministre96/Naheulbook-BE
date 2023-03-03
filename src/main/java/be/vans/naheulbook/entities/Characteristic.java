package be.vans.naheulbook.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Characteristic extends BaseEntity<Integer>{

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CharacteristicName name;

    @Column(nullable = false)
    private int value;
}
