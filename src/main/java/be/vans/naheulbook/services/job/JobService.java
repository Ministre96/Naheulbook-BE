package be.vans.naheulbook.services.job;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.services.CrudService;
import org.springframework.data.domain.Pageable;
import java.util.stream.Stream;

public interface JobService extends CrudService<Job, Integer> {

    Stream<Job> readAllByActive(Pageable pageable);
}
