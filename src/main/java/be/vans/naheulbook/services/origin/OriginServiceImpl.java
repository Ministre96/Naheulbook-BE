package be.vans.naheulbook.services.origin;

import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.repositories.OriginRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OriginServiceImpl extends CrudServiceImpl<OriginRepository, Origin, Integer> implements OriginService {
    public OriginServiceImpl(OriginRepository repository) {
        super(repository);
    }
}
