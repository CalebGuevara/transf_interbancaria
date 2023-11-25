package com.crud.spring.TranfInterbancaria.service;

import org.apache.coyote.BadRequestException;

import com.crud.spring.TranfInterbancaria.dto.TransferDTO;
import com.crud.spring.TranfInterbancaria.entity.Transfer;

public interface TransferService {
	
	void startTransfer(Transfer transfer) throws BadRequestException;
	
	void validateTransfer(TransferDTO transfer);
	
}
