package com.Bank.application.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="accounts")

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String accountHoldername;
private double balance;
public Account() {
	super();
}
public Account(Long id, String accountHoldername, double balance) {
	super();
	this.id = id;
	this.accountHoldername = accountHoldername;
	this.balance = balance;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
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
	return "Account [id=" + id + ", accountHoldername=" + accountHoldername + ", balance=" + balance + "]";
}


}
