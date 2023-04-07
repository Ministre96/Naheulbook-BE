package be.vans.naheulbook.controllers;

import be.vans.naheulbook.models.entities.Customer;
import be.vans.naheulbook.models.form.CustomerCreateForm;
import be.vans.naheulbook.services.customer.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(path = {"/customer"})
public class CustomerController {

    private final CustomerService customerService;
    private final PasswordEncoder encoder;

    public CustomerController(
            CustomerService customerService,
            PasswordEncoder encoder) {
        this.customerService = customerService;
        this.encoder = encoder;
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomerAction(
            @RequestBody CustomerCreateForm form) {
        Customer customer = form.toBll();
        customer.setPassword(encoder.encode(customer.getPassword()));
        customerService.save(customer);
        return ResponseEntity.ok(customer);
    }

}
