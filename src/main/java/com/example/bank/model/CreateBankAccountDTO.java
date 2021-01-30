package com.example.bank.model;

import java.math.BigDecimal;
import lombok.Value;

@Value
public class CreateBankAccountDTO {

	private final BigDecimal initialBalance;
	private final String name;
	
}
