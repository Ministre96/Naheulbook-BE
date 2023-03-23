package be.vans.naheulbook.services.origin;

import be.vans.naheulbook.models.entities.Job;
import be.vans.naheulbook.models.entities.Origin;
import be.vans.naheulbook.services.CrudService;
import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

public interface OriginService extends CrudService<Origin, Integer> {

    Stream<Origin> readAllByActive(Pageable pageable);
}
