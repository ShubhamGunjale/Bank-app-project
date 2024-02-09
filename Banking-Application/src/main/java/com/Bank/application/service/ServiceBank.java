package com.Bank.application.service;

import java.util.List;

import com.Bank.application.DTO.AccountDTO;


public interface ServiceBank {

	AccountDTO createAccount(AccountDTO accountdto);
	AccountDTO getAccountByid(Long id);
	AccountDTO deposite(Long id ,double amount);
	AccountDTO withdraw(Long id,double amount);
	List<AccountDTO>getAllAccount();
	void deleteAccount(Long id);
	
}
