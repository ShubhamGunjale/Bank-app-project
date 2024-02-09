package com.Bank.application.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Bank.application.DTO.AccountDTO;
import com.Bank.application.Entity.Account;
import com.Bank.application.Repository.Repository;
import com.Bank.application.mapper.AccountMapper;
@Service
public class BankAPP_imp implements ServiceBank {
Repository repo;
@Autowired
	public BankAPP_imp(Repository repo) {
	super();
	this.repo = repo;
}

	@Override
	public AccountDTO createAccount(AccountDTO accountdto) {
		// TODO Auto-generated method stub
		Account account=AccountMapper.mapToAccount(accountdto);
		
		
		Account savedAccount=repo.save(account);
		
		return AccountMapper.mapToAccount(savedAccount);
	}

	@Override
	public AccountDTO getAccountByid(Long id) {
		// TODO Auto-generated method stub
		 Account account=repo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exits"));
		return AccountMapper.mapToAccount(account);
	}

	@Override
	public AccountDTO deposite(Long id, double amount) {
		 Account account=repo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exits"));
		 double total=account.getBalance()+amount;
		 account.setBalance(total);
		 Account savedAccount=repo.save(account);
		 
		 
		return AccountMapper.mapToAccount(savedAccount);
	}

	@Override
	public AccountDTO withdraw(Long id, double amount) {
		 Account account=repo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exits"));
		 if(account.getBalance()<amount) {
			 throw new RuntimeException("insufficient amount");
		 }
		 double total=account.getBalance()-amount;
		 account.setBalance(total);
		Account savedAccount= repo.save(account);
		
		 
		return AccountMapper.mapToAccount(savedAccount);
	}

	@Override
	public List<AccountDTO> getAllAccount() {
		List<Account>accounts=repo.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccount(account)).collect(Collectors.toList());
		
		
	}

	@Override
	public void deleteAccount(Long id) {
		
		 Account account=repo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exits"));
		 repo.deleteById(id);
	}
	
	
	

}
