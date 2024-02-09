package com.Bank.application.DTO;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {
	private long id;
	private String accountHoldername;
	private double balance;
	public AccountDTO() {
		super();
	}
	public AccountDTO(long id, String accountHoldername, double balance) {
		super();
		this.id = id;
		this.accountHoldername = accountHoldername;
		this.balance = balance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountHoldername() {
		return accountHoldername;
	}
	public void setAccountHoldername(String accountHoldername) {
		this.accountHoldername = accountHoldername;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccountDTO [id=" + id + ", accountHoldername=" + accountHoldername + ", balnance=" + balance + "]";
	}
	

}
