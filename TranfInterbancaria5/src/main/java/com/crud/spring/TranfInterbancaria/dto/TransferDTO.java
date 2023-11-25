package com.crud.spring.TranfInterbancaria.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO{

	private Long id;
	
	private String sourceAccount;
	
	private String destinationAccount;
	
	private BigDecimal amount;;
	
	private String currency;
	
}
