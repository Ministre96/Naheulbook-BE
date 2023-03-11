package be.vans.naheulbook.services.equipment;

import be.vans.naheulbook.models.entities.Equipment;
import be.vans.naheulbook.repositories.EquipmentRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class EquipmentServiceImpl extends CrudServiceImpl<EquipmentRepository, Equipment, Integer> implements EquipmentService {
    public EquipmentServiceImpl(EquipmentRepository repository) {
        super(repository);
    }
}
