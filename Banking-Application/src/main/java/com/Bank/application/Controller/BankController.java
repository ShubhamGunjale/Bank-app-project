package com.Bank.application.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.application.DTO.AccountDTO;
import com.Bank.application.service.ServiceBank;

@RestController
@RequestMapping("/api/accounts")
public class BankController {
ServiceBank servicebank;

public BankController(ServiceBank servicebank) {
	super();
	this.servicebank = servicebank;
}
//Add Account REST Api
@PostMapping

public ResponseEntity<AccountDTO>addAccount(@RequestBody AccountDTO accountdto){
	return new ResponseEntity<>(servicebank.createAccount(accountdto),HttpStatus.ACCEPTED);
}
//get account REST API
@GetMapping("/{id}")
public ResponseEntity<AccountDTO>getAccount(@PathVariable Long id){
	AccountDTO accountDTO=servicebank.getAccountByid(id);
	return ResponseEntity.ok(accountDTO);
	
}
//Deposit Rest Api
@PutMapping("/{id}/deposit")
public ResponseEntity<AccountDTO>deposite(@PathVariable   Long id,@RequestBody  Map<String,Double>request){
 Double amount=request.get("amount");	
 AccountDTO accountdto= servicebank.deposite(id,amount);
return ResponseEntity.ok(accountdto);
}
//Withdraw REST API
@PutMapping("/{id}/withdraw")
public ResponseEntity<AccountDTO>withdraw(@PathVariable  Long id,@RequestBody Map<String,Double>request){
	double amount=request.get("amount");
	AccountDTO accountdto=servicebank.withdraw(id, amount);
	return ResponseEntity.ok(accountdto);
	
}
//Get all Accounts REST API
@GetMapping
	public ResponseEntity<List<AccountDTO>>getAllaccount(){
		List<AccountDTO>accounts=servicebank.getAllAccount();
		return ResponseEntity.ok(accounts);
		
	}
//Delete Account Rest Api
@DeleteMapping("/{id}")
public ResponseEntity<String>deleteAccount(@PathVariable Long id){
	servicebank.deleteAccount(id);
	
	return ResponseEntity.ok("Account deleted succefully");
	
}
}
