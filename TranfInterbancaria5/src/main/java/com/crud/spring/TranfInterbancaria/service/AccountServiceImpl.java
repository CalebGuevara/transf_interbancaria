package com.crud.spring.TranfInterbancaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crud.spring.TranfInterbancaria.entity.Account;

@Service
public class AccountServiceImpl implements AccountService{
	
	private final List<Account> accounts = new ArrayList<>();
	
	public Account getAccountById(Long id) {
		return accounts.stream()
				.filter(accounts -> accounts.getId().equals(id))
                .findFirst()
                .orElse(null);
	}
	
	public Account getAccountByNumber(String accountNumber) {
		return accounts.stream()
				.filter(account -> account.getAccountNumber().equals(accountNumber))
				.findFirst()
				.orElse(null);
		
	}
	
	public List<Account> getAllAccounts(){
		return new ArrayList<>(accounts);
	}
	
}
