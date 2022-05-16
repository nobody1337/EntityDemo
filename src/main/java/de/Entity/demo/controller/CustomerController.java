package de.Entity.demo.controller;

import de.Entity.demo.model.Customer;
import de.Entity.demo.repositorys.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    List<Customer>getCustomer(){
        return customerRepository.findAll();
    }

    @PostMapping
    Customer createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }
}
