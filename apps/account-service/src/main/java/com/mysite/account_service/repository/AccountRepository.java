package com.mysite.account_service.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.account_service.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
