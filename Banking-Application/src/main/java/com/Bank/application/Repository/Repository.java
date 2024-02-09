/**
 * 
 */
package com.Bank.application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bank.application.Entity.Account;

/**
 * 
 */
public interface Repository extends JpaRepository<Account, Long> {

}
