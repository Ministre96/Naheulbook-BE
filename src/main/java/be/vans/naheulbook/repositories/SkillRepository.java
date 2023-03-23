package be.vans.naheulbook.repositories;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Skill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>, JpaSpecificationExecutor {

    Page<Skill> findAllByActive(boolean active, Pageable pageable);
}
