package be.vans.naheulbook.services.job;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.repositories.JobRepository;
import be.vans.naheulbook.services.CrudServiceImpl;

public class JobServiceImpl extends CrudServiceImpl<JobRepository, Job, Integer> implements JobService {
    public JobServiceImpl(JobRepository repository) {
        super(repository);
    }
}
