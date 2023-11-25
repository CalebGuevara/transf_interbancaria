package com.crud.spring.TranfInterbancaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.spring.TranfInterbancaria.dto.TransferDTO;
import com.crud.spring.TranfInterbancaria.entity.Account;
import com.crud.spring.TranfInterbancaria.entity.Transfer;
import com.crud.spring.TranfInterbancaria.mapper.TransferMapper;
import com.crud.spring.TranfInterbancaria.service.AccountService;
import com.crud.spring.TranfInterbancaria.service.TransferService;

@RestController
@RequestMapping("/api")
public class TransferController {
	
	@Autowired
	private TransferService transferService;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/transfer")
	public ResponseEntity<String> startTransfer(@RequestBody TransferDTO transferDTO){
		Transfer transfer = TransferMapper.INSTANCE.dtoToEntity(transferDTO);
		try {
			transferService.validateTransfer(transferDTO);
			transferService.startTransfer(transfer);
			return new ResponseEntity<>("Transfer Success", HttpStatus.OK);
		} catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
	}
	
	@GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable String accountNumber) {
        Account account = accountService.getAccountByNumber(accountNumber);
        return new ResponseEntity<>(account, account != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
	
	@GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
	
	@GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return new ResponseEntity<>(account, account != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
	
}
