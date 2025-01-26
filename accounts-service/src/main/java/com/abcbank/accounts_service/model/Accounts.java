package com.abcbank.accounts_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_tbl")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    private String branchAddress;

    public static void main(String[] args) {
        Accounts accounts = new Accounts();
        accounts.setAccountNumber(12L);
        System.out.println(accounts.getAccountNumber());
    }
}
