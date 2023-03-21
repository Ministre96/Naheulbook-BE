package be.vans.naheulbook.models.form;

import be.vans.naheulbook.models.entities.Skill;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillAddForm {

    @NotBlank(message = "errors.notBlank")
    private String name;
    @NotBlank(message = "errors.notBlank")
    private String description;

    public Skill toBll(){
        return Skill.builder()
                .name(name)
                .description(description)
                .build();
    }
}
