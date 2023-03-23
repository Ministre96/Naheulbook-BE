package be.vans.naheulbook.services.origin;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.repositories.OriginRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class OriginServiceImpl extends CrudServiceImpl<OriginRepository, Origin, Integer> implements OriginService {
    public OriginServiceImpl(OriginRepository repository) {
        super(repository);
    }

    @Override
    public Stream<Origin> readAllByActive(Pageable pageable) {
        return this.repository.findAllByActive(true, pageable).stream();
    }
}
