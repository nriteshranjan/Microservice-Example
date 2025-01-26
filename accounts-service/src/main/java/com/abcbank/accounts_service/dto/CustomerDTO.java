package com.abcbank.accounts_service.dto;

import lombok.*;

@ToString
@NoArgsConstructor
public class CustomerDTO {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String mobileNumber;
    @Getter
    AccountsDTO accountsDTO;

    public CustomerDTO(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }
}
