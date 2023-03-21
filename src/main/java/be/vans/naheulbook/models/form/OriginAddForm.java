package be.vans.naheulbook.models.form;

import be.vans.naheulbook.models.entities.Characteristic;
import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.models.entities.Skill;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OriginAddForm {

    @NotBlank(message = "errors.notBlank")
    private String name;
    @NotBlank(message = "errors.notBlank")
    private String description;
    private List<Characteristic> requierements;
    private List<Skill> heritatedSkill;
    private List<Skill> skillToChoose;
    public Origin toBll(){
        return Origin.builder()
                .name(name)
                .description(description)
                .requierements(requierements)
                .heritatedSkill(heritatedSkill)
                .skillToChoose(skillToChoose)
                .build();
    }
}
