package be.vans.lemaggistral.temp;

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
public class Characteristic extends BaseEntity<Integer>{

    @Column(nullable = false)
    private CharacteristicName name;

    @Column(nullable = false)
    private int value;
}
