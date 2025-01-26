package com.mysite.customer_service.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mysite.customer_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mysite.customer_service.dto.CustomerDTO;
import com.mysite.customer_service.model.Customer;
import com.mysite.customer_service.services.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        // Map entities to DTOs
        return customerService.getAllCustomers().stream().map(customer -> {
            CustomerDTO dto = new CustomerDTO();
            dto.setId(customer.getId());
            dto.setName(customer.getName());
            dto.setEmail(customer.getEmail());
            dto.setAddress(customer.getAddress());
            return dto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getByIdCustomers(@PathVariable Long id) {
        // Map entities to DTOs
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new RuntimeException("Account not Found with " + id);
        }
        return ResponseEntity.ok(customer.get());
    }

    @PostMapping
    public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        // Map DTO to entity
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setAddress(customerDTO.getAddress());

        // Save and map back to DTO
        Customer savedCustomer = customerService.createCustomer(customer);
        customerDTO.setId(savedCustomer.getId());
        return customerDTO;
    }
}
