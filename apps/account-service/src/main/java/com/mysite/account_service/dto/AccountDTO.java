package com.mysite.account_service.dto;

import jakarta.validation.constraints.NotNull;

public class AccountDTO {

    private Long id;

    @NotNull(message = "Account number is required")
    private String accountNumber;

    @NotNull(message = "Account type is required")
    private String accountType;

    @NotNull(message = "Balance is required")
    private Double balance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}
