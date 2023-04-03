package be.vans.naheulbook.services.character;

import be.vans.naheulbook.models.entities.Character;
import be.vans.naheulbook.models.entities.*;
import be.vans.naheulbook.repositories.*;
import be.vans.naheulbook.repositories.CharacterRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl extends CrudServiceImpl<CharacterRepository, Character, Integer> implements  CharacterService {

    private final JobRepository jobRepository;
    private final OriginRepository originRepository;
    private final SkillRepository skillRepository;
    private final CharacteristicRepository characteristicRepository;
    public CharacterServiceImpl(CharacterRepository repository,
                                JobRepository jobRepository,
                                OriginRepository originRepository,
                                SkillRepository skillRepository, CharacteristicRepository characteristicRepository) {
        super(repository);
        this.jobRepository = jobRepository;
        this.originRepository = originRepository;
        this.skillRepository = skillRepository;
        this.characteristicRepository = characteristicRepository;
    }


    @Override
    public Character save(Character character) {
        Optional<Job> optJob = this.jobRepository.findById(character.getJob().getId());
        Job job = optJob.get();
        Optional<Origin> optOrigin = this.originRepository.findById(character.getOrigin().getId());
        Origin orgin = optOrigin.get();
        List<Skill> skills = new ArrayList<>();
        for (Skill skill:
             character.getSkills()) {
            Optional<Skill> optSkill = this.skillRepository.findById(skill.getId());
            skills.add(optSkill.get());
        }
        List<Characteristic> characteristics = new ArrayList<>();
        for (Characteristic charac :
            character.getStats()) {
            Characteristic tempCharac = Characteristic.builder()
                    .name(charac.getName())
                    .value(charac.getValue())
                    .build();
            characteristics.add(tempCharac);
        }
        this.characteristicRepository.saveAll(characteristics);
        character.setJob(job);
        character.setOrigin(orgin);
        character.setSkills(skills);
        character.setStats(characteristics);

        return (Character) this.repository.save(character);
    }
}
