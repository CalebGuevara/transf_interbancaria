package com.crud.spring.TranfInterbancaria.service;

import java.util.List;

import com.crud.spring.TranfInterbancaria.entity.Account;

public interface AccountService {
	
	Account getAccountByNumber(String account);
	Account getAccountById(Long id);
	List<Account> getAllAccounts();
}
