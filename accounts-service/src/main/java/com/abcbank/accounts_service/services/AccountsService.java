package com.abcbank.accounts_service.services;

import com.abcbank.accounts_service.model.Accounts;
import com.abcbank.accounts_service.repositories.AccountsRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

    AccountsRepository accountsRepository;

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public void createAccount(Accounts account) {
        accountsRepository.save(account);
    }
}
