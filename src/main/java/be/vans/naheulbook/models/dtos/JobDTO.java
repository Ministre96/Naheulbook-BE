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

    private String desription;

    private List<Characteristic> requierement;

    private List<Skill> heritatedSkill;

    private List<Skill> skillToChose;

    private List<Origin> bannedOrigin;

    public static JobDTO toDTO(Job job) {
        JobDTO.JobDTOBuilder dto = JobDTO.builder();
        return dto
                .name(job.getName())
                .desription(job.getDesription())
                .requierement(job.getRequierement())
                .heritatedSkill(job.getHeritatedSkill())
                .skillToChose(job.getSkillToChose())
                .bannedOrigin(job.getBannedOrigin())
                .build();
    }
}

