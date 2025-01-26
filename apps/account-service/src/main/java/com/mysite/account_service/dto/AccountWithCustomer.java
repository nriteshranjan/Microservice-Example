package com.mysite.account_service.dto;

import com.mysite.account_service.model.Account;

public class AccountWithCustomer {
    private Account account;
    private Customer customer;

    public AccountWithCustomer(Account account, Customer customer) {
        this.account = account;
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
