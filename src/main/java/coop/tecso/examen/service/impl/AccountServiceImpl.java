package coop.tecso.examen.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coop.tecso.examen.dto.AccountDto;
import coop.tecso.examen.model.Account;
import coop.tecso.examen.repository.AccountRepository;
import coop.tecso.examen.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Transactional
	@Override
	public void save(AccountDto accountDto) {
		accountRepository.save(mergeEntityWithDTO(accountDto));
	}
	
	@Transactional
	public void delete(Long accountNumber) {
		accountRepository.deleteByAccountNumber(accountNumber);
	}
	
	@Transactional
	public List<AccountDto> findAll(){
		List<AccountDto> accountsDtos = new ArrayList<AccountDto>();
		List<Account> accounts = accountRepository.findAll();
		for(Account account : accounts) {
			accountsDtos.add(getDtoFromEntity(account));
		}
		
		return accountsDtos;
	}
	
	public Account mergeEntityWithDTO(AccountDto accountDto) {
		Account account = new Account();
		account.setAccountNumber(Long.valueOf(accountDto.getAccountNumber()));
		account.setCurrency(accountDto.getCurrency());
		account.setSaldo(Double.valueOf(accountDto.getSaldo()));
		account.setCreationTimestamp(new Date());
		account.setModificationTimestamp(new Date());
		account.setVersionNumber(1);
		
		return account;
	}
	
	public AccountDto getDtoFromEntity(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNumber(String.valueOf(account.getAccountNumber()));
		accountDto.setCurrency(String.valueOf(account.getCurrency()));
		accountDto.setSaldo(String.valueOf(account.getSaldo()));
		
		return accountDto;

	}
	

}
