package be.vans.naheulbook.services.characteristic;

import be.vans.naheulbook.models.entities.Characteristic;
import be.vans.naheulbook.repositories.CharacteristicRepository;
import be.vans.naheulbook.services.CrudServiceImpl;

public class CharacteristicServiceImpl extends CrudServiceImpl<CharacteristicRepository, Characteristic, Integer> implements CharacteristicService {
    public CharacteristicServiceImpl(CharacteristicRepository repository) {
        super(repository);
    }
}
