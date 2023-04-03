package be.vans.naheulbook.services.character;

import be.vans.naheulbook.models.entities.Character;
import be.vans.naheulbook.services.CrudService;

public interface CharacterService extends CrudService<Character, Integer> {

    Character save(Character entity);


}
