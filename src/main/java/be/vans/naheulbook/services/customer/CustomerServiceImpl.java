package be.vans.naheulbook.services.customer;

import be.vans.naheulbook.models.entities.Customer;
import be.vans.naheulbook.repositories.CustomerRepository;
import be.vans.naheulbook.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends CrudServiceImpl<CustomerRepository, Customer, Integer> implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
