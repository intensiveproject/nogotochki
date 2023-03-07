package com.aston.internship.controller;

import com.aston.internship.entity.Customer;
import com.aston.internship.entity.Details;
import com.aston.internship.entity.Producer;
import com.aston.internship.repository.CustomerRepository;
import com.aston.internship.repository.DetailsRepository;
import com.aston.internship.repository.ProducerRepository;
import com.aston.internship.dto.AppRole;
import com.aston.internship.dto.DetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final CustomerRepository customerRepository;
    private final ProducerRepository producerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(
            CustomerRepository customerRepository,
            ProducerRepository producerRepository,
            PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.producerRepository = producerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<?> registrationCustomer (@RequestBody DetailsDTO detailsDTO) {
        AppRole appRole = detailsDTO.getRole();

        Details details = new Details(
                detailsDTO.getName(),
                detailsDTO.getSurname(),
                detailsDTO.getUsername(),
                passwordEncoder.encode(detailsDTO.getPassword()),
                detailsDTO.getPhone(),
                detailsDTO.getEmail(),
                appRole
        );

        if (appRole == AppRole.ROLE_CUSTOMER) {
            customerRepository.save(new Customer(details));
        } else {
            producerRepository.save(new Producer(details));
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
