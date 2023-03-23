package be.vans.naheulbook.services.skill;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Skill;
import be.vans.naheulbook.services.CrudService;
import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

public interface SkillService extends CrudService<Skill, Integer> {

    Stream<Skill> readAllByActive(Pageable pageable);
}
