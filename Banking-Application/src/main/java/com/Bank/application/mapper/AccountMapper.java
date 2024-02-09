package com.Bank.application.mapper;

import com.Bank.application.DTO.AccountDTO;
import com.Bank.application.Entity.Account;

public class AccountMapper {
	public static Account mapToAccount(AccountDTO accontdto) {
		
		Account account=new Account(
				accontdto.getId(),
				accontdto.getAccountHoldername(),
				accontdto.getBalance()
				);
		return account;
		
	}
public static AccountDTO mapToAccount(Account accontdto) {
		
		AccountDTO accountdto=new AccountDTO(
				accontdto.getId(),
				accontdto.getAccountHoldername(),
				accontdto.getBalance()
				);
		return accountdto;
		
	}
}
