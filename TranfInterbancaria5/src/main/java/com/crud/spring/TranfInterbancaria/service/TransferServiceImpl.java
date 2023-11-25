package com.crud.spring.TranfInterbancaria.service;

import java.math.BigDecimal;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.spring.TranfInterbancaria.dto.TransferDTO;
import com.crud.spring.TranfInterbancaria.entity.Account;
import com.crud.spring.TranfInterbancaria.entity.Transfer;

@Service
public class TransferServiceImpl implements TransferService{
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public void startTransfer(Transfer transfer) throws BadRequestException {
		Account sourceAccount = accountService.getAccountByNumber(transfer.getSourceAccount());
		Account destinationAccount = accountService.getAccountByNumber(transfer.getDestinationAccount());
		
		if (sourceAccount != null && destinationAccount != null) {
			if (sourceAccount.getBalance().compareTo(transfer.getAmount()) >= 0) {
                sourceAccount.setBalance(sourceAccount.getBalance().subtract(transfer.getAmount()));
                destinationAccount.setBalance(destinationAccount.getBalance().add(transfer.getAmount()));
                System.out.println("Transfer success");
            } else {
                throw new BadRequestException("Insufficient balance in the source account");
            }
        } else {
            throw new BadRequestException("The account(s) do not exist");
        }
	}

	@Override
	public void validateTransfer(TransferDTO transferDTO) {
		
		if (transferDTO.getSourceAccount().equals(transferDTO.getDestinationAccount())) {
            System.out.println("Cannot transfer to your own account");
        }
		if (transferDTO.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Import must be greater than ZERO");
        }
		String currency = transferDTO.getCurrency().toUpperCase();
        if (!currency.equals("SOLES") && !currency.equals("DOLARES")) {
            System.out.println("Only soles and dollars are accepted");
        }
		
		System.out.println("Validation Success");
		
	}
	
}
