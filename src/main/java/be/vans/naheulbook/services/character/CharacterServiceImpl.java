package be.vans.naheulbook.services.character;

import be.vans.naheulbook.models.entities.Character;
import be.vans.naheulbook.repositories.CharacterRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl extends CrudServiceImpl<CharacterRepository, Character, Integer> implements  CharacterService {
    public CharacterServiceImpl(CharacterRepository repository) {
        super(repository);
    }
}
