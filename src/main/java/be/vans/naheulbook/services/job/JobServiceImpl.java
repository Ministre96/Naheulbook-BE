package be.vans.naheulbook.services.job;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.repositories.JobRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class JobServiceImpl extends CrudServiceImpl<JobRepository, Job, Integer> implements JobService {
    public JobServiceImpl(JobRepository repository) {
        super(repository);
    }

    @Override
    public Stream<Job> readAllByActive(Pageable pageable) {
        return this.repository.findAllByActive(true, pageable).stream();
    }
}
