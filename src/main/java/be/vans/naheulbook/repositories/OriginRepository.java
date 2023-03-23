package be.vans.naheulbook.repositories;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Integer>, JpaSpecificationExecutor {

    Page<Origin> findAllByActive(boolean active, Pageable pageable);
}
