package be.vans.naheulbook.models.dtos;

import be.vans.naheulbook.models.entities.Character;
import be.vans.naheulbook.models.entities.Characteristic;
import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.models.entities.Skill;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OriginDTO {
    private int id;
    private String name;

    private String description;

    private List<Characteristic> requierements;

    private List<Skill> heritatedSkill;

    private List<Skill> skillToChose;

    public static OriginDTO toDTO(Origin origin) {
        OriginDTO.OriginDTOBuilder dto = OriginDTO.builder();
        return dto
                .id(origin.getId())
                .name(origin.getName())
                .description(origin.getDesription())
                .requierements(origin.getRequierements())
                .heritatedSkill(origin.getHeritatedSkill())
                .skillToChose(origin.getSkillToChose())
                .build();
    }
}
