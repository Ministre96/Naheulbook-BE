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
public class Character extends BaseEntity<Integer>{
    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private Sexe sexe;

    @Column(nullable = false)
    private int gold;

    @Column(nullable = false)
    private int fate;

}
