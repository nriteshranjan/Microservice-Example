package com.mysite.customer_service.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.customer_service.model.Customer;
import com.mysite.customer_service.repositories.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
