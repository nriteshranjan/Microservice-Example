package com.mysite.customer_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.customer_service.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
