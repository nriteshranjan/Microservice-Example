package com.mysite.account_service.controller;

import com.mysite.account_service.dto.AccountWithCustomer;
import com.mysite.account_service.dto.Customer;
import com.mysite.account_service.exceptions.InvalidInputException;
import com.mysite.account_service.exceptions.ResourceNotFoundException;
import com.mysite.account_service.model.Account;
import com.mysite.account_service.repository.AccountRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final String CUSTOMER_SERVICE_URL = "http://localhost:8081/customers";
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RestTemplate restTemplate;

    // Create Account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {

        if (account.getBalance() < 0) {
            throw new InvalidInputException("Balance cannot be negative");
        }
        Account savedAccount = accountRepository.save(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()) {
            throw new ResourceNotFoundException("Account not Found with " + id);
        }
        return ResponseEntity.ok(account.get());
    }

    // Inter-Service Communication: Get Customer Details by customerId
    // http://localhost:8082/accounts/1/customer
    @CircuitBreaker(name = "customerServiceCircuitBreaker", fallbackMethod = "fallbackGetCustomerDetails")
    @GetMapping("/{accountId}/customer")
    public ResponseEntity<?> getCustomerDetails(@PathVariable Long accountId) {
        // Retrieve Account
        Optional<Account> accountOpt = accountRepository.findById(accountId);
        if (accountOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Account account = accountOpt.get();

        // Call Customer Service using RestTemplate
        String customerServiceUrl = CUSTOMER_SERVICE_URL + "/" + account.getCustomerId();
        Customer customer = restTemplate.getForObject(customerServiceUrl, Customer.class);

        // Combine Account and Customer Info
        return ResponseEntity.ok(new AccountWithCustomer(account, customer));
    }

    // Fallback Method for Circuit Breaker
    public ResponseEntity<?> fallbackGetCustomerDetails(Long accountId, Throwable ex) {
        return ResponseEntity.ok("Customer service is currently unavailable. Please try again later.");
    }
}
