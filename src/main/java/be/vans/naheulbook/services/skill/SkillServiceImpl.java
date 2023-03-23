package be.vans.naheulbook.services.skill;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Skill;
import be.vans.naheulbook.repositories.SkillRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SkillServiceImpl extends CrudServiceImpl<SkillRepository, Skill, Integer> implements SkillService {
    public SkillServiceImpl(SkillRepository repository) {
        super(repository);
    }

    @Override
    public Stream<Skill> readAllByActive(Pageable pageable) {
        return this.repository.findAllByActive(true, pageable).stream();
    }
}
