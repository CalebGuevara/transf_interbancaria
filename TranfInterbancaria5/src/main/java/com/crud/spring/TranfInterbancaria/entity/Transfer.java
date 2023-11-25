package com.crud.spring.TranfInterbancaria.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String sourceAccount;
	
	@Column(nullable = false)
	private String destinationAccount;
	
	@Column(nullable = false) //importe = amount
	private BigDecimal amount;;
	
	@Column(nullable = false) //moneda = currency
	private String currency;
	
}
