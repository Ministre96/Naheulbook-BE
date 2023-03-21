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

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAddForm {
    @NotBlank(message = "errors.notBlank")
    private String name;
    private String description;
    private List<Characteristic> requierement;
    private List<Origin> bannedOrigin = new ArrayList<>();
    private List<Skill> heritatedSkill = new ArrayList<>();
    private List<Skill> skillToChoose = new ArrayList<>();

    public Job toBll(){
        return Job.builder()
                .name(name)
                .description(description)
                .requierement(requierement)
                .heritatedSkill(heritatedSkill)
                .skillToChoose(skillToChoose)
                .bannedOrigin(bannedOrigin)
                .build();
    }
}
