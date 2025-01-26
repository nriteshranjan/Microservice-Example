package com.mysite.account_service.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.account_service.model.Account;
import com.mysite.account_service.repository.AccountRepository;

@Service
public class AccountService{

    @Autowired
    private AccountRepository accountRepository;

    
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
}
