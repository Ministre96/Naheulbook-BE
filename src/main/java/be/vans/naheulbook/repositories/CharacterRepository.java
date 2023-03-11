package be.vans.naheulbook.repositories;

import be.vans.naheulbook.models.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer>, JpaSpecificationExecutor {
}
