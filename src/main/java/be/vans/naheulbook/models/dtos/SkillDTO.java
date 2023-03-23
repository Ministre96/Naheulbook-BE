package be.vans.naheulbook.models.dtos;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.models.entities.Skill;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SkillDTO {

    private int id;
    private String name;

    private String description;

    public static SkillDTO toDTO(Skill skill) {
        SkillDTO.SkillDTOBuilder dto = SkillDTO.builder();
        return dto
                .id(skill.getId())
                .name(skill.getName())
                .description(skill.getDescription())
                .build();
    }

}
