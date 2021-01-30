package com.example.bank.resource;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.entity.BankAccount;
import com.example.bank.model.CreateBankAccountDTO;
import com.example.bank.model.MoneyDTO;
import com.example.bank.service.BankAccountCommandService;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@Api(value = "Bank  Commands")
@AllArgsConstructor
public class BankAccountCommandResource {

	 @Autowired	
	 BankAccountCommandService bankAccountCommandService;
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/accounts")
    @ResponseStatus(value = CREATED)
    public CompletableFuture<BankAccount> createAccount(@RequestBody CreateBankAccountDTO createBankAccountDTO) {
        return this.bankAccountCommandService.createAccount(createBankAccountDTO);
    }

   
   
    @RequestMapping(method = RequestMethod.PUT, value = "/withdraw/{accountId}")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountId") String accountId,
                                                           @RequestBody MoneyDTO moneyWithdrawDTO) {
        return this.bankAccountCommandService.withdrawMoneyFromAccount(accountId, moneyWithdrawDTO);
    }
    
    @PutMapping(value = "/deposite/{accountId}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountId") String accountId,
                                                          @RequestBody MoneyDTO moneyDepositeDTO) {
        return this.bankAccountCommandService.depositeMoneyToAccount(accountId, moneyDepositeDTO);
    }
}
