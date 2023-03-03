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
public class Origin extends BaseEntity<Integer>{
    @Column(nullable = false)
    private String name;

    private String desription;
}
