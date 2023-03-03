package be.vans.naheulbook.repositories;

import be.vans.naheulbook.models.entities.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Integer>, JpaSpecificationExecutor {
}
