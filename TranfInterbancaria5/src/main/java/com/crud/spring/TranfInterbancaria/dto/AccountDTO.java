package com.crud.spring.TranfInterbancaria.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
	private Long id;
	private String accountNumber;
	private BigDecimal balance;
}
