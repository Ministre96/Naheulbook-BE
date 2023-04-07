package be.vans.naheulbook.services.security;

import be.vans.naheulbook.models.entities.Customer;
import be.vans.naheulbook.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Autowired
    public UserDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String pseudo) throws UsernameNotFoundException {
        Optional<UserDetails> opt = this.customerRepository.findCustomerByPseudo(pseudo);
        return opt.orElseThrow(() -> new UsernameNotFoundException("Customer with username(" + pseudo + ") doesn't exist"));
    }
}