package be.vans.naheulbook.repositories;

import be.vans.naheulbook.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor {

    Optional<UserDetails> findCustomerByPseudo(String pseudo);
}
