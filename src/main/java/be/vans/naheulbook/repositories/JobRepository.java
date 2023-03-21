package be.vans.naheulbook.repositories;

import be.vans.naheulbook.models.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>, JpaSpecificationExecutor {
//    @Query(value = "SELECT j FROM Job j WHERE j.active = true")
    Page<Job> findAllByActive(boolean active, Pageable pageable);
}
