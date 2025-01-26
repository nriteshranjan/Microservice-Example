package com.abcbank.accounts_service.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDTO {
    private long accountNumber;
    private String accountType;
    private String branchAddress;
}
