package be.vans.naheulbook.services.skill;

import be.vans.naheulbook.models.entities.Skill;
import be.vans.naheulbook.repositories.SkillRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl extends CrudServiceImpl<SkillRepository, Skill, Integer> implements SkillService {
    public SkillServiceImpl(SkillRepository repository) {
        super(repository);
    }
}
