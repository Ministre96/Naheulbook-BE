package be.vans.naheulbook.repositories;

import be.vans.naheulbook.models.entities.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer>, JpaSpecificationExecutor {
}
