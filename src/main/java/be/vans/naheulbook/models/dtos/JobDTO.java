package be.vans.naheulbook.models.dtos;

import be.vans.naheulbook.models.entities.Characteristic;
import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.models.entities.Skill;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JobDTO {

    private String name;

    private String description;

    private List<Characteristic> requierement;

    private List<Skill> heritatedSkill;

    private List<Skill> skillToChoose;

    private List<Origin> bannedOrigin;

    public static JobDTO toDTO(Job job) {
        JobDTO.JobDTOBuilder dto = JobDTO.builder();
        return dto
                .name(job.getName())
                .description(job.getDescription())
                .requierement(job.getRequierement())
                .heritatedSkill(job.getHeritatedSkill())
                .skillToChoose(job.getSkillToChoose())
                .bannedOrigin(job.getBannedOrigin())
                .build();
    }
}

