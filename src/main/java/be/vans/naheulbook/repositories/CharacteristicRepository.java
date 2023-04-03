package be.vans.naheulbook.repositories;

import be.vans.naheulbook.models.entities.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer>, JpaSpecificationExecutor {

    Optional<Characteristic> findCharacteristicByNameAndValue(String name, int value);


}
